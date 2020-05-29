package level2.noodle_factory;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Crab on 2020-05-26.
 */
public class Main {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        Solution solution = new Solution();
        System.out.println(solution.solution(stock, dates, supplies, k));
    }
}

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int index = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int date = 0; date < k; date ++) {
            if (index < dates.length) {
                if (date == dates[index]) {
                    priorityQueue.offer(supplies[index]);
                    index++;
                }
            }
            stock--;
            if (stock < 0) {
                stock += priorityQueue.poll();
                answer++;
            }
        }
        return answer;
    }
}
