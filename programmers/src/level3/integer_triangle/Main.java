package level3.integer_triangle;

/**
 * Created by REMI on 2020-01-21.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(sol.solution(triangle));
    }
}

class Solution {
    private int[][] memo;
    public int solution(int[][] triangle) {
        int answer = 0;
        initTriangle(triangle);
        for(int i = 2; i < triangle.length; i ++) {
            for(int j = 1; j < i; j ++) {
                memo[i][j] = Math.max(memo[i - 1][j - 1], memo[i - 1][j]) + triangle[i][j];
            }
        }
        answer = findMax();
        return answer;
    }

    private void initTriangle(int[][] triangle) {
        memo = new int[triangle.length][triangle.length];
        memo[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i ++) {
            memo[i][0] = memo[i - 1][0] + triangle[i][0];
            memo[i][i] = memo[i - 1][i - 1] + triangle[i][i];
        }
    }

    private int findMax() {
        int max = 0;
        for(int i = 0; i < memo.length; i ++){
            if(memo[memo.length - 1][i] > max) {
                max = memo[memo.length - 1][i];
            }
        }
        return max;
    }
}
