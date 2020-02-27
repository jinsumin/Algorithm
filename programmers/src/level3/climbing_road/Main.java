package level3.climbing_road;

/**
 * Created by REMI on 2020-01-23.
 */
public class Main {
    public static void main(String[] args) {
        int[][] puddles = {{2, 2}, {2, 3}, {2, 4}};
        int m = 4;
        int n = 3;
        Solution sol = new Solution();
        System.out.println(sol.solution(m, n, puddles));
    }
}

class Solution {
    private static final int CONST = 1000000007;
    private static final int WATER = -1;
    private static int[][] memo;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        memo = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            memo[puddle[1]][puddle[0]] = WATER;
        }
        memo[1][1] = 1;
        for(int i = 1; i < n + 1; i ++) {
            for(int j = 1; j < m + 1; j ++) {
                if(memo[i][j] == WATER) {
                    memo[i][j] = 0;
                }else {
                    memo[i][j] += (memo[i - 1][j] + memo[i][j - 1]) % CONST;
                }
            }
        }
        answer = memo[n][m];
        return answer;
    }
}
