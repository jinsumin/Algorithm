package numerical_plate_jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int[][] map = new int[5][5];
        for (int i = 0; i < 5; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 5; j ++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    public int solution(int[][] map) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < 5; i ++) {
            for (int j = 0; j < 5; j ++) {
                Node startNode = new Node(i, j);
                String number = String.valueOf(map[startNode.getR()][startNode.getC()]);
                makeNumber(hashSet, map, startNode, number, 5);
            }
        }
        //System.out.println(hashSet);
        return hashSet.size();
    }

    private void makeNumber(HashSet<String> hashSet, int[][] map, Node currentNode, String number, int moveCount) {
        if (moveCount == 0) {
            hashSet.add(number);
            return;
        }
        for (int i = 0; i < 4; i ++) {
            Node nextNode = new Node(currentNode.getR() + MOVE_R[i], currentNode.getC() + MOVE_C[i]);
            if (nextNode.getR() < 0 || nextNode.getC() < 0 || nextNode.getR() > 4 || nextNode.getC() > 4) {
                continue;
            }
            makeNumber(hashSet, map, nextNode, number + map[nextNode.getR()][nextNode.getC()], moveCount - 1);
        }
    }

    private static class Node {
        private final int r, c;

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
