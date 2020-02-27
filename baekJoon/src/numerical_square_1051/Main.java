package numerical_square_1051;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-29.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private static int[][] memo;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        memo = new int[n][m];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                memo[i][j] = scanner.nextInt();
            }
        }
    }
}
