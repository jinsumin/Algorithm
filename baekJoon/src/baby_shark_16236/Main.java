/*
package baby_shark_16236;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

*/
/**
 * Created by REMI on 2020-02-10.
 *//*

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution sol = new Solution();
        System.out.println(sol.solution(map));
    }
}

class Solution {
    private static final int[] MOVE_I = {-1, 0, 1, 0};
    private static final int[] MOVE_J = {0, -1, 0, 1};
    private static final int SHARK_POSITION = 9;
    private static final int PASSED = 0;
    private static final int EMPTY = 0;

    private static Queue<Node> queue;
    private static int sharkSize = 2;
    private static int moveTime = 0;
    private static int feedTime = 0;
    private static int countFish = 0;

    HashMap<String, Integer> hashMap = new HashMap();

    private class Node {
        private int positionI;
        private int positionJ;

        public Node(int positionI, int positionJ) {
            this.setPositionI(positionI);
            this.setPositionJ(positionJ);
        }

        public int getPositionI() {
            return positionI;
        }

        public void setPositionI(int positionI) {
            this.positionI = positionI;
        }

        public int getPositionJ() {
            return positionJ;
        }

        public void setPositionJ(int positionJ) {
            this.positionJ = positionJ;
        }
    }

    public int solution(int[][] map) {
        Node shark = findShark(map);
        play(map, shark);
        return moveTime;
    }

    private Node findShark(int[][] map) {
        Node shark = null;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == SHARK_POSITION) {
                    shark = new Node(i, j);
                }
                else if(map[i][j] != SHARK_POSITION && map[i][j] != EMPTY) {
                    countFish ++;
                }
            }
        }
        return shark;
    }

    private void play(int[][] map, Node shark) {
        queue = new LinkedList<>();
        queue.offer(new Node(shark.getPositionI(), shark.getPositionJ()));
        while (!queue.isEmpty()) {
            Node currentSharkPos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextSharkPositionI = currentSharkPos.getPositionI() + MOVE_I[i];
                int nextSharkPositionJ = currentSharkPos.getPositionJ() + MOVE_J[i];
                if (nextSharkPositionI >= 0 && nextSharkPositionJ >= 0 &&
                        nextSharkPositionI < map.length && nextSharkPositionJ < map.length) {
                    if (map[nextSharkPositionI][nextSharkPositionJ] <= sharkSize) {
                        if (map[nextSharkPositionI][nextSharkPositionJ] < sharkSize &&
                                map[nextSharkPositionI][nextSharkPositionJ] != EMPTY) {
                            map[currentSharkPos.getPositionI()][currentSharkPos.getPositionJ()] = PASSED;
                            map[nextSharkPositionI][nextSharkPositionJ] = SHARK_POSITION;
                            int moveTimeI = Math.abs(nextSharkPositionI - currentSharkPos.getPositionI());
                            int moveTimeJ = Math.abs(nextSharkPositionJ - currentSharkPos.getPositionJ());
                            moveTime += (moveTimeI + moveTimeJ);
                            feedTime ++;
                            countFish --;
                            if(feedTime == sharkSize) {
                                sharkSize ++;
                                feedTime = 0;
                            }
                            if(countFish == 0) {
                                break;
                            }
                        }
                        queue.offer(new Node(nextSharkPositionI, nextSharkPositionJ));
                        shark.setPositionI(nextSharkPositionI);
                        shark.setPositionJ(nextSharkPositionJ);
                    }
                }
            }
        }
    }
}
*/
