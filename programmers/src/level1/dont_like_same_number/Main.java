package level1.dont_like_same_number;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Crab on 2020-09-09.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(arr)));
    }
}

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int element : arr) {
            if (linkedList.isEmpty()) {
                linkedList.offer(element);
            } else if (linkedList.peekLast() != element) {
                linkedList.offer(element);
            }
        }

        answer = new int[linkedList.size()];
        for (int i = 0; i < answer.length; i ++) {
            answer[i] = linkedList.pollFirst();
        }

        return answer;
    }
}
