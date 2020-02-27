package find_path_11403;

import java.util.Scanner;

/**
 * Created by REMI on 2020-02-21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        solution.solution(map, n);
    }
}

class Solution {
    public void solution(int[][] map, int n) {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                for(int k = 0; k < n; k ++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        print(map, n);
    }

    private void print(int[][] map, int n) {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
