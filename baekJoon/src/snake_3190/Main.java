package snake_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-04-11.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int sizeOfBoard = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfApple = Integer.parseInt(stringTokenizer.nextToken());
        Node[] apples = new Node[numberOfApple];
        for (int i = 0; i < numberOfApple; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            apples[i] = new Node(r - 1, c - 1);
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfDirectionTransformation = Integer.parseInt(stringTokenizer.nextToken());
        Direction[] directions = new Direction[numberOfDirectionTransformation];
        for (int i = 0; i < numberOfDirectionTransformation; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int time = Integer.parseInt(stringTokenizer.nextToken());
            char direction = stringTokenizer.nextToken().charAt(0);
            directions[i] = new Direction(time, direction);
        }
        Dummy dummy = new Dummy();
        System.out.println(dummy.dummy(sizeOfBoard, apples, directions));
    }
}

class Node {
    int r, c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Direction {
    int time;
    char direction;

    public Direction(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }
}

class Dummy {
    private static final int SNAKE = 1;
    private static final int APPLE = 2;
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    private int[][] map;
    private LinkedList<Node> snake = new LinkedList<>();
    private int g_time = 0;
    private char currentDirection = 'E';

    public int dummy(int sizeOfBoard, Node[] apples, Direction[] directions) {
        map = new int[sizeOfBoard][sizeOfBoard];
        putAppleToMap(apples);
        Node startNode = new Node(0, 0);
        snake.offerFirst(startNode);
        map[snake.get(0).r][snake.get(0).c] = SNAKE;
        int index = 0;
        while (true) {
            g_time++;
            Node nextNode;
            if (currentDirection == 'E') {
                nextNode = new Node(snake.getFirst().r + MOVE_R[1], snake.getFirst().c + MOVE_C[1]);
            } else if (currentDirection == 'W') {
                nextNode = new Node(snake.getFirst().r + MOVE_R[3], snake.getFirst().c + MOVE_C[3]);
            } else if (currentDirection == 'S') {
                nextNode = new Node(snake.getFirst().r + MOVE_R[0], snake.getFirst().c + MOVE_C[0]);
            } else {
                nextNode = new Node(snake.getFirst().r + MOVE_R[2], snake.getFirst().c + MOVE_C[2]);
            }
            if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= sizeOfBoard || nextNode.c >= sizeOfBoard) {
                return g_time;
            }
            if (map[nextNode.r][nextNode.c] == SNAKE) {
                return g_time;
            }
            if (map[nextNode.r][nextNode.c] != APPLE) {
                Node tailNode = snake.pollLast();
                map[tailNode.r][tailNode.c] = 0;
            }
            map[nextNode.r][nextNode.c] = SNAKE;
            snake.offerFirst(nextNode);
            Direction temp = directions[index];
            if (g_time == temp.time) {
                if (temp.direction == 'L') {
                    if (currentDirection == 'E') {
                        currentDirection = 'N';
                    } else if (currentDirection == 'W') {
                        currentDirection = 'S';
                    } else if (currentDirection == 'S') {
                        currentDirection = 'E';
                    } else {
                        currentDirection = 'W';
                    }
                } else {
                    if (currentDirection == 'E') {
                        currentDirection = 'S';
                    } else if (currentDirection == 'W') {
                        currentDirection = 'N';
                    } else if (currentDirection == 'S') {
                        currentDirection = 'W';
                    } else {
                        currentDirection = 'E';
                    }
                }
                if (index != directions.length - 1) {
                    index++;
                }
            }
        }
    }

    private void putAppleToMap(Node[] apples) {
        for (int i = 0; i < apples.length; i++) {
            map[apples[i].r][apples[i].c] = APPLE;
        }
    }

    private void printMap(int size) {
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
