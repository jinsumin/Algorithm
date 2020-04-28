package where_is_the_laser_beam_3709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-27.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int testCase = Integer.parseInt(stringTokenizer.nextToken());
        for (int t = 1; t <= testCase; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sizeOfBoard = Integer.parseInt(stringTokenizer.nextToken());
            int numberOfMirror = Integer.parseInt(stringTokenizer.nextToken());
            Node[] mirrors = new Node[numberOfMirror];
            for (int i = 0; i < numberOfMirror; i ++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int r = Integer.parseInt(stringTokenizer.nextToken());
                int c = Integer.parseInt(stringTokenizer.nextToken());
                mirrors[i] = new Node(r, c);
            }
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            Node laserNode = new Node(r, c);
            Solution solution = new Solution();
            solution.solution(sizeOfBoard, mirrors, laserNode);
        }
    }
}

class Node {
    public int r, c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    private static final int MIRROR = 1;
    private static final int LASER = 2;
    private static final int EAST = 0;
    private static final int SOUTH = 1;
    private static final int WEST = 2;
    private static final int NORTH = 3;
    private static final int[] MOVE_R = {0, 1, 0, -1};
    private static final int[] MOVE_C = {1, 0, -1, 0};

    public void solution(int sizeOfBoard, Node[] mirrors, Node laserNode) {
        int[][] map = new int[sizeOfBoard + 2][sizeOfBoard + 2];
        for (Node mirror : mirrors) {
            map[mirror.r][mirror.c] = MIRROR;
        }
        map[laserNode.r][laserNode.c] = LASER;
        int direction = -1;
        int startDirection = -1;
        if (laserNode.r == 0) {
            startDirection = SOUTH;
        } else if (laserNode.r == sizeOfBoard + 1) {
            startDirection = NORTH;
        }
        if (laserNode.c == 0) {
            startDirection = EAST;
        } else if (laserNode.c == sizeOfBoard + 1){
            startDirection = WEST;
        }
        // printMap(map);
        direction = startDirection;
        Node currentNode = new Node(laserNode.r, laserNode.c);
        Node nextNode = new Node(currentNode.r, currentNode.c);
        while (true) {
            nextNode = new Node(nextNode.r + MOVE_R[direction], nextNode.c + MOVE_C[direction]);
            if (nextNode.r <= 0 || nextNode.c <= 0 || nextNode.r >= sizeOfBoard + 1 || nextNode.c >= sizeOfBoard + 1) {
                break;
            }
            if (map[nextNode.r][nextNode.c] == MIRROR) {
                direction += 1;
                direction %= 4;
            }
            if (map[nextNode.r][nextNode.c] == 0) {
                map[nextNode.r][nextNode.c] = 3;
            }
            // printMap(map);
        }
        System.out.println(nextNode.r + " " + nextNode.c);
    }

    private void printMap(int[][] map) {
        for (int i = 0; i < map.length; i ++) {
            for (int j = 0; j < map.length; j ++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
