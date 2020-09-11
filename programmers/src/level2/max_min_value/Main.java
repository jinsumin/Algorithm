package level2.max_min_value;

/**
 * Created by Crab on 2020-09-04.
 */
public class Main {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] inputs = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String input : inputs) {
            int element = Integer.parseInt(input);
            if (max < element) {
                max = element;
            }
            if (min > element) {
                min = element;
            }
        }
        answer += (min + " " + max);
        return answer;
    }
}
