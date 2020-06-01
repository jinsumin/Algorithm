package level2.h_index;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Crab on 2020-05-29.
 */
public class Main {
    public static void main(String[] args) {
        int[] citations = {2, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.solution(citations));
    }
}

class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int citation : citations) {
            arrayList.add(citation);
        }
        arrayList.sort(Collections.reverseOrder());
        while (answer != 0) {
            if (isHIndex(arrayList, answer)) {
                return answer;
            }
            answer--;
        }
        return answer;
    }

    private boolean isHIndex(ArrayList<Integer> arrayList, int HIndex) {
        int count = 0;
        for (Integer integer : arrayList) {
            if (integer >= HIndex) {
                count++;
            } else {
                break;
            }
        }
        return count >= HIndex;
    }
}
