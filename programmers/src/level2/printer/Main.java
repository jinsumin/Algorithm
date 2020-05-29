package level2.printer;

import java.util.*;

/**
 * Created by Crab on 2020-05-28.
 */
public class Main {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        Solution solution = new Solution();
        System.out.println(solution.solution(priorities, location));
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Documents> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            Documents document = new Documents(i, priorities[i]);
            queue.offer(document);
            priorityQueue.offer(document.importance);
        }
        while(!queue.isEmpty()) {
            Documents tempDocuments = queue.poll();
            assert tempDocuments != null;
            if (priorityQueue.peek() == tempDocuments.importance) {
                priorityQueue.poll();
                answer++;
                if (tempDocuments.number == location) {
                    break;
                }
            } else {
                queue.offer(tempDocuments);
            }
        }
        return answer;
    }

    private static class Documents {
        int number, importance;

        public Documents(int number, int importance) {
            this.number = number;
            this.importance = importance;
        }
    }
}
