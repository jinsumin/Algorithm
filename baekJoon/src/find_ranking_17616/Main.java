package find_ranking_17616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-03-18.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());

        int[][] data = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            data[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            data[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Solution solution = new Solution();
        solution.solution(data, n, m, x);
    }
}

class Solution {
    private int upperDistance = 0;
    private int lowerDistance = 0;

    public void solution(int[][] data, int n, int m, int x) {
        ArrayList<Integer>[] upperLinkedLists = new ArrayList[n + 1];
        LinkedList<Integer>[] lowerLinkedLists = new LinkedList[n + 1];
        boolean[] upperVisited = new boolean[n + 1];
        boolean[] lowerVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            upperLinkedLists[i] = new ArrayList<>();
            lowerLinkedLists[i] = new LinkedList<>();
        }

        for(int i = 1; i <= m; i ++) {
            upperLinkedLists[data[i][0]].add(data[i][1]);
            lowerLinkedLists[data[i][1]].offer(data[i][0]);
        }

        dfs(upperLinkedLists, upperVisited, x, 1);
        dfs(lowerLinkedLists, lowerVisited, x, 2);
        int upper = n - upperDistance + 1;
        int lower = lowerDistance;
        System.out.println(lower + " " + upper);
    }

    private void dfs(ArrayList<Integer>[] arrayLists, boolean[] visited, int startNode, int upOrLow) {
        if(visited[startNode]) {
            return;
        }
        visited[startNode] = true;
        if(upOrLow == 1) {
            upperDistance ++;
        } else {
            lowerDistance ++;
        }
        for(int i = 0; i < arrayLists[startNode].size(); i ++) {
            dfs(arrayLists, visited, arrayLists[startNode].get(i), upOrLow);
        }
    }

    private void dfs(LinkedList<Integer>[] linkedLists, boolean[] visited, int startNode, int upOrLow) {
        if(visited[startNode]) {
            return;
        }
        visited[startNode] = true;
        if(upOrLow == 1) {
            upperDistance ++;
        } else {
            lowerDistance ++;
        }
        for(int i = 0; i < linkedLists[startNode].size(); i ++) {
            dfs(linkedLists, visited, linkedLists[startNode].get(i), upOrLow);
        }
    }
}