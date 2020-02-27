package level2.make_big_number;

/**
 * Created by REMI on 2020-02-05.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("4177252841", 4));
    }
}

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for(int i = 0; i < number.length() - k; i ++) {
            char max = '0';
            for(int j = index; j <= i + k; j ++) {
                if(number.charAt(j) > max) {
                    max = number.charAt(j);
                    index = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
