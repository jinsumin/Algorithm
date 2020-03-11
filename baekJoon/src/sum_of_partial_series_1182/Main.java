package sum_of_partial_series_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-11.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int s = Integer.parseInt(stringTokenizer.nextToken());
        int[] array = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(array, s));
    }
}

class Solution {
    private int countOfPartialSeries = 0;

    public int solution(int[] array, int sum) {
        for (int k = 1; k <= array.length; k++) {
            boolean[] visited = new boolean[array.length];
            combination(array, visited, 0, k, sum);
        }
        return countOfPartialSeries;
    }

    private void combination(int[] array, boolean[] visited, int start, int k, int sum) {
        if (k == 0) {
            int temp = 0;
            for (int i = 0; i < array.length; i++) {
                if (visited[i]) {
                    temp += array[i];
                }
            }
            if (temp == sum) {
                countOfPartialSeries++;
            }
        } else {
            for (int i = start; i < array.length; i++) {
                visited[i] = true;
                combination(array, visited, i + 1, k - 1, sum);
                visited[i] = false;
            }
        }
    }
}
