package level2.compression_kakao_2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Crab on 2020-05-07.
 */
public class Main {
    public static void main(String[] args) {
        String msg = "KAKAO";
        Solution solution = new Solution();
        solution.solution(msg);
    }
}

class Solution {
    private static ArrayList<String> indexNumber = new ArrayList<>();
    private static Queue<Integer> indexResult = new LinkedList<>();

    public int[] solution(String msg) {
        msg += ".";
        int[] answer = {};
        indexNumber.add(".");
        for (int i = 0; i < 26; i++) {
            char word = (char) ('A' + i);
            indexNumber.add(String.valueOf(word));
        }
        for (int i = 0; i < msg.length(); i++) {
            boolean flag;
            int tempIndex = 0;
            for (int continuous = 1; i + continuous < msg.length() + 1; continuous++) {
                String partialWord = msg.substring(i, i + continuous);
                flag = true;
                for (int j = 0; j < indexNumber.size(); j ++) {
                    if (partialWord.equals(indexNumber.get(j))) {
                        tempIndex = j;
                        flag = false;
                    }
                }
                if (flag) {
                    indexNumber.add(partialWord);
                    indexResult.offer(tempIndex);
                    i += (continuous - 2);
                    break;
                }
            }
        }
        answer = new int[indexResult.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = indexResult.poll();
            //System.out.print(answer[i] + " ");
        }
        return answer;
    }
}
