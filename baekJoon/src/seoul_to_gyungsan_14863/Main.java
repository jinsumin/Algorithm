package seoul_to_gyungsan_14863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-25.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[][] array = new int[n][4];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            array[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            array[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            array[i][2] = Integer.parseInt(stringTokenizer.nextToken());
            array[i][3] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(k, array));
    }
}

class Solution {
    public int solution(int k, int[][] travel) {
        int[][] memo = new int[100][100001];
        memo[0][travel[0][0]] = travel[0][1];
        memo[0][travel[0][2]] = Math.max(memo[0][travel[0][2]], travel[0][3]);
        for (int i = 1; i < travel.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (memo[i - 1][j] == 0) {
                    continue;
                }
                if (j + travel[i][0] <= k) {
                    memo[i][j + travel[i][0]] = Math.max(memo[i][j + travel[i][0]], memo[i - 1][j] + travel[i][1]);
                }
                if (j + travel[i][2] <= k) {
                    memo[i][j + travel[i][2]] = Math.max(memo[i][j + travel[i][2]], memo[i - 1][j] + travel[i][3]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, memo[travel.length - 1][i]);
        }
        return max;
    }
}