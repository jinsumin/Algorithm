package level2.correct_parentheses;

import java.util.Stack;

/**
 * Created by REMI on 2020-01-21.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "()()((()";
        System.out.println(sol.solution(s));
    }
}

class Solution {
    private Stack stack = new Stack();
    boolean solution(String s) {
        boolean answer = true;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            }else if(s.charAt(i) == ')') {
                if(stack.isEmpty()) { return false; }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) { answer = false; }
        return answer;
    }
}
