package bead_escape2_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-01.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[n][m];
        for (int r = 0; r < n; r ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            for (int c = 0; c < m; c ++) {
                map[r][c] = str.charAt(c);
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private static final int[] MOVE_R = {0, 0, -1, 1};
    private static final int[] MOVE_C = {-1, 1, 0, 0};
    private static final int left = 0;
    private static final int right = 1;
    private static final int up = 2;
    private static final int down = 3;

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int g_time = Integer.MAX_VALUE;

    public int solution(int[][] map) {
        Node redBall = extractRedBall(map);
        Node blueBall = extractBlueBall(map);
        dfs(map, redBall, blueBall, left, 1);
        dfs(map, redBall, blueBall, right, 1);
        dfs(map, redBall, blueBall, up, 1);
        dfs(map, redBall, blueBall, down, 1);
        if(g_time > 10) {
            return -1;
        }
        return g_time;
    }

    private Node extractRedBall(int[][] map) {
        for (int r = 0; r < map.length; r ++) {
            for (int c = 0; c < map[0].length; c ++) {
                if (map[r][c] == 'R') {
                    map[r][c] = '.';
                    return new Node(r, c);
                }
            }
        }
        return null;
    }

    private Node extractBlueBall(int[][] map) {
        for (int r = 0; r < map.length; r ++) {
            for (int c = 0; c < map[0].length; c ++) {
                if (map[r][c] == 'B') {
                    map[r][c] = '.';
                    return new Node(r, c);
                }
            }
        }
        return null;
    }

    private void dfs(int[][] map, Node redBall, Node blueBall, int dir, int time) {
        if (time > 10) {
            return;
        }
        Node nextRedBall = new Node(redBall.r, redBall.c);
        Node nextBlueBall = new Node(blueBall.r, blueBall.c);
        int count = 8;
        while (count > 0) {
            if (map[nextBlueBall.r + MOVE_R[dir]][nextBlueBall.c + MOVE_C[dir]] == 'O') {
                return;
            }
            if (map[nextRedBall.r + MOVE_R[dir]][nextRedBall.c + MOVE_C[dir]] == 'O') {
                if (nextBlueBall.r + (MOVE_R[dir] * 2) > 0 && nextBlueBall.r + (MOVE_R[dir] * 2) < map.length - 1) {
                    if (nextBlueBall.c + (MOVE_C[dir] * 2) > 0 && nextBlueBall.c + (MOVE_C[dir] * 2) < map[0].length - 1) {
                        if (map[nextBlueBall.r + (MOVE_R[dir] * 2)][nextBlueBall.c + (MOVE_C[dir] * 2)] == 'O') {
                            return;
                        }
                    }
                }
                if (time < g_time) {
                    g_time = time;
                }
                return;
            }
            if (map[nextRedBall.r + MOVE_R[dir]][nextRedBall.c + MOVE_C[dir]] == '.') {
                nextRedBall.r = nextRedBall.r + MOVE_R[dir];
                nextRedBall.c = nextRedBall.c + MOVE_C[dir];
            }
            if (map[nextBlueBall.r + MOVE_R[dir]][nextBlueBall.c + MOVE_C[dir]] == '.') {
                nextBlueBall.r = nextBlueBall.r + MOVE_R[dir];
                nextBlueBall.c = nextBlueBall.c + MOVE_C[dir];
            }
            count --;
        }
        if (nextRedBall.r == nextBlueBall.r && nextRedBall.c == nextBlueBall.c) {
            switch (dir) {
                case 0:
                    if (redBall.c < blueBall.c) {
                        nextBlueBall.c++;
                    } else {
                        nextRedBall.c++;
                    }
                    break;
                case 1:
                    if (redBall.c > blueBall.c) {
                        nextBlueBall.c--;
                    } else {
                        nextRedBall.c--;
                    }
                    break;
                case 2:
                    if (redBall.r < blueBall.r) {
                        nextBlueBall.r++;
                    } else {
                        nextRedBall.r++;
                    }
                    break;
                case 3:
                    if (redBall.r > blueBall.r) {
                        nextBlueBall.r--;
                    } else {
                        nextRedBall.r--;
                    }
                    break;
            }
        }
        dfs(map, nextRedBall, nextBlueBall, left, time + 1);
        dfs(map, nextRedBall, nextBlueBall, right, time + 1);
        dfs(map, nextRedBall, nextBlueBall, up, time + 1);
        dfs(map, nextRedBall, nextBlueBall, down, time +1);
    }
}
