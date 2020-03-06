package tiling_2xn_11726;

import java.util.Scanner;

/**
 * Created by REMI on 2020-03-05.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    private static final int MOD = 10007;
    public int solution(int n) {
        int[] memo = new int[n + 1];
        if(n == 1) {
            return 1;
        }
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2; i <= n; i ++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % MOD;
        }
        return memo[n];
    }
}
