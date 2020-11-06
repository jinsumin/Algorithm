package count_after_quad_compression;

import java.util.Arrays;

/**
 * Created by Crab on 2020-11-05.
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(arr)));
    }
}

class Solution {
    private static int countOfZero = 0;
    private static int countOfOne = 0;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int r = 0, c = 0;
        compress(arr, arr.length, r, c);
        answer[0] = countOfZero;
        answer[1] = countOfOne;
        return answer;
    }

    private void compress(int[][] arr, int width, int r, int c) {
        int value = arr[r][c];
        for (int i = r; i < r + width; i++) {
            for (int j = c; j < c + width; j++) {
                if (arr[i][j] != value) {
                    compress(arr, width / 2, r, c);
                    compress(arr, width / 2, r + width / 2, c);
                    compress(arr, width / 2, r, c + width / 2);
                    compress(arr, width / 2, r + width / 2, c + width / 2);
                    return;
                }
            }
        }
        if (value == 0) {
            countOfZero += 1;
            return;
        }
        countOfOne += 1;
    }
}
