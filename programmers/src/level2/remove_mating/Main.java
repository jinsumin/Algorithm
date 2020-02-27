package level2.remove_mating;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by REMI on 2020-01-13.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i ++){
            if(stack.isEmpty()) { stack.push(s.charAt(i)); }
            else if(stack.peek() == s.charAt(i)) { stack.pop(); }
        }
        if(stack.isEmpty()) { answer = 1; }
        return answer;
    }
}
