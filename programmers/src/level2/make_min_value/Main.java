package level2.make_min_value;


import java.util.Arrays;

/**
 * Created by Crab on 2020-11-12.
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        Solution solution = new Solution();
        System.out.println(solution.solution(A, B));
    }
}

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i ++) {
            answer += A[i] * B[B.length - i - 1];
        }
        return answer;
    }
}
