package cheese_2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[row][col];
        for (int r = 0; r < row; r ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int c = 0; c < col; c ++) {
                map[r][c] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] map) {
        int time = 0;
        while (!isCheeseEmpty(map)) {
            boolean[][] visited = new boolean[map.length][map[0].length];
            spread(map, visited, new Node(0, 0));
            meltCheese(map, 3);
            time ++;
        }
        return time;
    }

    private boolean isCheeseEmpty(int[][] map) {
        boolean flag = true;
        for (int[] ints : map) {
            for (int c = 0; c < map[0].length; c++) {
                if (ints[c] != 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private void spread(int[][] map, boolean[][] visited, Node node) {
        for (int i = 0; i < 4; i ++) {
            Node nextNode = new Node(node.r + MOVE_R[i], node.c + MOVE_C[i]);
            if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map[0].length) {
                continue;
            }
            if (visited[nextNode.r][nextNode.c]) {
                continue;
            }
            if (map[nextNode.r][nextNode.c] != 0) {
                continue;
            }
            for (int j = 0; j < 4; j ++) {
                Node checkCheeseNode = new Node(nextNode.r + MOVE_R[j], nextNode.c + MOVE_C[j]);
                if (checkCheeseNode.r < 0 || checkCheeseNode.c < 0 || checkCheeseNode.r >= map.length || checkCheeseNode.c >= map[0].length) {
                        continue;
                }
                if (map[checkCheeseNode.r][checkCheeseNode.c] != 0) {
                    map[checkCheeseNode.r][checkCheeseNode.c] ++;
                }
            }
            visited[nextNode.r][nextNode.c] = true;
            spread(map, visited, nextNode);
        }
    }

    private void meltCheese(int[][] map, int count) {
        for (int r = 0; r < map.length; r ++) {
            for (int c = 0; c < map[0].length; c ++) {
                if (map[r][c] >= count) {
                    map[r][c] = 0;
                }
                if (map[r][c] != 0) {
                    map[r][c] = 1;
                }
            }
        }
    }
}
