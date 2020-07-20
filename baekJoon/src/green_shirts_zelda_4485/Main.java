package green_shirts_zelda_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-07-01.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int testCase = Integer.parseInt(bufferedReader.readLine());
        for (int t = 1; t <= testCase; t++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i ++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j ++) {
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            Solution solution = new Solution();
            solution.solution(map);
        }
    }
}

class Solution {
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    public void solution(int[][] map) {
        int[][] rupeeMap = new int[map.length][map[0].length];
        for (int[] ints : rupeeMap) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        Node startNode = new Node(0, 0);
        Node endNode = new Node(map.length - 1, map.length - 1);
        
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
