package hide_and_seek_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-27.
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
    private int time = 0;

    public int solution(int positionA, int positionB) {
        boolean[] visited = new boolean[200001];
        bfs(visited, positionA, positionB);
        return time;
    }

    private void bfs(boolean[] visited, int positionA, int positionB) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(positionA);
        visited[positionA] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int currentPositionA = queue.poll();
                if (currentPositionA == positionB) {
                    return;
                }
                for (int i = 0; i < 3; i++) {
                    int nextPositionA = currentPositionA;
                    if (i == 0) {
                        nextPositionA -= 1;
                    } else if (i == 1) {
                        nextPositionA += 1;
                    } else {
                        nextPositionA *= 2;
                    }
                    if (nextPositionA < 0) {
                        continue;
                    }
                    if (nextPositionA > 200000) {
                        continue;
                    }
                    if (visited[nextPositionA]) {
                        continue;
                    }
                    queue.offer(nextPositionA);
                    visited[nextPositionA] = true;
                }
            }
            time++;
        }
    }
}