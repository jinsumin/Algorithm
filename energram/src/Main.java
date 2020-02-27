/**
 * Created by REMI on 2019-12-31.
 */

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] clothes = {{0, 2}, {1, 1}, {2, 3}};
        System.out.println(solution.solution(clothes));
    }
}

class Solution {
    private static int result = 0;

    public int solution(String[][] clothes) {
        // clothes [name of clothes] [kind of clothes]
        int answer = 0;
        int[] comb = new int[clothes[0].length];
        boolean[] visited = new boolean[comb.length];
        for(int i = 0; i < comb.length; i ++){
            comb[i] = clothes[i].length;
        }
        for(int i = 1; i <= clothes[0].length; i ++) {
            combination(comb, visited, 0, clothes[0].length, i);
        }
        answer = result;
        return answer;
    }

    public void combination(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            calc(arr, visited, n);
            return;
        }
        if(depth == n){
            return;
        }
        else {
            visited[depth] = true;
            combination(arr, visited, depth + 1, n, r - 1);

            visited[depth] = false;
            combination(arr, visited, depth + 1, n, r);
        }
    }

    private void calc(int[] arr, boolean[] visited, int n) {
        int temp = 1;
        for(int i = 0; i < n; i ++){
            if(visited[i]){
                temp *= arr[i];
            }
        }
        result += temp;
    }
}
