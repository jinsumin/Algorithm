package connecting_processor_1767;

import java.util.*;

/**
 * Created by REMI on 2020-01-23.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 1; t <= testCase; t ++) {
            Maxinos maxinos = new Maxinos();
            int n = scanner.nextInt();
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            System.out.println("#" + t + " " + maxinos.solution(map));
        }
    }
}

class Maxinos {
    private class Dot {
        int i;
        int j;

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public Dot(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    private static final int CORE = 1;
    private static final int WIRE = 2;
    private static final int CONNECTED = 3;
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int RIGHT = 2;
    private static final int LEFT = 3;

    private static int[] sumOfWire;
    private static int index = 0;

    public int solution(int[][] map) {
        Stack<Dot> stack = new Stack<>();
        boolean[] visited = new boolean[12];
        Arrays.fill(visited, false);
        init(map);
        pushCore(map, stack);
        Dot dot = stack.pop();
        solve(map, stack, dot, visited, UP);
        solve(map, stack, dot, visited, DOWN);
        solve(map, stack, dot, visited, RIGHT);
        solve(map, stack, dot, visited, LEFT);
        return findMinSumOfWire();
    }

    private void init(int[][] map) {
        int count = 0;
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[i].length; j ++) {
                if(map[i][0] == CORE) {
                    map[i][0] = CONNECTED;
                }
                if(map[i][map.length - 1] == CORE) {
                    map[i][map.length - 1] = CONNECTED;
                }
                if(map[0][j] == CORE) {
                    map[0][j] = CONNECTED;
                }
                if(map[map.length - 1][j] == CORE){
                    map[map.length - 1][j] = CONNECTED;
                }
                else if(map[i][j] == CORE) {
                    count ++;
                }
            }
        }
        sumOfWire = new int[(int) Math.pow(4, count)];
    }

    private void pushCore(int[][] map, Stack stack) {
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map.length; j ++) {
                if(map[i][j] == CORE) {
                    stack.push(new Dot(i, j));
                }
            }
        }
    }

    private void solve(int[][] map, Stack<Dot> stack, Dot dot, boolean[] visited, int dir) {
        switch (dir) {
            case UP :
                for(int i = 0; i < dot.getI(); i ++) {
                    if(map[i][dot.getJ()] != 0) {
                        return;
                    }
                }
                for(int i = 0; i < dot.getI(); i ++) {
                    map[i][dot.getJ()] = WIRE;
                }
                break;
            case DOWN :
                for(int i = dot.getI() + 1; i < map.length; i ++) {
                    if(map[i][dot.getJ()] != 0) {
                        return;
                    }
                }
                for(int i = dot.getI() + 1; i < map.length; i ++) {
                    map[i][dot.getJ()] = WIRE;
                }
                break;
            case RIGHT :
                for(int j = dot.getJ() + 1; j < map.length; j ++) {
                    if(map[dot.getI()][j] != 0) {
                        return;
                    }
                }
                for(int j = dot.getJ() + 1; j < map.length; j ++) {
                    map[dot.getI()][j] = WIRE;
                }
                break;
            case LEFT :
                for(int j = 0; j < dot.getJ(); j ++) {
                    if(map[dot.getI()][j] != 0) {
                        return;
                    }
                }
                for(int j = 0; j < dot.getJ(); j ++) {
                    map[dot.getI()][j] = WIRE;
                }
                break;
        }
        sumOfWire(stack, map);

        for(int i = 0; i < stack.size(); i ++){
            if(!visited[i]) {
                Dot nextDot = stack.pop();
                visited[i] = true;
                solve(map, stack, nextDot, visited, UP);
                solve(map, stack, nextDot, visited, DOWN);
                solve(map, stack, nextDot, visited, RIGHT);
                solve(map, stack, nextDot, visited, LEFT);
                visited[i] = false;
                stack.push(nextDot);
            }
        }
    }

    public void sumOfWire(Stack<Dot> stack, int[][] map) {

        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[i].length; j ++) {
                if(map[i][j] == WIRE) {
                    sumOfWire[index] ++;
                }
            }
        }
        index ++;
    }

    private int findMinSumOfWire() {
        int min = 10000000;
        for (int value : sumOfWire) {
            if (value != 0) {
                if (value < min) {
                    min = value;
                }
            } else {
                return min;
            }
        }
        return -1;
    }
}
