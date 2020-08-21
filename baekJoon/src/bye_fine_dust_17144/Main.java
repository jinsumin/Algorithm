package bye_fine_dust_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-08-21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(R, C, T, map));
    }
}

class Solution {
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    private static class Node {
        int r, c;

        private Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private Queue<Node> dustQueue = new LinkedList<Node>();
    private Node posOfTopCleaner = null;
    private Node posOfBottomCleaner = null;

    public int solution(int R, int C, int T, int[][] map) {
        int answer;
        findCleaner(R, C, map);
        for (int t = 1; t <= T; t++) {
            findDust(R, C, map);
            spreadDust(map);
            //printMap(R, C, map);
            activeCleaner(R, C, map);
            //printMap(R, C, map);
        }
        answer = totalDust(R, C, map);
        return answer;
    }

    private void printMap(int R, int C, int[][] map) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void findCleaner(int R, int C, int[][] map) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == -1) {
                    posOfTopCleaner = new Node(r, c);
                    posOfBottomCleaner = new Node(r + 1, c);
                    return;
                }
            }
        }
    }

    private void findDust(int R, int C, int[][] map) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0) {
                    dustQueue.offer(new Node(r, c));
                }
            }
        }
    }

    private void spreadDust(int[][] map) {
        int[][] copiedMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }

        while (!dustQueue.isEmpty()) {
            Node currentNode = dustQueue.poll();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nextR = currentNode.r + MOVE_R[i];
                int nextC = currentNode.c + MOVE_C[i];
                if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length || map[nextR][nextC] == -1) {
                    continue;
                }
                copiedMap[nextR][nextC] += (map[currentNode.r][currentNode.c] / 5);
                count++;
            }
            copiedMap[currentNode.r][currentNode.c] -= ((map[currentNode.r][currentNode.c] / 5) * count);
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = copiedMap[i][j];
            }
        }
    }

    private void activeCleaner(int R, int C, int[][] map) {
        // top cleaner case
        for (int r = posOfTopCleaner.r - 1; r > 0; r --) {
            map[r][0] = map[r - 1][0];
        }
        for (int c = 0; c < C - 1; c ++) {
            map[0][c] = map[0][c + 1];
        }
        for (int r = 0; r < posOfTopCleaner.r; r ++) {
            map[r][C - 1] = map[r + 1][C - 1];
        }
        for (int c = C - 1; c >= 1; c --) {
            if (c == 1) {
                map[posOfTopCleaner.r][c] = 0;
                break;
            }
            map[posOfTopCleaner.r][c] = map[posOfTopCleaner.r][c - 1];
        }

        // bottom cleaner case
        for (int r = posOfBottomCleaner.r + 1; r < R - 1; r++) {
            map[r][posOfBottomCleaner.c] = map[r + 1][posOfBottomCleaner.c];
        }
        for (int c = posOfBottomCleaner.c; c < C - 1; c++) {
            map[R - 1][c] = map[R - 1][c + 1];
        }
        for (int r = R - 1; r > posOfBottomCleaner.r; r--) {
            map[r][C - 1] = map[r - 1][C - 1];
        }
        for (int c = C - 1; c > posOfBottomCleaner.c; c--) {
            if (c == posOfBottomCleaner.c + 1) {
                map[posOfBottomCleaner.r][c] = 0;
                break;
            }
            map[posOfBottomCleaner.r][c] = map[posOfBottomCleaner.r][c - 1];
        }
    }

    private int totalDust(int R, int C, int[][] map) {
        int result = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0) {
                    result += map[r][c];
                }
            }
        }
        return result;
    }
}
