package population_movement_16234;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-01.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 땅의 크기 n X n
        int l = scanner.nextInt();  // 인구차이 최소 l
        int r = scanner.nextInt();  // 인구차이 최대 r
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        Solution sol = new Solution();
        sol.solution(a, n, l, r);
    }
}

class Solution {
    private static int sizeOfMap, left, right;
    private static final int RIGHT = 0;
    private static final int[] dy = {0, -1, 0, 1};
    private static final int[] dx = {-1, 0, 1, 0};

    private class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] a, int n, int l, int r) {
        sizeOfMap = n;
        left = l;
        right = r;
        int movementCount = 0;
        while (populationDifferenceCheck(a)) {
            boolean[][] visited = new boolean[n][n];
            Arrays.fill(visited, false);
            setUnion(a, visited, n);
            movementCount++;
        }
        return movementCount;
    }

    private boolean populationDifferenceCheck(int[][] a) {
        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= 0 && nx >= 0 && ny < sizeOfMap && nx < sizeOfMap) {
                        if (Math.abs(a[i][j] - a[ny][nx]) >= left && Math.abs(a[i][j] - a[ny][nx]) <= right) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void setUnion(int[][] a, boolean[][] visited, int n) {
        List<Pair> list;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    list = new LinkedList<>();
                    list.add(new Pair(i, j));
                    int unionPopulation = findUnion(a, visited, list, n, i, j, 0);
                    if (list.size() > 1) {
                        movePopulation(a, list, unionPopulation);
                    }
                }
            }
        }
    }

    private int findUnion(int[][] a, boolean[][] visited, List<Pair> list, int n, int r, int c, int unionPopulation) {
        visited[r][c] = true;
        unionPopulation = a[r][c];
        for(int k = 0; k < 4; k ++) {
            int nr = r + dy[k];
            int nc = c + dx[k];
            if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                if (!visited[nr][nc] && Math.abs(a[r][c] - a[nr][nc]) >= left && Math.abs(a[r][c] - a[nr][nc]) >= right) {
                    list.add(new Pair(nr, nc));
                    unionPopulation += findUnion(a, visited, list, n, nr, nc, unionPopulation);
                }
            }
        }
        return unionPopulation;
    }

    private void movePopulation(int[][] a, List<Pair> list, int unionPopulation) {
        int index = 0;
        while(list.isEmpty()) {
            int r = list.get(index).r;
        }
    }
}
