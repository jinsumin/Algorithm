package making_bridge_2_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-06-26.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private static final int OCEAN = 0;
    private static final int LAND = 1;
    private static final int LINKED_LAND = 10;
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int numberOfLand = 0;
    private static int totalLengthOfBridge = 0;

    public int solution(int[][] map) {
        findLand(map);
        //makeBridge(map);
        if (isAllLandLinked(map)) {
            return totalLengthOfBridge;
        }
        return -1;
    }

    private void findLand(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i ++) {
            for (int j = 0; j < map[0].length; j ++) {
                if (visited[i][j]) {
                    continue;
                }
                if (map[i][j] != 0) {
                    numberOfLand++;
                    //numberingLand(map, visited, numberOfLand);
                }
            }
        }
    }

    /*private void makeBridge(int[][] map) {
        boolean[] visitedLand = new boolean[numberOfLand];
        PriorityQueue<Land> priorityQueue = new PriorityQueue<>(new Comparator<Land>() {
            @Override
            public int compare(Land o1, Land o2) {
                return o1.lengthOfBridge > o2.lengthOfBridge ? 1 : -1;
            }
        });
        Deque<Integer> deque = new ArrayDeque<>();

    }*/

    private boolean isAllLandLinked(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!(map[i][j] == 0 || map[i][j] == LINKED_LAND)) {
                    return false;
                }
            }
        }
        return true;
    }
}
