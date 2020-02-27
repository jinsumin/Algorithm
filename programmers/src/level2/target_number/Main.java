package level2.target_number;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by REMI on 2020-02-25.
 */
public class Main {
    public static void main(String[] args) {
        int[] numbers = {-1, -1, 1, 1, 1};
        int target = 3;
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers, target));
    }
}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        //answer = dfs(numbers, target, 0, 0);
        answer = bfs(numbers, target);
        return answer;
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        int result;
        if (index == numbers.length) {
            if (sum == target) {
                return 1;   // 경우의 수 있을 경우
            }
            return 0;   // 경우의 수 없을 경우
        }
        result = dfs(numbers, target, index + 1, sum + numbers[index]) +
                dfs(numbers, target, index + 1, sum - numbers[index]);
        return result;
    }

    private int bfs(int[] numbers, int target) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(numbers[0]);
        queue.offer(-numbers[0]);

        int index = 1;
        while (index < numbers.length) {
            int size = queue.size();
            while (size != 0) {
                int temp = queue.poll();
                int temp1 = numbers[index] * (-1) + temp;
                int temp2 = numbers[index] + temp;
                queue.offer(temp1);
                queue.offer(temp2);
                size--;
            }
            index++;
        }

        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                count++;
            }
        }
        return count;
    }
}
