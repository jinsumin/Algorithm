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
    public int solution(int n) {
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        if(n < 3) {
            return memo[n - 1];
        }
        for(int i = 2; i < n; i ++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
        }
        return memo[n - 1];
    }
}
