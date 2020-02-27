package level2.ramen_factory;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-15.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        int result;
        if(index == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        result = dfs(numbers, target, index + 1, sum + numbers[index]) +
                dfs(numbers, target, index + 1, sum - numbers[index]);
        return result;
    }
}
