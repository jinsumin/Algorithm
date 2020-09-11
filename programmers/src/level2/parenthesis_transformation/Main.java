package level2.parenthesis_transformation;

import java.util.Stack;

/**
 * Created by Crab on 2020-09-04.
 */
public class Main {
    public static void main(String[] args) {
        String p = "(()())()";
        Solution solution = new Solution();
        System.out.println(solution.solution(p));
    }
}

class Solution {
    public String solution(String p) {
        String answer = "";
        if (p.equals("")) {
            return answer;
        } else {
            answer = transform(p);
        }
        return answer;
    }

    private String transform(String p) {
        for (int i = 0; i < p.length(); i ++) {
            String u = p.substring(0, i + 1);
            String v = p.substring(i + 1);
            if (isBalanced(u)) {
                System.out.println("balanced u :" + u);
                System.out.println("rest v : " + v);
                if (isCorrect(u)) {
                    String result = "";
                    result += u;
                    result += transform(v);
                    return result;
                } else {
                    String result = "";
                    result += "(";
                    result += transform(v);
                    result += ")";
                    System.out.println("transform : " + result);
                    result += getConvertedU(u);
                    System.out.println("+convert " + result);
                    return result;
                }
            }
        }
        return "";
    }

    private boolean isBalanced(String u) {
        int a = 0; int b = 0;
        for (int i = 0; i < u.length(); i ++) {
            if (u.charAt(i) == '(') {
                a ++;
            } else {
                b ++;
            }
        }
        return a == b;
    }

    private boolean isCorrect(String u) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private String getConvertedU(String u) {
        StringBuilder result = new StringBuilder();
        System.out.println("u : " + u);
        u = u.substring(1, u.length() - 1);
        System.out.println("앞 뒤 제거한 u : " + u);
        for (int i = 0; i < u.length(); i ++) {
            if (u.charAt(i) == '(') {
                result.append(')');
            } else {
                result.append('(');
            }
        }
        System.out.println(result);
        return result.toString();
    }
}
