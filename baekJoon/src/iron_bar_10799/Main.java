package iron_bar_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-28.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String bar = stringTokenizer.nextToken();
        Solution solution = new Solution();
        System.out.println(solution.solution(bar));
    }
}

class Solution {
    public int solution(String bar) {
        int answer = 0;
        bar = bar.replace("()", "X");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < bar.length(); i ++) {
            if (bar.charAt(i) == '(') {
                stack.push(bar.charAt(i));
            } else if (bar.charAt(i) == ')') {
                stack.pop();
                answer++;
            } else {
                answer += stack.size();
            }
        }
        return answer;
    }
}
