package problem2;

import java.util.*;

/**
 * Created by Crab on 2020-03-28.
 */
public class Main {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(s)));
    }
}

class Solution {
    public int[] solution(String s) {
        int[] answer;
        ArrayList<Integer> arrayList = new ArrayList<>();
        String copiedString = s.substring(1, s.length() - 2);   // "3},{2,3"
        String[] stringTokens = copiedString.split("},");    // "{3" // "{2,3"
        for (int i = 0; i < stringTokens.length; i ++) {
            stringTokens[i] = stringTokens[i].substring(1);     // "3" // "2,3"
            int sum = 0;
            String[] numberTokens = stringTokens[i].split(","); // "3" // "5"
            for (int j = 0; j < numberTokens.length; j ++) {
                sum += Integer.parseInt(numberTokens[j]);
            }
            arrayList.add(sum);
        }
        Collections.sort(arrayList);
        answer = new int[arrayList.size()];
        answer[0] = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i ++) {
            answer[i] = arrayList.get(i) - arrayList.get(i - 1);
        }
        return answer;
    }
}
