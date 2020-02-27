package tettris_3019;

import java.util.Scanner;

/**
 * Created by REMI on 2020-02-13.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int p = scanner.nextInt();
        int[][] map = new int[105][c + 1];
        for(int j = 1; j <= p; j ++) {
            map[0][j] = scanner.nextInt();
        }
    }
}

class Solution {
    public void solution(int[] map) {
    }
}
