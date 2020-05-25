package knights_movement_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int testCase = Integer.parseInt(bufferedReader.readLine());
        for (int t = 1; t <= testCase; t++) {
            int sideLength = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            Node startNode = new Node(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            Node endNode = new Node(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            Solution solution = new Solution();
            System.out.println(solution.solution(sideLength, startNode, endNode));
        }
    }

    public static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

class Solution {
    private static final int[] MOVE_R = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] MOVE_C = {-2, -1, 1, 2, 2, 1, -1, -2};

    public int solution(int sideLength, Main.Node startNode, Main.Node endNode) {
        int answer = 0;
        boolean[][] visited = new boolean[sideLength][sideLength];
        Queue<Main.Node> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode.r][startNode.c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s ++) {
                Main.Node currentNode = queue.poll();
                assert currentNode != null;
                if (currentNode.r == endNode.r && currentNode.c == endNode.c) {
                    return answer;
                }
                for (int i = 0; i < 8; i++) {
                    Main.Node nextNode = new Main.Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
                    if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= sideLength || nextNode.c >= sideLength) {
                        continue;
                    }
                    if (visited[nextNode.r][nextNode.c]) {
                        continue;
                    }
                    queue.offer(nextNode);
                    visited[nextNode.r][nextNode.c] = true;
                }
            }
            answer++;
        }
        return answer;
    }
}
