package programmers.level2.number_baseball;

/**
 * Created by REMI on 2020-02-18.
 */
public class Main {
    public static void main(String[] args) {
        int[][] baseball = {
                {123, 1, 1},
                {356, 1, 0},
                {327, 2, 0},
                {489, 0, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(baseball));
    }
}

class Solution {
    private class Baseball {
        String number;
        int strike;
        int ball;

        public Baseball(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public int solution(int[][] baseball) {
        int answer = 0;
        Baseball[] baseballs = new Baseball[baseball.length];
        for (int number = 123; number <= 987; number++) {
            char firstNumber = String.valueOf(number).charAt(0);
            char secondNumber = String.valueOf(number).charAt(1);
            char thirdNumber = String.valueOf(number).charAt(2);
            if (secondNumber == '0' || thirdNumber == '0') {
                continue;
            }
            if (firstNumber == secondNumber || firstNumber == thirdNumber || secondNumber == thirdNumber) {
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < baseballs.length; i++) {
                baseballs[i] = new Baseball(String.valueOf(baseball[i][0]), baseball[i][1], baseball[i][2]);
                if (!isCorrect(baseballs[i], firstNumber, secondNumber, thirdNumber)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isCorrect(Baseball baseball, char firstNumber, char secondNumber, char thirdNumber) {
        int countStrike = 0;
        int countBall = 0;
        if (baseball.number.charAt(0) == firstNumber) {
            countStrike++;
        }
        if (baseball.number.charAt(1) == secondNumber) {
            countStrike++;
        }
        if(baseball.number.charAt(2) == thirdNumber) {
            countStrike++;
        }
        if(baseball.number.charAt(0) != firstNumber && (baseball.number.charAt(0) == secondNumber || baseball.number.charAt(0) == thirdNumber)) {
            countBall++;
        }
        if(baseball.number.charAt(1) != secondNumber && (baseball.number.charAt(1) == firstNumber || baseball.number.charAt(1) == thirdNumber)) {
            countBall++;
        }
        if(baseball.number.charAt(2) != thirdNumber && (baseball.number.charAt(2) == firstNumber || baseball.number.charAt(2) == secondNumber)) {
            countBall++;
        }
        if(baseball.strike == countStrike && baseball.ball == countBall) {
            return true;
        }
        return false;
    }
}