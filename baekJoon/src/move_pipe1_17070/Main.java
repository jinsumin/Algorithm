package move_pipe1_17070;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-28.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
        System.out.println(sol.numberOfCases());
    }
}

class Solution {
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private enum Type {
        HORIZONTAL, VERTICAL, DIAGONAL
    }
    private class Pipe {
        int r, c;
        Type type;
        public Pipe(int r, int c, Type type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
    private static int[][] map;
    private static int destOfR,destOfC;
    private static int numberOfCases;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        map = new int[n + 2][n + 2];
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                map[i][j] = scanner.nextInt();
            }
        }
        destOfR = n;
        destOfC = n;
        numberOfCases = 0;
        initMap();
        Pipe pipe = new Pipe(1, 2, Type.HORIZONTAL);
        move(pipe);
    }

    private void initMap() {
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[i].length; j ++) {
                map[0][j] = WALL;
                map[map.length - 1][j] = WALL;
                map[i][0] = WALL;
                map[i][map[i].length - 1] = WALL;
            }
        }
    }

    private void move(Pipe pipe) {
        if(pipe.r == destOfR && pipe.c == destOfC) {
            numberOfCases ++;
            return;
        }
        switch (pipe.type) {
            case HORIZONTAL:
                if(map[pipe.r][pipe.c + 1] == EMPTY) {
                    move(new Pipe(pipe.r, pipe.c + 1, Type.HORIZONTAL));
                }
                if(map[pipe.r][pipe.c + 1] == EMPTY && map[pipe.r + 1][pipe.c] == EMPTY
                        && map[pipe.r + 1][pipe.c + 1] == EMPTY) {
                    move(new Pipe(pipe.r + 1, pipe.c + 1, Type.DIAGONAL));
                }
                break;
            case VERTICAL:
                if(map[pipe.r + 1][pipe.c] == EMPTY) {
                    move(new Pipe(pipe.r + 1, pipe.c, Type.VERTICAL));
                }
                if(map[pipe.r][pipe.c + 1] == EMPTY && map[pipe.r + 1][pipe.c] == EMPTY
                        && map[pipe.r + 1][pipe.c + 1] == EMPTY) {
                    move(new Pipe(pipe.r + 1, pipe.c + 1, Type.DIAGONAL));
                }
                break;
            case DIAGONAL:
                if(map[pipe.r][pipe.c + 1] == EMPTY) {
                    move(new Pipe(pipe.r, pipe.c + 1, Type.HORIZONTAL));
                }
                if(map[pipe.r + 1][pipe.c] == EMPTY) {
                    move(new Pipe(pipe.r + 1, pipe.c, Type.VERTICAL));
                }
                if(map[pipe.r][pipe.c + 1] == EMPTY && map[pipe.r + 1][pipe.c] == EMPTY
                        && map[pipe.r + 1][pipe.c + 1] == EMPTY) {
                    move(new Pipe(pipe.r + 1, pipe.c + 1, Type.DIAGONAL));
                }
                break;
        }
    }

    public int numberOfCases() {
        return numberOfCases;
    }
}
