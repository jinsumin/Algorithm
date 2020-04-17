package tomato_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-08.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int h = Integer.parseInt(stringTokenizer.nextToken());
        int[][][] map = new int[n][m][h];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, n, m, h));
    }
}

class Solution {
    private static class Node {
        int i, j, k;

        public Node(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    private static final int[] MOVE_I = {1, -1, 0, 0, 0, 0};
    private static final int[] MOVE_J = {0, 0, 1, -1, 0, 0};
    private static final int[] MOVE_K = {0, 0, 0, 0, 1, -1};

    private int date = 0;

    public int solution(int[][][] map, int n, int m, int h) {
        if (isAllTomatoRiped(map, n, m, h)) {
            return 0;
        }
        boolean[][][] visited = new boolean[n][m][h];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (map[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        queue.offer(new Node(i, j, k));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            for (int s = 0; s < size; s ++) {
                Node currentNode = queue.poll();
                for (int i = 0; i < 6; i ++) {
                    Node nextNode = new Node(currentNode.i + MOVE_I[i], currentNode.j + MOVE_J[i], currentNode.k + MOVE_K[i]);
                    if (nextNode.i < 0 || nextNode.j < 0 || nextNode.k < 0 || nextNode.i >= n || nextNode.j >= m || nextNode.k >= h ) {
                        continue;
                    }
                    if (visited[nextNode.i][nextNode.j][nextNode.k]) {
                        continue;
                    }
                    if (map[nextNode.i][nextNode.j][nextNode.k] != 0) {
                        continue;
                    }
                    map[nextNode.i][nextNode.j][nextNode.k] = 1;
                    visited[nextNode.i][nextNode.j][nextNode.k] = true;
                    queue.offer(nextNode);
                    flag = true;
                }
            }
            if (flag) {
                date++;
            }
            //System.out.println("date : " + date);
            //printMap(map, n, m, h);
        }
        if (isAllTomatoRiped(map, n, m, h)) {
            return date;
        }
        return -1;
    }

    private void printMap(int[][][] map, int n, int m, int h) {
        for (int k = 0; k < h; k ++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(map[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private boolean isAllTomatoRiped(int[][][] map, int n, int m, int h) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (map[i][j][k] == 0) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return !flag;
    }
}
