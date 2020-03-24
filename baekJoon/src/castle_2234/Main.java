package castle_2234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-03-24.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][][] map = new int[m][n][5];
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j][0] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        solution.solution(map, m, n);
    }
}

class Solution {
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};
    private static final int SOUTH = 1;
    private static final int EAST = 2;
    private static final int NORTH = 3;
    private static final int WEST = 4;

    private int countArea = 0;
    private int distance;
    private List<Integer> depth = new LinkedList<>();

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void solution(int[][][] map, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        erectWalls(map, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    distance = 1;
                    visited[i][j] = true;
                    dfs(map, visited, new Node(i, j));
                    depth.add(distance);
                    countArea++;
                }
            }
        }
        depth.sort(Collections.reverseOrder());
        System.out.println(countArea);
        System.out.println(depth.get(0));

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= 4; k++) {
                    boolean flag = false;
                    if (map[i][j][k] == 1) {
                        flag = true;
                        map[i][j][k] = 0;
                    }
                    if (!visited[i][j]) {
                        distance = 1;
                        visited[i][j] = true;
                        dfs(map, visited, new Node(i, j));
                        depth.add(distance);
                        visited = new boolean[m][n];
                    }
                    if (flag) {
                        map[i][j][k] = 1;
                    }
                }
            }
        }

        depth.sort(Collections.reverseOrder());
        System.out.println(depth.get(0));
    }

    private void erectWalls(int[][][] map, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j][0] / 8 == 1) {
                    map[i][j][SOUTH] = 1;
                    map[i][j][0] -= 8;
                }
                if (map[i][j][0] / 4 == 1) {
                    map[i][j][EAST] = 1;
                    map[i][j][0] -= 4;
                }
                if (map[i][j][0] / 2 == 1) {
                    map[i][j][NORTH] = 1;
                    map[i][j][0] -= 2;
                }
                if (map[i][j][0] == 1) {
                    map[i][j][WEST] = 1;
                    map[i][j][0] -= 1;
                }
            }
        }
    }

    private void dfs(int[][][] map, boolean[][] visited, Node currentNode) {
        for (int i = 0; i < 4; i++) {
            Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]); // 북 동 남 서
            if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map[0].length) {
                continue;
            }
            if (map[currentNode.r][currentNode.c][i + 1] == 1) {
                continue;
            }
            if (visited[nextNode.r][nextNode.c]) {
                continue;
            }
            visited[nextNode.r][nextNode.c] = true;
            distance++;
            dfs(map, visited, nextNode);
        }
    }
}
