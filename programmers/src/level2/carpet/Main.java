package level2.carpet;

import java.util.Arrays;

/**
 * Created by Crab on 2020-09-01.
 */
public class Main {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(brown, yellow)));
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int height = i;
                int width = yellow / height;
                if ((width * 2) + (height * 2) + 4 == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}
