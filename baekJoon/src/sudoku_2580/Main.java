package sudoku_2580;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        solution.solution(map);
    }
}

class Solution {
    private boolean[][] visitedR;
    private boolean[][] visitedC;
    private boolean[][] visitedBox;
    private List<Pair> list;

    private class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void solution(int[][] map) {
        visitedR = new boolean[9][9];
        visitedC = new boolean[9][9];
        visitedBox = new boolean[9][9];
        list = new LinkedList<>();
        findBlank(map);
        dfs(map, 0);
    }

    private void findBlank(int[][] map) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (map[r][c] == 0) {
                    list.add(new Pair(r, c));
                } else {
                    visitedR[r][map[r][c] - 1] = true;
                    visitedC[c][map[r][c] - 1] = true;
                    visitedBox[(r / 3) * 3 + (c / 3)][map[r][c] - 1] = true;
                }
            }
        }
    }

    private void dfs(int[][] map, int index) {
        if(index == list.size()) {
            print(map);
            System.out.println();
            return;
            //System.exit(0);
        }

        for(int number = 1; number <= 9; number++) {
            Pair temp = list.get(index);
            if(visitedR[temp.r][number - 1]) {
                continue;
            }
            if(visitedC[temp.c][number - 1]) {
                continue;
            }
            if(visitedBox[(temp.r / 3) * 3 + (temp.c / 3)][number - 1]) {
                continue;
            }
            visitedR[temp.r][number - 1] = true;
            visitedC[temp.c][number - 1] = true;
            visitedBox[(temp.r / 3) * 3 + (temp.c / 3)][number - 1] = true;
            map[temp.r][temp.c] = number;
            dfs(map, index + 1);
            map[temp.r][temp.c] = 0;
            visitedR[temp.r][number - 1] = false;
            visitedC[temp.c][number - 1] = false;
            visitedBox[(temp.r / 3) * 3 + (temp.c / 3)][number - 1] = false;
        }
    }

    private void print(int[][] map) {
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}
