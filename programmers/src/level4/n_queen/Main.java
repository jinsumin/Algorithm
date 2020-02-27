package level4.n_queen;

import java.util.Scanner;

/**
 * Created by REMI on 2020-02-12.
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
    private static int[] memo;
    public int solution(int n) {
        int answer = 0;
        memo = new int[n + 1];
        if(n < 4) {
            return answer;
        } else {
            memo[3] = 0;
            memo[4] = 2;
            for(int i = 4; i <= n; i ++) {
                memo[i] += memo[i - 1] * 4;
            }
        }
        answer = memo[n];
        return answer;
    }
}
