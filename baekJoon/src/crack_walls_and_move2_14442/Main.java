package crack_walls_and_move2_14442;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-13.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] map = new int[n][m];
        String[] str = new String[n];
        for(int i = 0; i < n; i ++) {
            str[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = str[i].charAt(j);
            }
        }
        Solution solution = new Solution();
        solution.solution(map, n - 1, m - 1, k);
    }
}

class Solution {
    private static final int[] DIRECTION_I = {0, 1, 0, -1};
    private static final int[] DIRECTION_J = {1, 0, -1, 0};
    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private static int[][] visited = new int[1000][1000];

    public class Node {
        int r, c;
        int crackChance;
        int distance;

        public Node(int r, int c, int crackChance, int distance) {
            this.r = r;
            this.c = c;
            this.crackChance = crackChance;
            this.distance = distance;
        }
    }

    public void solution(int[][] map, int n, int m, int k) {
        Node startNode = new Node(0, 0, k, 0);
        bfs(map, n, m, startNode);
    }

    private void bfs(int[][] map, int n, int m, Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited[node.r][node.c] = 1;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.r == n && temp.c == m) {
                System.out.println(temp.distance);
                return;
            }

            for (int i = 0; i < 4; i++) {
                Node nextTemp = new Node(temp.r + DIRECTION_I[i], temp.c + DIRECTION_J[i], temp.crackChance, temp.distance);
                if (nextTemp.r >= 0 && nextTemp.r <= n && nextTemp.c >= 0 && nextTemp.c <= m) {
                    if (visited[nextTemp.r][nextTemp.c] == 0) {
                        if (map[nextTemp.r][nextTemp.c] == EMPTY) {
                            nextTemp.distance++;
                            visited[nextTemp.r][nextTemp.c] = 1;
                            queue.offer(nextTemp);
                        } else if (map[nextTemp.r][nextTemp.c] == WALL && nextTemp.crackChance > 0) {
                            nextTemp.distance++;
                            nextTemp.crackChance--;
                            visited[nextTemp.r][nextTemp.c] = 1;
                            queue.offer(nextTemp);
                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
}
