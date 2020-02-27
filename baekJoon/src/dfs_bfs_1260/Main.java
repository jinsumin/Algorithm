package dfs_bfs_1260;

import java.util.*;

/**
 * Created by REMI on 2020-02-13.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();
        List<Integer>[] lists = new LinkedList[n + 1];
        for(int i = 0; i < n + 1; i ++) {
            lists[i] = new LinkedList<>();
        }
        for(int i = 1; i <= m; i ++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            lists[node1].add(node2);
            lists[node2].add(node1);
            Collections.sort(lists[node1]);
            Collections.sort(lists[node2]);
        }
        Solution solution = new Solution();
        solution.solution(lists, v);
    }
}

class Solution {
    public void solution(List<Integer>[] lists, int startNode) {
        boolean[] visited = new boolean[lists.length];
        Arrays.fill(visited, false);
        dfs(lists, visited, startNode);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(lists, visited, startNode);
    }

    private void dfs(List<Integer>[] lists, boolean[] visited, int startNode) {
        if(visited[startNode]) {
            return;
        }
        visited[startNode] = true;
        System.out.print(startNode + " ");
        for(int i = 0; i < lists[startNode].size(); i ++) {
            dfs(lists, visited, lists[startNode].get(i));
        }
    }

    private void bfs(List<Integer>[] lists, boolean[] visited, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            if(!visited[temp]) {
                System.out.print(temp + " ");
                visited[temp] = true;
                for(int i = 0; i < lists[temp].size(); i ++) {
                    queue.offer(lists[temp].get(i));
                }
            }
        }
        System.out.println();
    }
}
