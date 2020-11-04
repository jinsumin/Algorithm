package level2.build_jaden_case_string;


import java.util.Arrays;

/**
 * Created by Crab on 2020-10-28.
 */
public class Main {
    public static void main(String[] args) {
        String s = "ff   gg";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] inputs = s.split(" ");
        System.out.println(Arrays.toString(inputs));
        for (String input : inputs) {
            if (!input.equals(" ")) {
                answer.append(getJadenCase(input)).append(" ");
            }
        }
        answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        return answer.toString();
    }

    private String getJadenCase(String input) {
        String jadenCaseString = input.toLowerCase();
        if (jadenCaseString.charAt(0) >= 'a' && jadenCaseString.charAt(0) <= 'z') {
            return Character.toUpperCase(jadenCaseString.charAt(0)) + jadenCaseString.substring(1);
        }
        return jadenCaseString;
    }
}
