package efficient_hacking_1325;

import java.io.*;
import java.util.*;

/**
 * Created by Crab on 2020-04-29.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<Integer>[] arrayLists = new ArrayList[n];
        for (int i = 0; i < n; i ++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            arrayLists[a - 1].add(b - 1);
        }
        Solution solution = new Solution();
        solution.solution(arrayLists, n);
    }
}

class Solution {
    private int count = 0;
    private int[] relation;

    public void solution(ArrayList<Integer>[] arrayLists, int n) {
        relation = new int[n];
        /*
        for (int i = 1; i < n + 1; i ++ ) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            //relation[i] ++;
            while (!queue.isEmpty()) {
                int nextComputer = queue.poll();
                relation[i] ++;
                if (!visited[nextComputer]) {
                    visited[nextComputer] = true;
                    for (int element = 0; element < arrayLists[nextComputer].size(); element++) {
                        queue.offer(arrayLists[nextComputer].get(element));
                        //relation[i]++;
                    }
                }
            }
        }
        */
        for (int i = 0; i < n; i ++) {
            boolean[] visited = new boolean[n];
            dfs(arrayLists, visited, i);
        }
        int max = 0;
        for (int i = 0; i < n; i ++) {
            if (relation[i] > max) {
                max = relation[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            if (relation[i] == max) {
                stringBuilder.append(i + 1).append(" ");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private void dfs(ArrayList<Integer>[] arrayLists, boolean[] visited, int startNode) {
        if (visited[startNode]) {
            return;
        }
        visited[startNode] = true;
        for (Integer integer : arrayLists[startNode]) {
            int nextNode = integer;
            relation[nextNode]++;
            dfs(arrayLists, visited, nextNode);
        }
//        for (int i = 0; i < arrayLists[startNode].size(); i ++) {
//            dfs(arrayLists, visited, arrayLists[startNode].get(i));
//        }
    }
}
