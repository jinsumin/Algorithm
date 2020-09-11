package level2.functional_development;

import java.util.*;

/**
 * Created by Crab on 2020-09-02.
 */

public class Main {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(progresses, speeds)));
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Development[] developments = new Development[progresses.length];
        for (int i = 0; i < developments.length; i++) {
            developments[i] = new Development(progresses[i], speeds[i]);
            if (!queue.isEmpty() && queue.peek() < developments[i].getDevelopmentDay()) {
                arrayList.add(queue.size());
                queue.clear();
            }
            queue.offer(developments[i].getDevelopmentDay());
        }
        arrayList.add(queue.size());
        answer = new int[arrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    public static class Development {
        private final int progress;
        private final int speed;

        public Development(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public int getDevelopmentDay() {
            return (int) Math.ceil((double) (100 - this.progress) / this.speed);
        }
    }
}
