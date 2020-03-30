package organic_cabbage_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-30.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int testCase = Integer.parseInt(stringTokenizer.nextToken());
        for (int t = 1; t <= testCase; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int[][] cabbages = new int[m][n];
            for (int i = 0; i < k; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                cabbages[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())] = 1;
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(cabbages));
        }
    }
}

class Solution {
    private static final int[] MOVE_M = {1, 0, -1, 0};
    private static final int[] MOVE_N = {0, 1, 0, -1};

    private int count = 0;

    public int solution(int[][] cabbages) {
        boolean[][] visited = new boolean[cabbages.length][cabbages[0].length];
        for (int i = 0; i < cabbages.length; i ++) {
            for (int j = 0; j < cabbages[0].length; j ++) {
                if (!visited[i][j] && cabbages[i][j] == 1) {
                    bfs(cabbages, visited, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void bfs(int[][] cabbages, boolean[][] visited, int m, int n) {
        for (int i = 0; i < 4; i ++) {
            int nextM = m + MOVE_M[i];
            int nextN = n + MOVE_N[i];
            if (nextM < 0 || nextN < 0 || nextM >= cabbages.length || nextN >= cabbages[0].length) {
                continue;
            }
            if (visited[nextM][nextN]) {
                continue;
            }
            if (cabbages[nextM][nextN] != 1) {
                continue;
            }
            visited[nextM][nextN] = true;
            bfs(cabbages, visited, nextM, nextN);
        }
    }
}
