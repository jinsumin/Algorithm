package level3.network;

import java.util.*;

/**
 * Created by REMI on 2020-02-25.
 */
public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(n, computers));
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        List<Integer>[] lists = new LinkedList[n];
        for(int i = 0; i < n; i ++) {
            lists[i] = new LinkedList<>();
            for(int j = 0; j < n; j ++) {
                if(computers[i][j] == 1) {
                    lists[i].add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        return bfs(visited, lists);
    }

    private int bfs(boolean[] visited, List<Integer>[] lists) {
        int count = 0;
        for(int index = 0; index < lists.length; index ++) {
            if(visited[index]) {
                continue;
            }
            Queue<List> queue = new LinkedList<>();
            queue.offer(lists[index]);
            while (!queue.isEmpty()) {
                List temp = queue.poll();
                for (int i = 0; i < temp.size(); i++) {
                    if (!visited[(int) temp.get(i)]) {
                        queue.offer(lists[(int) temp.get(i)]);
                        visited[(int) temp.get(i)] = true;
                    }
                }
            }
            count ++;
        }
        return count;
    }
}
