package prob4;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-09.
 */

public class Main {
    private static final int CONST = 1000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Solution sol = new Solution(w, h);
        System.out.println((sol.solution(x, y) * (sol.solution(w - x + 1, h - y + 1))) % CONST);
    }
}

class Solution {
    private long[][] memo;

    public Solution(int n, int m) {
        memo = new long[n + 1][m + 1];
    }

    public long solution(int n, int m){
        if(n < 1 || m < 1) return 0;
        if(n == 1 || m == 1) return 1;
        if(memo[n][m] != 0) return memo[n][m];
        memo[n][m] = solution(n - 1, m) + solution(n, m - 1);
        return memo[n][m];
    }
}
