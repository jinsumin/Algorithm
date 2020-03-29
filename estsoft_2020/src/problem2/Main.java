package problem2;

import java.util.HashMap;

/**
 * Created by Crab on 2020-03-29.
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {51, 71, 17, 42};
        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}

class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <= 100; i ++) {
            hashMap.put(i, 0);
        }
        int answer = -1;
        for (int value : A) {
            int result = digitSum(value);
            if (hashMap.get(result) != 0) {
                answer = Math.max(answer, hashMap.get(result) + value);
            }
            hashMap.put(result, Math.max(hashMap.get(result), value));
        }
        return answer;
    }

    private int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }
}
