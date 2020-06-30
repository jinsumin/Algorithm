package sangguens_travel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-06-30.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int testCase = Integer.parseInt(bufferedReader.readLine());
        for (int t = 1; t <= testCase; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int numbersOfNations = Integer.parseInt(stringTokenizer.nextToken());
            int kindOfPlanes = Integer.parseInt(stringTokenizer.nextToken());
            ArrayList[] arrayLists = new ArrayList[numbersOfNations + 1];
            for (int i = 1; i < numbersOfNations + 1; i++) {
                arrayLists[i] = new ArrayList<Integer>();
            }
            for (int m = 0; m < kindOfPlanes; m++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                arrayLists[a].add(b);
                arrayLists[b].add(a);
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(numbersOfNations, arrayLists));
        }
    }
}

class Solution {
    public int solution(int numbersOfNations, ArrayList[] arrayLists) {
        int answer = Integer.MAX_VALUE;
        for (int nation = 1; nation <= numbersOfNations; nation++) {
            boolean[] visited = new boolean[numbersOfNations + 1];
            int min = depthFirstSearch(nation, arrayLists, visited) - 1;
            if (answer > min) {
                answer = min;
            }
        }
        return answer;
    }

    private int depthFirstSearch(int nation, ArrayList[] arrayLists, boolean[] visited) {
        int distance = 0;
        for (int i = 0; i < arrayLists[nation].size(); i ++) {
            int nextNation = (int) arrayLists[nation].get(i);
            if (!visited[nextNation]) {
                visited[nextNation] = true;
                distance += 1 + depthFirstSearch(nextNation, arrayLists, visited);
            }
        }
        return distance;
    }
}
