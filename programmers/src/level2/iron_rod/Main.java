package level2.iron_rod;

import java.util.Stack;

/**
 * Created by Crab on 2020-05-28.
 */
public class Main {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        Solution solution = new Solution();
        System.out.println(solution.solution(arrangement));
    }
}

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        arrangement = arrangement.replace("()", "X");
        // Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < arrangement.length(); i ++) {
            if (arrangement.charAt(i) == '(') {
                // stack.push(arrangement.charAt(i));
                count ++;
            } else if (arrangement.charAt(i) == ')') {
                answer += 1;
                // stack.pop();
                count --;
            } else {
                // answer += stack.size();
                answer += count;
            }
        }
        return answer;
    }
}
