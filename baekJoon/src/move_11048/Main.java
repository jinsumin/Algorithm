package move_11048;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by REMI on 2020-03-05.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 1; j <= m; j ++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
//        bufferedWriter.write(String.valueOf(solution.solution(map, n, m)));
//        bufferedWriter.flush();
        System.out.println(solution.solution(map, n, m));
    }
}
/*

class Solution {
    private static final int[] MOVE_R = {1, 0, 1};
    private static final int[] MOVE_C = {0, 1, 1};

    private List<Integer> list = new LinkedList<>();

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] map, int n, int m) {
        Node startNode = new Node(1, 1);
        Node endNode = new Node(n, m);
        int sumOfCandy = map[startNode.r][startNode.c];
        dfs(map, startNode, endNode, sumOfCandy);
        return maxOfSum();
    }

    private void dfs(int[][] map, Node currentNode, Node endNode, int sumOfCandy) {
        if(currentNode.r == endNode.r && currentNode.c == endNode.c) {
            list.add(sumOfCandy);
            return;
        }
        for(int i = 0; i < 3; i ++) {
            Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
            if(nextNode.r > endNode.r || nextNode.c > endNode.c) {
                continue;
            }
            int currentCandy = map[nextNode.r][nextNode.c];
            dfs(map, nextNode, endNode, sumOfCandy + currentCandy);
        }
    }

    public int maxOfSum() {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i ++) {
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
*/

class Solution {
    public int solution(int[][] map, int n, int m) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                map[i][j] += Math.max(Math.max(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
            }
        }
        return map[n][m];
    }
}
