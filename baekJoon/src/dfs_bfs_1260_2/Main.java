package dfs_bfs_1260_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-04-14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int v = Integer.parseInt(stringTokenizer.nextToken());
        LinkedList<Integer>[] linkedLists = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            linkedLists[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int leftNode = Integer.parseInt(stringTokenizer.nextToken());
            int rightNode = Integer.parseInt(stringTokenizer.nextToken());
            linkedLists[leftNode].add(rightNode);
            linkedLists[rightNode].add(leftNode);
            Collections.sort(linkedLists[leftNode]);
            Collections.sort(linkedLists[rightNode]);
        }
        Solution solution = new Solution();
        solution.solution(linkedLists, v);
    }
}

class Solution {
    public void solution(LinkedList<Integer>[] linkedLists, int startNode) {
        boolean[] visited = new boolean[linkedLists.length];
        dfs(linkedLists, visited, startNode);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(linkedLists, visited, startNode);
    }

    private void dfs(LinkedList<Integer>[] linkedLists, boolean[] visited, int startNode) {
        if(visited[startNode]) {
            return;
        }
        System.out.print(startNode + " ");
        visited[startNode] = true;
        for(int i = 0; i < linkedLists[startNode].size(); i ++) {
            dfs(linkedLists, visited, linkedLists[startNode].get(i));
        }
    }

    private void bfs(LinkedList<Integer>[] linkedLists, boolean[] visited, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                System.out.print(node + " ");
                visited[node] = true;
                for (int i = 0; i < linkedLists[node].size(); i ++) {
                    queue.offer(linkedLists[node].get(i));
                }
            }
        }
    }
}
