package safe_area_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private static final int[] MOVE_R = {0, 1, 0, -1};
    private static final int[] MOVE_C = {1, 0, -1, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int[] countSafetyArea = new int[101];
    private boolean[][] visited;

    public int solution(int[][] map) {
        for (int height = 1; height <= 100; height++) {
            visited = new boolean[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    Node currentNode = new Node(i, j);
                    if(!visited[currentNode.r][currentNode.c] && map[currentNode.r][currentNode.c] > height) {
                        getSafetyArea(map, currentNode, height);
                        countSafetyArea[height]++;
                    }
                }
            }
        }
        return getMaxCountSafetyArea();
    }

    private void getSafetyArea(int[][] map, Node currentNode, int height) {
        for(int i = 0; i < 4; i ++) {
            Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
            if(nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map[0].length) {
                continue;
            }
            if(visited[nextNode.r][nextNode.c]) {
                continue;
            }
            if(map[nextNode.r][nextNode.c] <= height) {
                continue;
            }
            visited[nextNode.r][nextNode.c] = true;
            getSafetyArea(map, nextNode, height);
        }
    }

    private int getMaxCountSafetyArea() {
        int max = 1;
        for (int value : countSafetyArea) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
