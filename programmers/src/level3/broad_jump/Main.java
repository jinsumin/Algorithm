package level3.broad_jump;

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
    private static long[] memo;
    public long solution(int n) {
        long answer = 0;
        memo = new long[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i <= n; i ++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }
        answer = memo[n];
        return answer;
    }
}
