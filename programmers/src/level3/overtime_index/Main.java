package level3.overtime_index;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Crab on 2020-08-31.
 */
public class Main {
    public static void main(String[] args) {
        int n = 10;
        int[] works = {2, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.solution(n, works));
    }
}

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            priorityQueue.offer(work);
        }
        for (int i = 0; i < n; i++) {
            if (!priorityQueue.isEmpty()) {
                int temp = priorityQueue.poll();
                if (temp > 0) {
                    priorityQueue.offer(temp - 1);
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            int element = priorityQueue.poll();
            answer += (element * element);
        }
        return answer;
    }
}
