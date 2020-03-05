package rgb_distance_1149;

import java.util.Scanner;

/**
 * Created by REMI on 2020-03-05.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][3];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < 3; j ++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, n));
    }
}

class Solution {
    public int solution(int[][] map, int n) {
        for(int i = 1; i < n; i ++) {
            map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
            map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
            map[i][2] += Math.min(map[i - 1][0], map[i - 1][1]);
        }
        return Math.min(Math.min(map[n - 1][0], map[n - 1][1]), map[n - 1][2]);
    }
}
