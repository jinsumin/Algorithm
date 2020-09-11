package level3.longest_palindrome;

import java.util.*;

/**
 * Created by Crab on 2020-09-11.
 */
public class Main {
    public static void main(String[] args) {
        String s = "abcd";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {
    public int solution(String s) {
        int answer = 1;
        for (int i = 1; i < s.length() - 1; i ++) {
            int lengthOfPalindrome = getLongestPalindromeStartWith(s, i);
            if (lengthOfPalindrome > answer) {
                answer = lengthOfPalindrome;
            }
        }
        return answer;
    }

    private int getLongestPalindromeStartWith(String s, int startIndex) {
        int lengthOfOddCase = 1;
        int lengthOfEvenCase = 0;
        int right = startIndex;
        int left = startIndex - 1;
        if (s.charAt(left) == s.charAt(right)) {
            lengthOfEvenCase += 2;
            while (true) {
                right ++;
                left --;
                if (right > s.length() - 1 || left < 0) {
                    break;
                }
                if (s.charAt(left) == s.charAt(right)) {
                    lengthOfEvenCase += 2;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i + startIndex < s.length(); i ++) {
            if (startIndex - i < 0) {
                break;
            } else {
                if (s.charAt(startIndex + i) == s.charAt(startIndex - i)) {
                    lengthOfOddCase += 2;
                } else {
                    break;
                }
            }
        }
        return Math.max(lengthOfEvenCase, lengthOfOddCase);
    }
}
