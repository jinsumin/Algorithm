package example3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int numberOfBalls = Integer.parseInt(stringTokenizer.nextToken());
        String balls = bufferedReader.readLine();

        Solution solution = new Solution();
        System.out.println(solution.solution(balls, numberOfBalls));
    }
}

class Solution {
    public int solution(String balls, int numberOfBalls) {
        int countRedBalls = 0;
        int countBlueBalls = 0;
        int leftRedBalls = 0;
        int leftBlueBalls = 0;
        int rightRedBalls = 0;
        int rightBlueBalls = 0;
        for (int i = 0; i < numberOfBalls; i++) {
            if (balls.charAt(i) == 'R') {
                countRedBalls++;
            } else if (balls.charAt(i) == 'B') {
                countBlueBalls++;
            }
        }
        int leftIndex = 0;
        while (balls.charAt(leftIndex++) == 'R') {
            leftRedBalls++;
            if(leftIndex >= numberOfBalls) {
                break;
            }
        }
        leftIndex = 0;
        while (balls.charAt(leftIndex++) == 'B') {
            leftBlueBalls++;
            if(leftIndex >= numberOfBalls) {
                break;
            }
        }
        int rightIndex = numberOfBalls - 1;
        while (balls.charAt(rightIndex--) == 'R') {
            rightRedBalls++;
            if(rightIndex < 0) {
                break;
            }
        }
        rightIndex = numberOfBalls - 1;
        while (balls.charAt(rightIndex--) == 'B') {
            rightBlueBalls++;
            if(rightIndex < 0) {
                break;
            }
        }
        return Math.min(countRedBalls - (Math.max(leftRedBalls, rightRedBalls)), countBlueBalls - (Math.max(leftBlueBalls, rightBlueBalls)));
    }
}
