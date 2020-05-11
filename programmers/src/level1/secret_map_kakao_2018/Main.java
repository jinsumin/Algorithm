package level1.secret_map_kakao_2018;

import java.util.Arrays;

/**
 * Created by Crab on 2020-05-05.
 */
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        Solution solution = new Solution();
        String[] result = solution.solution(n, arr1, arr2);
        for (int i = 0; i < result.length; i ++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        for (int i = 0; i < n; i ++) {
            int number1 = arr1[i];
            int number2 = arr2[i];
            int index1 = n - 1;
            int index2 = n - 1;
            while (number1 > 0) {
                map1[i][index1] = (number1 % 2);
                number1 /= 2;
                index1--;
            }
            while (number2 > 0) {
                map2[i][index2] = (number2 % 2);
                number2 /= 2;
                index2--;
            }
        }
        for (int i = 0; i < n; i ++) {
            answer[i] = "";
            for (int j = 0; j < n; j ++) {
                if (map1[i][j] != 0 || map2[i][j] != 0) {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }
}
