package delivery_1175;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-10.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i < map.length; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, n, m));
    }
}

class Solution {
    private static final int[] MOVE_R = {0, 1, 0, -1};  // 1, 2, 3, 4
    private static final int[] MOVE_C = {1, 0, -1, 0};

    private static class Node {
        int r, c;
        int direction;

        public Node(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }

    public int solution(char[][] map, int n, int m) {
        Node startNode = findStartNode(map, n, m);
        boolean[][][] visited = new boolean[n][m][3];
        return bfs(map, visited, n, m, startNode, 0);
    }

    private int bfs(char[][] map, boolean[][][] visited, int n, int m, Node startNode, int destCount) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);
        int time = 0;
        boolean[][] check = new boolean[n][m];

        while (!queue.isEmpty()) {
            if (destCount == 2) {
                // 목적지에 모두 도달한 경우
                return time;
            }
            Node currentNode = queue.poll();
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i], i + 1);
                if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= n || nextNode.c >= m) {
                    // 인덱스 초과하는 경우
                    continue;
                }
                if (visited[nextNode.r][nextNode.c][destCount]) {
                    continue;
                }
                if (currentNode.direction == nextNode.direction) {
                    // 같은 방향으로 2번 이동하는 경우
                    continue;
                }
                if (map[nextNode.r][nextNode.c] == '#') {
                    // 갈 수 없는 노드인 경우
                    continue;
                }
                if (map[nextNode.r][nextNode.c] == 'C') {
                    // 목적지에 한번 도달한 경우
                    visited[nextNode.r][nextNode.c][destCount] = true;
                    if(!check[nextNode.r][nextNode.c]) {
                        check[nextNode.r][nextNode.c] = true;
                        destCount++;    // 카운트 --
                    }
                    queue.offer(nextNode);
                    //System.out.println(nextNode.r + ", " + nextNode.c);
                    flag = true;
                }
                if (map[nextNode.r][nextNode.c] == '.') {
                    // 지날수 있는 경로인 경우
                    visited[nextNode.r][nextNode.c][destCount] = true;
                    queue.offer(nextNode);
                    //System.out.println(nextNode.r + ", " + nextNode.c);
                    flag = true;
                }
            }
            if (flag) {
                time++;
            }
        }
        return -1;
    }

    private Node findStartNode(char[][] map, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    return new Node(i, j, 0);
                }
            }
        }
        return null;
    }
}
