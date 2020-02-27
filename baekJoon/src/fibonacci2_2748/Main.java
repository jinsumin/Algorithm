package fibonacci2_2748;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-29.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();
        int n = scanner.nextInt();
        System.out.println(sol.dynamicFibonacci(n));
    }
}

class Solution {
    public int dynamicFibonacci(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
