package escape_3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = scanner.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        Escape escape = new Escape();
        escape.play(map);
    }
}

class Escape {
    private static final int[] MOVE_R = {0, 1, 0, -1};
    private static final int[] MOVE_C = {1, 0, -1, 0};

    private boolean[][] visitedHog;
    private boolean[][] visitedWaterPool;
    private Queue<Node> waterPoolQueue;
    private int time;

    public void play(char[][] map) {
        visitedHog = new boolean[map.length][map[0].length];
        visitedWaterPool = new boolean[map.length][map[0].length];
        waterPoolQueue = new LinkedList<>();
        time = 0;
        findWaterPool(map, waterPoolQueue);
        Node startNode = findHog(map);
        Node endNode = findCave(map);
        bfs(map, startNode, endNode);
    }

    private void bfs(char[][] map, Node startNode, Node endNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);

        while(!queue.isEmpty()) {
            int waterSize = waterPoolQueue.size();
            while (waterSize != 0) {
                Node waterPoolNode = waterPoolQueue.poll();
                for (int i = 0; i < 4; i++) {
                    assert waterPoolNode != null;
                    Node nextWaterPoolNode = new Node(waterPoolNode.r + MOVE_R[i], waterPoolNode.c + MOVE_C[i]);
                    if (nextWaterPoolNode.r < 0 || nextWaterPoolNode.c < 0 || nextWaterPoolNode.r > map.length - 1 || nextWaterPoolNode.c > map[0].length - 1) {
                        continue;
                    }
                    if (map[nextWaterPoolNode.r][nextWaterPoolNode.c] != '.') {
                        continue;
                    }
                    if (visitedWaterPool[nextWaterPoolNode.r][nextWaterPoolNode.c]) {
                        continue;
                    }
                    visitedWaterPool[nextWaterPoolNode.r][nextWaterPoolNode.c] = true;
                    map[nextWaterPoolNode.r][nextWaterPoolNode.c] = '*';
                    waterPoolQueue.offer(nextWaterPoolNode);
                }
                waterSize--;
            }

            int hogSize = queue.size();
            while (hogSize != 0) {
                Node hogNode = queue.poll();
                assert hogNode != null;
                if (hogNode.r == endNode.r && hogNode.c == endNode.c) {
                    System.out.println(time);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    Node nextHogNode = new Node(hogNode.r + MOVE_R[i], hogNode.c + MOVE_C[i]);
                    if (nextHogNode.r < 0 || nextHogNode.c < 0 || nextHogNode.r > map.length - 1 || nextHogNode.c > map[0].length - 1) {
                        continue;
                    }
                    if (map[nextHogNode.r][nextHogNode.c] == '*' || map[nextHogNode.r][nextHogNode.c] == 'X') {
                        continue;
                    }
                    if (visitedHog[nextHogNode.r][nextHogNode.c]) {
                        continue;
                    }
                    visitedHog[nextHogNode.r][nextHogNode.c] = true;
                    queue.offer(nextHogNode);
                }
                hogSize--;
            }
            time++;
        }
        System.out.println("KAKTUS");
    }

    private Node findCave(char[][] map) {
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[0].length; j ++) {
                if(map[i][j] == 'D') {
                    return new Node(i, j);
                }
            }
        }
        return null;
    }

    private Node findHog(char[][] map) {
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[0].length; j ++) {
                if(map[i][j] == 'S') {
                    map[i][j] = '.';
                    return new Node(i, j);
                }
            }
        }
        return null;
    }

    private void findWaterPool(char[][] map, Queue<Node> waterPoolQueue) {
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[0].length; j ++) {
                if(map[i][j] == '*') {
                    waterPoolQueue.offer(new Node(i, j));
                }
            }
        }
    }

    private class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

