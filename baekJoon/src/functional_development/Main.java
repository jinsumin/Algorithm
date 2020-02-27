package functional_development;

import java.util.*;

/**
 * Created by REMI on 2020-02-17.
 */
public class Main {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        Solution solution = new Solution();
        for(int i = 0; i < 2; i ++) {
            System.out.println(solution.solution(progresses, speeds)[i]);
        }
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Development[] developments = new Development[progresses.length];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i ++) {
            developments[i] = new Development(progresses[i], speeds[i]);
            if(!queue.isEmpty() && queue.peek() < developments[i].getDevelopmentDay()) {
                list.add(queue.size());
                queue.clear();
            }
            queue.offer(developments[i].getDevelopmentDay());
        }
        list.add(queue.size());
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i ++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private class Development {
        int progress, speed;

        public Development(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public int getDevelopmentDay() {
            return (int) Math.ceil((100 - this.progress) / this.speed);

        }
    }
}
