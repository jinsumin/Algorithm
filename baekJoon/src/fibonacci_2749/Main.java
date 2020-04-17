package fibonacci_2749;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-09.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long number = Long.parseLong(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(number));
    }
}

class Solution {
    private static final int MOD = 1000000;
    public long solution(long number) {
        long[] memo = new long[Integer.MAX_VALUE];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= number; i ++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % MOD;
        }
        return memo[(int) number];
    }
}
