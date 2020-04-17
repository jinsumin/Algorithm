package connection_elements_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        LinkedList[] linkedLists = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            linkedLists[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int leftNode = Integer.parseInt(stringTokenizer.nextToken());
            int rightNode = Integer.parseInt(stringTokenizer.nextToken());
            linkedLists[leftNode].add(rightNode);
            linkedLists[rightNode].add(leftNode);
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(linkedLists, n));
    }
}

class Solution {
    public int solution(LinkedList<Integer>[] linkedLists, int n) {
        int countOfLinkedElements = 0;
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (linkedLists[i].size() != 0) {
                    dfs(linkedLists, linkedLists[i].get(0), visited);
                }
                countOfLinkedElements++;
            }
        }
        return countOfLinkedElements;
    }

    private void dfs(LinkedList<Integer>[] linkedLists, int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i = 0; i < linkedLists[node].size(); i++) {
            dfs(linkedLists, linkedLists[node].get(i), visited);
        }
    }
}
