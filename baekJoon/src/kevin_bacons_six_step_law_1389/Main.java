package kevin_bacons_six_step_law_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-12.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        LinkedList<Integer>[] linkedLists = new LinkedList[n + 1];
        for (int i = 1; i <= n; i ++) {
            linkedLists[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            linkedLists[a].offer(b);
            linkedLists[b].offer(a);
            Collections.sort(linkedLists[a]);
            Collections.sort(linkedLists[b]);
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(linkedLists, n));
    }
}

class Solution {
    private static int min = Integer.MAX_VALUE;

    public int solution(LinkedList<Integer>[] linkedLists, int n) {
        int answer = 0;
        int[] distanceArray = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            int distance = 0;
            for (int j = 1; j <= n; j ++) {
                if (i == j) {
                    continue;
                }
                boolean[] visited = new boolean[n + 1];
                distance += bfs(linkedLists, visited, i, j);
            }
            if (distance < min) {
                min = distance;
            }
            distanceArray[i] = distance;
        }
        for (int i = 1; i <= n; i ++) {
            if (distanceArray[i] == min) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    private int bfs(LinkedList<Integer>[] linkedLists, boolean[] visited, int startNode, int endNode) {
        int distance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int s = 0; s < size; s ++) {
                int nextNode = queue.poll();
                visited[nextNode] = true;
                if (nextNode == endNode) {
                    return distance;
                }
                for (int i = 0; i < linkedLists[nextNode].size(); i++) {
                    if (visited[linkedLists[nextNode].get(i)]) {
                        continue;
                    }
                    queue.offer(linkedLists[nextNode].get(i));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
