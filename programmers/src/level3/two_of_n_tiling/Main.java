package level3.two_of_n_tiling;

        import java.util.Arrays;
        import java.util.Scanner;

/**
 * Created by REMI on 2020-01-16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println(sol.solution(scanner.nextInt()));
    }
}

class Solution {
    private static int horizontal = 0;
    private static int[] memo;
    private static int[] tile;
    private static int[][] pascal;
    public int solution(int n) {
        /*int answer = 0;
        tile = new int[n + 1];
        Arrays.fill(tile, 0);
        tile[1] = 1;
        tile[2] = 2;
        memo = new int[n + 1];
        memo[0] = 1;
        for(int i = 1; i <= 2; i ++) {
            for(int j = tile[i]; j <= n; j ++) {
                memo[j] += memo[j - tile[i]];
            }
        }
        answer = memo[n];
        return answer;*/
        /*pascal = new int[n + 1][n + 1];
        for(int i = 0; i < pascal.length; i ++) {
            for(int j = 0; j < pascal[i].length; j ++) {
                if(j == 0 || i == j) {
                    pascal[i][j] = 1;
                }else if(i > j) {
                    pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
                }
            }
        }
        for(int i = n; i >= (n + 1) / 2; i --) {
            answer += pascal[i][n - i];
        }*/
        /*pascal = new int[n + 1][n + 1];
        for(int i = n; i >= (n + 1) / 2; i --) {
            answer += getComb(pascal, i, n - i);
        }
        return answer;*/

        int answer = 0;

        answer = dynamicFibonacci(n);

        return answer;
    }

    /*private int getComb(int[][] arr, int l, int k) {
        if(k==1){
            arr[l][k] = l;
            return l;
        }
        if(k==0){
            arr[l][k] = 1;
            return 1;
        }
        if(l==k){
            arr[l][k] = 1;
            return 1;
        }
        if(arr[l][k]!=0){
            return arr[l][k];
        }
        arr[l][k] = getComb(arr,l-1,k) + getComb(arr,l-1,k-1);
        return arr[l][k];
    }*/

    private static int dynamicFibonacci(int n) {
        int last1, last2, result = 0;

        if(n <= 1)
            return 1;

        last1 = 1;
        last2 = 1;

        for(int i=1; i < n; i++) {
            result = last1 + last2;
            last1 = last2;
            last2 = result;
        }

        return result % 1000000007;
    }
}
