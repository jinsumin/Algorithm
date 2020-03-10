package descending_path_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-08.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
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

    public int solution(int[][] map) {
        int[][] memo = new int[map.length][map[0].length];
        Node startNode = new Node(0, 0);
        Node endNode = new Node(map.length - 1, map[0].length - 1);
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(map, memo, startNode, endNode);
    }

    private int dfs(int[][] map, int[][] memo, Node currentNode, Node endNode) {
        if (currentNode.r == endNode.r && currentNode.c == endNode.c) {
            return 1;
        }

        if (memo[currentNode.r][currentNode.c] == -1) {
            memo[currentNode.r][currentNode.c] = 0;
            for(int i = 0; i < 4; i ++) {
                Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
                if(nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map[0].length) {
                    continue;
                }
                if(map[nextNode.r][nextNode.c] < map[currentNode.r][currentNode.c]) {
                    memo[currentNode.r][currentNode.c] += dfs(map, memo, nextNode, endNode);
                }
            }
        }
        return memo[currentNode.r][currentNode.c];
    }
}
