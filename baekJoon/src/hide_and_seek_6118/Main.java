package hide_and_seek_6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
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
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        LinkedList<Integer>[] linkedLists = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            linkedLists[i] = new LinkedList<>();
        }
        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            linkedLists[a].offer(b);
            linkedLists[b].offer(a);
            Collections.sort(linkedLists[a]);
            Collections.sort(linkedLists[b]);
        }
        Solution solution = new Solution();
        solution.solution(linkedLists);
    }
}

class Solution {
    public void solution(LinkedList<Integer>[] linkedLists) {
        boolean[] visited = new boolean[linkedLists.length + 1];
        int hideNode = 0;
        int depth = 0;
        int size = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                size = 0;
                for (int i = 0; i < linkedLists[currentNode].size(); i++) {
                    if (!visited[linkedLists[currentNode].get(i)]) {
                        hideNode = linkedLists[currentNode].get(0);
                        queue.offer(linkedLists[currentNode].get(i));
                        size++;
                    }
                }
                depth++;
            }
        }
        System.out.println(hideNode + " " + depth + " " + size);
    }
}
