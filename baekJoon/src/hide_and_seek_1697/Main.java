package hide_and_seek_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-03.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int positionA = Integer.parseInt(stringTokenizer.nextToken());
        int positionB = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(positionA, positionB));
    }
}

class Solution {
    private static final int MOVE_BACK = 1;
    private static final int MOVE_FRONT = 2;
    private static final int MOVE_JUMP = 3;

    private int time = 0;

    public int solution(int positionA, int positionB) {
        boolean[] visited = new boolean[100001];
        bfs(visited, positionA, positionB);
        return time;
    }

    private void bfs(boolean[] visited, int positionA, int positionB) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(positionA);
        visited[positionA] = true;
        while(!queue.isEmpty()) {
            int nextPositionA = queue.poll();
            int size = queue.size();
            time++;
            for (int s = 0; s < size; s++) {
                if (nextPositionA == positionB) {
                    return;
                }
                for (int i = 1; i <= 3; i++) {
                    if (i == 1) {
                        nextPositionA -= 1;
                    } else if (i == 2) {
                        nextPositionA += 1;
                    } else {
                        nextPositionA *= 2;
                    }
                    if (nextPositionA > 100000) {
                        continue;
                    }
                    if (nextPositionA < 0) {
                        continue;
                    }
                    if (visited[nextPositionA]) {
                        continue;
                    }
                    visited[nextPositionA] = true;
                    queue.offer(nextPositionA);
                }
            }
        }
    }
}