package maza_escape_14923;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Hx = scanner.nextInt();
        int Hy = scanner.nextInt();
        int Ex = scanner.nextInt();
        int Ey = scanner.nextInt();
        int[][] map = new int[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            map[i][0] = 1;
            map[0][i] = 1;
            map[i][N + 1] = 1;
            map[N + 1][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, Hx, Hy, Ex, Ey));
    }
}

class Solution {
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int[] DIRECTION_I = {0, 1, 0, -1};
    private static final int[] DIRECTION_J = {1, 0, -1, 0};

    public class Node {
        int r, c, distance, magicChance;

        public Node(int r, int c, int distance, int magicChance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.magicChance = magicChance;
        }
    }

    public int solution(int[][] map, int hx, int hy, int ex, int ey) {
        Node startNode = new Node(hx, hy, 0, 0);
        boolean[][][] visited = new boolean[map.length][map[0].length][2];
        return playMaze(map, visited, startNode, ex, ey);
    }

    private int playMaze(int[][] map, boolean[][][] visited, Node startNode, int ex, int ey) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode.r][startNode.c][startNode.magicChance] = true;
        visited[startNode.r][startNode.c][startNode.magicChance] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("node (" + node.r + ", " + node.c + ") distance : " + node.distance);
            if (node.r == ex && node.c == ey) {
                return node.distance;
            }
            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(node.r + DIRECTION_I[i], node.c + DIRECTION_J[i], node.distance + 1, node.magicChance);
                if (nextNode.r < 1 || nextNode.r >= map.length || nextNode.c < 1 || nextNode.c >= map[0].length) {
                    continue;
                }
                if (map[nextNode.r][nextNode.c] == WALL) {
                    if (nextNode.magicChance > 0 && !visited[nextNode.r][nextNode.c][nextNode.magicChance]) {
                        //nextNode.magicChance = nextNode.magicChance - 1;
                        queue.offer(nextNode);
                        visited[nextNode.r][nextNode.c][nextNode.magicChance] = true;
                    }
                } else if (map[nextNode.r][nextNode.c] == EMPTY) {
                    if (!visited[nextNode.r][nextNode.c][nextNode.magicChance]) {
                        queue.offer(nextNode);
                        visited[nextNode.r][nextNode.c][nextNode.magicChance] = true;
                    }
                }
            }
        }
        return -1;
    }
}
