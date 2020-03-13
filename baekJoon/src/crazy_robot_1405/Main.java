package crazy_robot_1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-12.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int action = Integer.parseInt(stringTokenizer.nextToken());
        double[] probabilities = new double[4];
        for(int i = 0; i < 4; i ++) {
            probabilities[i] = Double.parseDouble(stringTokenizer.nextToken()) / 100.0;
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(action, probabilities));
    }
}

class Solution {
    private static final int[] MOVE_R = {0, 0, 1, -1};
    private static final int[] MOVE_C = {1, -1, 0, 0};
    private static final double[] PROBABILITIES = new double[4];

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public double solution(int action, double[] probabilities) {
        double[][] map = new double[action * 2 + 1][action * 2 + 1];
        boolean[][] visited = new boolean[action * 2 + 1][action * 2 + 1];
        System.arraycopy(probabilities, 0, PROBABILITIES, 0, 4);
        Node startNode = new Node(action, action);
        solve(map, visited, startNode, action, 1);
        return sumOfProbabilities(map);
    }

    private void solve(double[][] map, boolean[][] visited, Node currentNode, int action, double probability) {
        if(visited[currentNode.r][currentNode.c]) {
            return;
        }
        if(action <= 0) {
            map[currentNode.r][currentNode.c] += probability;
        } else {
            for(int i = 0; i < 4; i ++) {
                Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
                if(nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map.length) {
                    continue;
                }
                visited[currentNode.r][currentNode.c] = true;
                solve(map, visited, nextNode, action - 1, probability * PROBABILITIES[i]);
                visited[currentNode.r][currentNode.c] = false;
            }
        }
    }

    private double sumOfProbabilities(double[][] map) {
        double result = 0;
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map.length; j ++) {
                //System.out.print(map[i][j] + " ");
                result += map[i][j];
            }
            //System.out.println();
        }
        return result;
    }
}
