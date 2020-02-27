package omok_2615;

import java.util.Scanner;

/**
 * Created by REMI on 2020-02-12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] map = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        OMok oMok = new OMok();
        oMok.play(map);
    }
}

class OMok {
    private static final int[] DIRECTION_I = {-1, 0, 1, 1};
    private static final int[] DIRECTION_J = {1, 1, 1, 0};

    public void play(int[][] map) {
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (map[i][j] != 0) {
                    if (isOMok(map, i, j)) {
                        if (map[i][j] == 1) {
                            System.out.println(1);
                            System.out.println(i + 1 + " " + j + 1);
                            return;
                        } else if (map[i][j] == 2) {
                            System.out.println(2);
                            System.out.println(i + 1 + " " + j + 1);
                            return;
                        }
                    }
                }
            }
        }
    }

    private boolean isOMok(int[][] map, int i, int j) {
        for (int t = 0; t < 4; t++) {
            if ((i + DIRECTION_I[t] >= 0 && i + DIRECTION_I[t] < 19) &&
                    (i + DIRECTION_I[t] >= 0 && (i + DIRECTION_I[t]) * 2 < 19) &&
                    (i + DIRECTION_I[t] >= 0 && (i + DIRECTION_I[t]) * 3 < 19) &&
                    (i + DIRECTION_I[t] >= 0 && (i + DIRECTION_I[t]) * 4 < 19) &&
                    (i + DIRECTION_I[t] >= 0 && (i + DIRECTION_I[t]) < 19)) {
                if ((map[i][j] == map[i + DIRECTION_I[t]][j + DIRECTION_J[t]]) &&
                        (map[i][j] == map[i + (DIRECTION_I[t]) * 2][j + (DIRECTION_J[t]) * 2]) &&
                        (map[i][j] == map[i + (DIRECTION_I[t]) * 3][j + (DIRECTION_J[t]) * 3]) &&
                        (map[i][j] == map[i + (DIRECTION_I[t]) * 4][j + (DIRECTION_J[t]) * 4]) &&
                        (map[i][j] == map[i + (DIRECTION_I[t]) * 5][j + (DIRECTION_J[t]) * 5])) {
                    return true;
                }
            }
        }
        return false;
    }
}
