package kakao_2020_internship.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Crab on 2020-05-09.
 */
public class Main {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        Solution solution = new Solution();
        System.out.println(solution.solution(expression));
    }
}

class Solution {
    private static final char[][] operatorPriorityList = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
    };

    public long solution(String expression) {
        LinkedList<Long> answer = new LinkedList<>();
        ArrayList<String>[] inputExpressions = new ArrayList[operatorPriorityList.length];
        for (int j = 0; j < operatorPriorityList.length; j++) {
            inputExpressions[j] = new ArrayList<>();
            int continuous = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (i == expression.length() - 1) {
                    inputExpressions[j].add(expression.substring(i - continuous));
                }
                if (expression.charAt(i) == '+') {
                    inputExpressions[j].add(expression.substring(i - continuous, i));
                    inputExpressions[j].add("+");
                    continuous = 0;
                } else if (expression.charAt(i) == '-') {
                    inputExpressions[j].add(expression.substring(i - continuous, i));
                    inputExpressions[j].add("-");
                    continuous = 0;
                } else if (expression.charAt(i) == '*') {
                    inputExpressions[j].add(expression.substring(i - continuous, i));
                    inputExpressions[j].add("*");
                    continuous = 0;
                } else {
                    continuous++;
                }
            }
        }
        for (int i = 0; i < operatorPriorityList.length; i++) {
            for (int j = 0; j < operatorPriorityList[0].length; j++) {
                for (int k = 0; k < inputExpressions[i].size(); k++) {
                    if (inputExpressions[i].get(k).charAt(0) == operatorPriorityList[i][j]) {
                        long calculateResult = 0;
                        if (operatorPriorityList[i][j] == '+') {
                            calculateResult = Long.parseLong(inputExpressions[i].get(k - 1)) + Long.parseLong(inputExpressions[i].get(k + 1));
                        } else if (operatorPriorityList[i][j] == '-') {
                            calculateResult = Long.parseLong(inputExpressions[i].get(k - 1)) - Long.parseLong(inputExpressions[i].get(k + 1));
                        } else if (operatorPriorityList[i][j] == '*') {
                            calculateResult = Long.parseLong(inputExpressions[i].get(k - 1)) * Long.parseLong(inputExpressions[i].get(k + 1));
                        }
                        inputExpressions[i].remove(k - 1);
                        inputExpressions[i].remove(k - 1);
                        inputExpressions[i].set(k - 1, String.valueOf(calculateResult));
                        k--;
                    }
                }
            }
            answer.offer(Math.abs(Long.parseLong(inputExpressions[i].get(0))));
        }
        Collections.sort(answer);
        return answer.pollLast();
    }
}
