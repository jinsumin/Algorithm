package voyager_1_3987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i ++) {
            String temp = bufferedReader.readLine();
            for (int j = 0; j < m; j ++) {
                map[i][j] = temp.charAt(j);
            }
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        solution.solution(map, r, c);
    }
}

class Solution {
    private static final int[] MOVE_R = {-1, 0, 1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};
    private static final int U = 0;
    private static final int R = 1;
    private static final int D = 2;
    private static final int L = 3;

    private static int max = Integer.MIN_VALUE;

    public void solution(char[][] map, int r, int c) {
        Node roverPosition = new Node(r - 1, c - 1);
        int[] distances = new int[4];
        for (int direction = 0; direction < 4; direction++) {
            boolean[][][] visited = new boolean[map.length][map[0].length][4];
            distances[direction] = sendSignal(map, visited, roverPosition, direction);
            if (distances[direction] > max) {
                max = distances[direction];
            }
        }
        for (int direction = 0; direction < 4; direction++) {
            if (max == distances[direction]) {
                switch (direction) {
                    case U:
                        System.out.println('U');
                        break;
                    case R:
                        System.out.println('R');
                        break;
                    case D:
                        System.out.println('D');
                        break;
                    case L:
                        System.out.println('L');
                        break;
                }
                System.out.println(distances[direction]);
                return;
            }
        }
    }

    private int sendSignal(char[][] map, boolean[][][] visited, Node roverPosition, int direction) {
        int distance = 0;
        int nextDirection = direction;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(roverPosition);
        while (!queue.isEmpty()) {
            distance++;
            Node currentNode = queue.poll();
            Node nextNode = new Node(currentNode.r + MOVE_R[nextDirection], currentNode.c + MOVE_C[nextDirection]);
            if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map[0].length) {
                return distance;
            }
            if (map[nextNode.getR()][nextNode.getC()] == '\\') {
                if (nextDirection == U) {
                    nextDirection = L;
                } else if (nextDirection == L) {
                    nextDirection = U;
                } else if (nextDirection == R) {
                    nextDirection = D;
                } else {
                    nextDirection = R;
                }
            } else if (map[nextNode.getR()][nextNode.getC()] == '/') {
                if (nextDirection == U) {
                    nextDirection = R;
                } else if (nextDirection == L) {
                    nextDirection = D;
                } else if (nextDirection == R) {
                    nextDirection = U;
                } else {
                    nextDirection = L;
                }
            } else if (map[nextNode.getR()][nextNode.getC()] == 'C') {
                return distance;
            }
            if (visited[nextNode.getR()][nextNode.getC()][nextDirection]) {
                switch (nextDirection) {
                    case U:
                        System.out.println('U');
                        break;
                    case R:
                        System.out.println('R');
                        break;
                    case D:
                        System.out.println('D');
                        break;
                    case L:
                        System.out.println('L');
                        break;
                }
                System.out.println("Voyager");
                System.exit(0);
            }
            visited[nextNode.getR()][nextNode.getC()][nextDirection] = true;
            queue.offer(nextNode);
        }
        return distance;
    }

    private static class Node {
        private final int r, c;

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
