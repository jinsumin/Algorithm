package practice;

/**
 * Created by Crab on 2020-08-28.
 */
public class Main {
    public static void main(String[] args) {
        String s = "try hello world  ";
        Solution solution = new Solution();
        System.out.println(solution.solution(s, 1));
    }
}

class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                answer.append(' ');
            } else {
                if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                    int c = s.charAt(i);
                    c += n;
                    if (c > 'z') {
                        answer.append((char) (((int) c % (int) 'z') + 'a' - 1));
                    } else {
                        answer.append((char) (((int) c)));
                    }
                } else if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                    int c = s.charAt(i);
                    c += n;
                    if (c > 'Z') {
                        answer.append((char) (((int) c % (int) 'Z') + 'A' - 1));
                    } else {
                        answer.append((char) (((int) c)));
                    }
                }
            }
        }
        return answer.toString();
    }
}
