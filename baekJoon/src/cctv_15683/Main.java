/*
package cctv_15683;

import java.util.*;

*/
/**
 * Created by REMI on 2020-02-10.
 *//*

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution sol = new Solution();
        sol.solution(map);
    }
}

class Solution {
    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int CCTV_1 = 1;    // up, down, left, right
    private static final int CCTV_2 = 2;    // left-right, up-down
    private static final int CCTV_3 = 3;    // up-right, right-down, down-left, left-up
    private static final int CCTV_4 = 4;    // up, left, down, right
    private static final int CCTV_5 = 5;    // up-left-down-right
    private static final int EMPTY = 0;
    private static final int WALL = 6;

    private List<CCTV> cctvs = new LinkedList<>();
    private List<Integer> areas = new ArrayList<>();

    private class CCTV {
        int type;
        int direction;
        int indexI, indexJ;

        public CCTV(int type, int direction, int indexI, int indexJ) {
            this.type = type;
            this.direction = direction;
            this.indexI = indexI;
            this.indexJ = indexJ;
        }
    }

    public void solution(int[][] map) {
        findCCTV(map);
        Iterator<CCTV> iterator = cctvs.iterator();
        while(iterator.hasNext()) {
            CCTV currentCCTV = iterator.next();
            findArea(currentCCTV, 0);
        }
    }

    private void findCCTV(int[][] map) {
        for(int i = 0; i < map.length; i ++)
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == CCTV_1) {
                    cctvs.add(new CCTV(CCTV_1, UP, i, j));
                } else if (map[i][j] == CCTV_2) {
                    cctvs.add(new CCTV(CCTV_2, UP, i, j));
                } else if (map[i][j] == CCTV_3) {
                    cctvs.add(new CCTV(CCTV_3, UP, i, j));
                } else if (map[i][j] == CCTV_4) {
                    cctvs.add(new CCTV(CCTV_4, UP, i, j));
                } else if (map[i][j] == CCTV_5) {
                    cctvs.add(new CCTV(CCTV_5, UP, i, j));
                }
            }
    }
}
*/
