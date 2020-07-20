package repaint_the_chessboard_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-07-20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i ++) {
            String board = bufferedReader.readLine();
            for (int j = 0; j < m; j ++) {
                if(board.charAt(j) == 'B') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private static final int BLACK = 0;
    private static final int WHITE = 1;

    public int solution(int[][] map) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= map.length - 8; i ++) {
            for (int j = 0; j <= map[i].length - 8; j ++) {
                int repaintCountStartWithBlack = calculateRepaintCount(map, i, j, BLACK);
                int repaintCountStartWithWhite = calculateRepaintCount(map, i, j, WHITE);
                int min = Math.min(repaintCountStartWithBlack, repaintCountStartWithWhite);
                if (min < answer) {
                    answer = min;
                }
            }
        }
        return answer;
    }

    private int calculateRepaintCount(int[][] map, int i, int j, int startColor) {
        int count = 0;
        for (int startI = i; startI < i + 8; startI ++) {
            int currentStartColor = (startI + startColor) % 2;
            int temp = 0;
            for (int startJ = j; startJ < j + 8; startJ ++) {
                if (map[startI][startJ] != (currentStartColor + temp) % 2) {
                    count++;
                }
                temp ++;
            }
        }
        return count;
    }
}
