package kakao_2020_internship.problem3;

import java.util.ArrayList;

/**
 * Created by Crab on 2020-05-09.
 */
public class Main {
    public static void main(String[] args) {
        String[] gems = {
                "AA", "AB", "AC", "AA", "AC"
        };
        Solution solution = new Solution();
        int[] answer = solution.solution(gems);
        System.out.println(answer[0] + " " + answer[1]);
    }
}

class Solution {

    public int[] solution(String[] gems) {
        int[] answer;
        answer = new int[2];
        ArrayList<String> jewelList = new ArrayList<>();
        for (String gem : gems) {
            if (!jewelList.contains(gem)) {
                jewelList.add(gem);
            }
        }
        int length = jewelList.size();
        boolean[] selected;
        for (int len = length; len < gems.length; len++) {
            for (int i = 0; i < gems.length - len; i++) {
                selected = new boolean[jewelList.size()];
                for (int j = i; j < i + len; j++) {
                    selected[jewelList.indexOf(gems[j])] = true;
                }
                boolean flag = true;
                for (boolean b : selected) {
                    if (!b) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer[0] = i + 1;
                    answer[1] = i + len;
                    return answer;
                }
            }
        }
        answer[0] = 1;
        answer[1] = gems.length;
        return answer;
    }
}
