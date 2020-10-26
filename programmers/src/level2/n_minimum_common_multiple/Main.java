package level2.n_minimum_common_multiple;

import java.util.Arrays;

/**
 * Created by Crab on 2020-10-26.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        Solution solution = new Solution();
        System.out.println(solution.solution(arr));
    }
}

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
            // System.out.println(answer);
        }
        return answer;
    }

    public static int gcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcd(second, first % second);
    }
}
