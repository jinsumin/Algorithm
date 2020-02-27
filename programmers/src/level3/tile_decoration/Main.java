package level3.tile_decoration;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println(sol.solution(scanner.nextInt()));
    }
}

class Solution {
    private static long[] memo = new long[81];

    public long solution(int N) {
        long answer = 0;
        memo[0] = 0;
        memo[1] = 1;
        fibonacci(N);
        answer = circumference(N);
        return answer;
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return memo[n];
        }
    }

    private long circumference(int n) {
        if(n == 1) {
            return 1;
        } else {
            return ((memo[n] + memo[n - 1] + memo[n - 1] + memo[n - 2]) * 2);
        }
    }
}
