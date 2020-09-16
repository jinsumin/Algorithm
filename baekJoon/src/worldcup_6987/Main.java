package worldcup_6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Crab on 2020-09-16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 4; t++) {
            String input = bufferedReader.readLine();
            Solution solution = new Solution();
            System.out.println(solution.solution(input));
        }
    }
}

class Solution {
    public int solution(String input) {
        int answer = 0;
        String result = input.replace(" ", "");
        //System.out.println(result);
        int drawFlip = 1;
        int check1 = 0;
        int check2 = 0;
        Queue<Integer> winLoseQueue = new LinkedList<>();
        Queue<Integer> drawQueue = new LinkedList<>();
        for (int i = 0; i < result.length(); i++) {
            int value = Integer.parseInt(String.valueOf(result.charAt(i)));
            //System.out.println("value : " + value);
            if (value > 5 || value < 0) {
                return 0;
            }
            if (i % 3 == 0) {
                if (value == 5) {
                    check1 = i + 2;
                }
                if (check2 < i && check2 != 0) {
                    if (value == 0) {
                        System.out.println("error");
                        return 0;
                    }
                }
                for (int j = 0; j < value; j++) {
                    winLoseQueue.offer(1);
                }
            } else if (i % 3 == 2) {
                if (check1 < i && check1 != 0) {
                    if (value == 0) {
                        System.out.println("error");
                        return 0;
                    }
                }
                if (value == 5) {
                    check2 = i + 2;
                }
                for (int j = 0; j < value; j++) {
                    winLoseQueue.offer(-1);
                }
            } else {
                for (int j = 0; j < value; j++) {
                    drawQueue.offer(drawFlip);
                }
                drawFlip *= -1;
            }
        }
        //System.out.println("win : " + win);
        //System.out.println("lose : " + lose);
        if (isPossibleWinLose(winLoseQueue) && isPossibleDraw(drawQueue)) {
            answer = 1;
        }
        return answer;
    }

    private boolean isPossibleWinLose(Queue<Integer> winLoseQueue) {
        int result = 0;
        while (!winLoseQueue.isEmpty()) {
            result += winLoseQueue.poll();
        }
        return result == 0;
    }

    private boolean isPossibleDraw(Queue<Integer> queue) {
        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result == 0;
    }
}
