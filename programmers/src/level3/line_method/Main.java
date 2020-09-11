package level3.line_method;

import java.util.Arrays;

/**
 * Created by Crab on 2020-09-09.
 */
public class Main {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(n, k)));
    }
}

class Solution {
    private static int count = 0;

    public int[] solution(int n, long k) {
        int[] answer = {};
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = i + 1;
        }
        answer = new int[n];
        boolean[] visited = new boolean[n];
        int[] temp = new int[n];
        permutation(arr, temp, answer, visited, 0, n, k);
        return answer;
    }

    public void permutation(int[] arr, int[] temp, int[] answer, boolean[] visited, int depth, int n, long k) {
        if (depth == n) {
            count++;
            if (count == k) {
                if (n >= 0) System.arraycopy(temp, 0, answer, 0, n);
                return;
            }
        }

        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                permutation(arr, temp, answer, visited, depth + 1, n, k);
                visited[i] = false;
            }
        }
    }
}
