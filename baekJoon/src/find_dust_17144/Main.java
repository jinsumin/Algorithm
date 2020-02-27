package find_dust_17144;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-23.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private static int[][] map;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int t = scanner.nextInt();
        map = new int[r][c];
        for(int i = 0; i < r; i ++) {
            for(int j = 0; j < c; j ++) {
                map[i][j] = scanner.nextInt();
            }
        }

    }
}
