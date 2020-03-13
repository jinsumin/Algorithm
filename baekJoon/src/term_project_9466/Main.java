package term_project_9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-11.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int testCase = Integer.parseInt(stringTokenizer.nextToken());
        for (int t = 1; t <= testCase; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int[] students = new int[n + 1];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(students, n));
        }
    }
}

class Solution {
    private static int[] startNode, check;

    public int solution(int[] students, int n) {
        startNode = new int[n + 1];
        check = new int[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                answer += dfs(students, i, 1, i);
            }
        }
        return n - answer;
    }

    private int dfs(int[] students, int i, int count, int start) {
        if (check[i] != 0) {
            if (start != startNode[i]) {
                return 0;
            }
            return count - check[i];
        }

        check[i] = count;
        startNode[i] = start;
        return dfs(students, students[i], count + 1, start);
    }
}
