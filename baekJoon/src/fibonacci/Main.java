package fibonacci;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-29.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static int[] memo = new int[100];
    public void solution() {
        Arrays.fill(memo, 0);
        memo[1] = 1;
        memo[2] = 1;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(normalFibonacci(n));
        System.out.println(memoizationFibonacci(n));
        System.out.println(dynamicFibonacci(10));
    }

    public int normalFibonacci(int n) {
        if(n <= 2) {
            return 1;
        }
        return normalFibonacci(n - 1) + normalFibonacci(n - 2);
    }

    public int memoizationFibonacci(int n) {
        if(memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = memoizationFibonacci(n - 1) + memoizationFibonacci(n - 2);
    }

    public int dynamicFibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 2; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
