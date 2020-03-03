package find_dust_17144;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-23.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int t = scanner.nextInt();
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, t));
    }
}

class Solution {
    private static final int[] MOVE_R = {0, 1, 0, -1};
    private static final int[] MOVE_C = {1, 0, -1, 0};
    private static final int AIR_PURIFIER = -1;

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private Queue<Node> queue;

    public int solution(int[][] map, int t) {
        Node airPurifierUpper = findAirPurifier(map);
        Node airPurifierLower = new Node(airPurifierUpper.r + 1, airPurifierUpper.c);
        while (t > 0) {
            play(map, airPurifierUpper, airPurifierLower);
            t--;
        }
        return countTotalDust(map);
    }

    private Node findAirPurifier(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == AIR_PURIFIER) {
                    return new Node(i, j);
                }
            }
        }
        return null;
    }

    private void play(int[][] map, Node airPurifierUpper, Node airPurifierLower) {
        queue = new LinkedList<>();
        findDust(map);
        spreadDust(map);
        airCirculate(map, false, airPurifierUpper);
        airCirculate(map, true, airPurifierLower);
    }

    private void findDust(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    queue.offer(new Node(i, j));
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

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nextR = currentNode.r + MOVE_R[i];
                int nextC = currentNode.c + MOVE_C[i];
                if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length || map[nextR][nextC] == AIR_PURIFIER) {
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

    private void airCirculate(int[][] map, boolean clockWise, Node airPurifierUpper) {
        if (!clockWise) {
            downSide(map, airPurifierUpper, new Node(0, 0));
            leftSide(map, new Node(0, 0), new Node(0, map[0].length - 1));
            upSide(map, new Node(0, map[0].length - 1), new Node(airPurifierUpper.r, map[0].length - 1));
            rightSide(map, new Node(airPurifierUpper.r, map[0].length - 1), airPurifierUpper);
        } else {
            upSide(map, airPurifierUpper, new Node(map.length - 1, 0));
            leftSide(map, new Node(map.length - 1, 0), new Node(map.length - 1, map[0].length - 1));
            downSide(map, new Node(map.length - 1, map[0].length - 1), new Node(airPurifierUpper.r, map[0].length - 1));
            rightSide(map, new Node(airPurifierUpper.r, map[0].length - 1), airPurifierUpper);
        }
    }

    private void downSide(int[][] map, Node startNode, Node endNode) {
        for (int i = startNode.r - 1; i >= endNode.r; i--) {
            if (map[i + 1][startNode.c] == AIR_PURIFIER) {
                continue;
            }
            map[i + 1][startNode.c] = map[i][startNode.c];
        }
    }

    private void leftSide(int[][] map, Node startNode, Node endNode) {
        for (int j = startNode.c + 1; j <= endNode.c; j++) {
            map[startNode.r][j - 1] = map[startNode.r][j];
        }
    }

    private void upSide(int[][] map, Node startNode, Node endNode) {
        for (int i = startNode.r + 1; i <= endNode.r; i++) {
            if (map[i - 1][startNode.c] == AIR_PURIFIER) {
                continue;
            }
            map[i - 1][startNode.c] = map[i][startNode.c];
        }
    }

    private void rightSide(int[][] map, Node startNode, Node endNode) {
        for (int j = startNode.c - 1; j >= endNode.c; j--) {
            if (map[startNode.r][j] == AIR_PURIFIER) {
                map[startNode.r][j + 1] = 0;
                return;
            }
            map[startNode.r][j + 1] = map[startNode.r][j];
        }
    }

    private int countTotalDust(int[][] map) {
        int result = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                //System.out.print(" " + map[i][j]);
                if (map[i][j] == AIR_PURIFIER) {
                    continue;
                }
                result += map[i][j];
            }
            //System.out.println();
        }
        return result;
    }
}
