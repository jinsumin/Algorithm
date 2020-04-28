package numerical_square_1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-24.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    public int solution(int[][] map) {
        int maxSize = Math.min(map.length, map[0].length);
        while (maxSize > 0) {
            for (int i = 0; i <= map.length - maxSize; i++) {
                for (int j = 0; j <= map[0].length - maxSize; j++) {
                    if (map[i][j] == map[i + maxSize - 1][j]) {
                        if (map[i][j] == map[i][j + maxSize - 1]) {
                            if (map[i][j] == map[i + maxSize - 1][j + maxSize - 1]) {
                                return maxSize * maxSize;
                            }
                        }
                    }
                }
            }
            maxSize--;
        }
        return 0;
    }
}
