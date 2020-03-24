package cheese_2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

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
    private static final int CHEESE = 1;
    private static final int INNER_AIR = 2;
    private static final int AIR = 0;
    private static final int OUTER_AIR = 3;
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    private Queue<Node> queue = new LinkedList<>();
    private Queue<Node> internalSpaceQueue = new LinkedList<>();
    private boolean[][] visited;
    private boolean flag;
    private int time = 0;

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] map) {
        while (!isCheeseEmpty(map)) {
            init(map);
            visited = new boolean[map.length][map[0].length];
//            for (int i = 0; i < map.length; i++) {
//                for (int j = 0; j < map[0].length; j++) {
//                    if (!visited[i][j]) {
//                        flag = true;
//                        findInternalSpace(map, new Node(i, j));
//                        if (flag) {
//                            while (!internalSpaceQueue.isEmpty()) {
//                                Node innerSpaceNode = internalSpaceQueue.poll();
//                                map[innerSpaceNode.r][innerSpaceNode.c] = INNER_AIR;
//                            }
//                        }
//                    }
//                }
//            }
            findOuterAir(map, new Node(0, 0));
            findExposedCheese(map);
            deleteCheese(map);
            time++;
            for (int[] ints : map) {
                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return time;
    }

    private void findOuterAir(int[][] map, Node node) {
        Queue<Node> outerAirQueue = new LinkedList<>();
        outerAirQueue.offer(node);
        visited[node.r][node.c] = true;
        while(!outerAirQueue.isEmpty()) {
            Node currentNode = outerAirQueue.poll();
            visited[currentNode.r][currentNode.c] = true;
            map[currentNode.r][currentNode.c] = OUTER_AIR;
            for(int i = 0; i < 4; i ++) {
                Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
                if(nextNode.r < 0 || nextNode.c < 0 || nextNode.r > map.length - 1 || nextNode.c > map[0].length - 1) {
                    continue;
                }
                if(visited[nextNode.r][nextNode.c]) {
                    continue;
                }
                if(map[nextNode.r][nextNode.c] != AIR) {
                    continue;
                }
                outerAirQueue.offer(nextNode);
            }
        }
    }

    private void deleteCheese(int[][] map) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            map[node.r][node.c] = 0;
        }
    }

    private boolean isCheeseEmpty(int[][] map) {
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (ints[j] == CHEESE) {
                    return false;
                }
            }
        }
        return true;
    }

    private void init(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == OUTER_AIR) {
                    map[i][j] = AIR;
                }
            }
        }
    }

    private void findExposedCheese(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == CHEESE) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextR = i + MOVE_R[k];
                        int nextC = j + MOVE_C[k];
                        if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) {
                            continue;
                        }
                        if (map[nextR][nextC] == OUTER_AIR) {
                            count++;
                        }
                    }
                    if (count >= 2) {
                        queue.offer(new Node(i, j));
                    }
                }
            }
        }
    }

    private void findInternalSpace(int[][] map, Node currentNode) {
        if (map[currentNode.r][currentNode.c] == AIR) {
            // 외부 공기
            if (currentNode.r == 0 || currentNode.c == 0 || currentNode.r == map.length - 1 || currentNode.c == map[0].length - 1) {
                internalSpaceQueue.clear();
                flag = false;
                return;
            }
            visited[currentNode.r][currentNode.c] = true;
            internalSpaceQueue.offer(currentNode);
            for (int k = 0; k < 4; k++) {
                int nextR = currentNode.r + MOVE_R[k];
                int nextC = currentNode.c + MOVE_C[k];
                Node nextNode = new Node(nextR, nextC);
                if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) {
                    continue;
                }
                if (map[nextNode.r][nextNode.c] != AIR) {
                    continue;
                }
                if (visited[nextNode.r][nextNode.c]) {
                    continue;
                }
                findInternalSpace(map, nextNode);
            }
        }
    }
}
