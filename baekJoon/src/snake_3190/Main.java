package snake_3190;

import java.util.*;

/**
 * Created by REMI on 2020-01-20.
 */
public class Main {
    public static void main(String[] args) {
        Dummy dummy = new Dummy();
        dummy.play();
        System.out.println(dummy.countOfPlayedTime());
    }
}

class Dummy {
    private static class Route{
        private int time;
        private char direction;
        public Route(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] map;
    private static int sizeOfBoard;
    private static int numberOfApple;
    private static Queue<Route> routeOfSnake = new LinkedList<Route>();
    private static int gameTime = 0;
    private static int headDirection;
    private static int headPosOfX = 1;
    private static int headPosOfY = 1;
    private static int tailPosOfX = 1;
    private static int tailPosOfY = 1;
    private static final int[] dx = {0, 1, 0, -1};    // E, S, W, N
    private static final int[] dy = {1, 0, -1, 0};
    private static final int DIRECTION_TO_EAST = 0;
    private static final int DIRECTION_TO_SOUTH = 1;
    private static final int DIRECTION_TO_WEST = 2;
    private static final int DIRECTION_TO_NORTH = 3;
    private static final int APPLE = 100;
    private static final int WALL = -1;

    public void play() {
        initGame();
        settingApples();
        settingRoutes();
        while(!routeOfSnake.isEmpty()) {
            if(routeOfSnake.peek().time == gameTime) {
                if(routeOfSnake.peek().direction == 'L') {
                    headDirection = (headDirection + 3) % 3;
                    routeOfSnake.poll();
                }else if(routeOfSnake.peek().direction == 'D') {
                    headDirection = (headDirection + 1) % 3;
                    routeOfSnake.poll();
                }
            }
            if(map[headPosOfX + dx[headDirection]][headPosOfY + dy[headDirection]] == APPLE) {
                map[tailPosOfX][tailPosOfY] = 1;
            }else {
                map[tailPosOfX][tailPosOfY] = 0;
                //tailPosOfX +=
            }

            gameTime ++;
        }
    }

    private void initGame() {
        sizeOfBoard = scanner.nextInt();
        numberOfApple = scanner.nextInt();
        map = new int[sizeOfBoard + 2][sizeOfBoard + 2];
        Arrays.fill(map, 0);
        for(int i = 0; i < sizeOfBoard + 2; i ++) {
            map[i][0] = WALL;
            map[0][i] = WALL;
            map[i][sizeOfBoard + 2] = WALL;
            map[sizeOfBoard + 2][i] = WALL;
        }
        headDirection = DIRECTION_TO_EAST;
        map[headPosOfX][headPosOfY] = 1;
    }

    private void settingApples() {
        for(int i = 0; i < numberOfApple; i ++) {
            map[scanner.nextInt()][scanner.nextInt()] = APPLE;
        }
    }

    private void settingRoutes() {
        int numberOfTurnover = scanner.nextInt();
        for(int i = 0; i < numberOfTurnover; i ++) {
            Route route = new Route(scanner.nextInt(), scanner.next().charAt(0));
            routeOfSnake.offer(route);
        }
    }

    public int countOfPlayedTime() {
        return gameTime;
    }
}
