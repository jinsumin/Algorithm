package ascending_number_11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by REMI on 2020-03-06.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    private static final int MOD = 10007;

    public int solution(int n) {
        int answer = 0;
        int[][] memo = new int[n + 1][10];
        for (int i = 1; i <= n; i++) {
            for(int j = 0; j < 10; j ++) {
                if( i == 1 || j == 0) {
                    memo[i][j] = 1;
                    continue;
                }
                memo[i][j] = (memo[i][j - 1] + memo[i - 1][j]) % MOD;
            }
        }
        for (int i = 0; i < 10; i ++) {
            answer = (memo[n][i] + answer) % MOD;
        }
        return answer;
    }
}
