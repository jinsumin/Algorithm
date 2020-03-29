package ladder_manipulation_15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-24.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int h = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[h + 1][n + 1];
        for(int i = 1; i <= m; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            map[a][b] = 1;      // right side bridge
            map[a][b + 1] = 2;  // left side bridge
        }
        Solution solution = new Solution();
        solution.solution(map, n, m, h);
    }
}

class Solution {
    public int solution(int[][] map, int n, int m, int h) {

        return 0;
    }
}
