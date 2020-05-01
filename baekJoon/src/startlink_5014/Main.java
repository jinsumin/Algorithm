package startlink_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-30.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int F = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int G = Integer.parseInt(stringTokenizer.nextToken());
        int U = Integer.parseInt(stringTokenizer.nextToken());
        int D = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(F, S, G, U, D));
    }
}

class Solution {
    public String solution(int f, int s, int g, int u, int d) {
        int answer = 0;
        boolean[] visited = new boolean[f + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int currentFloor = queue.poll();
                if (currentFloor == g) {
                    return String.valueOf(answer);
                }
                if (!visited[currentFloor]) {
                    visited[currentFloor] = true;
                    int nextFloor1 = currentFloor + u;
                    if (nextFloor1 > 0 && nextFloor1 <= f) {
                        queue.offer(nextFloor1);
                    }
                    int nextFloor2 = currentFloor - d;
                    if (nextFloor2 > 0 && nextFloor2 <= f) {
                        queue.offer(nextFloor2);
                    }
                }
            }
            answer++;
        }
        return "use the stairs";
    }
}
