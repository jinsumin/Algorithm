package integrate_2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-10.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(n, k));
    }
}

class Solution {
    private static final int MOD = 1000000000;

    public int solution(int n, int k) {
        int[][] memo = new int[k + 1][n + 1];
        for(int i = 0; i <= n; i ++) {
            memo[1][i] = 1;
        }
        for(int i = 1; i <= k; i ++) {
            for(int j = 0; j <= n; j ++) {
                for(int l = 0; l <= j; l ++) {
                    memo[i][j] = (memo[i - 1][j - l] + memo[i][j]) % MOD;
                }
            }
        }
        return memo[k][n];
    }
}
