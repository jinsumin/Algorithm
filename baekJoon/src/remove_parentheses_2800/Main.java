package remove_parentheses_2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-05-11.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String expressions = stringTokenizer.nextToken();
        Solution solution = new Solution();
        solution.solution(expressions);
    }
}

class Solution {
    private static ArrayList<String> answerList = new ArrayList<>();

    public void solution(String expressions) {
        Stack<Parentheses> stack = new Stack<>();
        ArrayList<Pair> arrayList = new ArrayList<>();
        for (int i = 0; i < expressions.length(); i++) {
            if (expressions.charAt(i) == '(') {
                stack.push(new Parentheses('(', i));
            } else if (expressions.charAt(i) == ')') {
                if (stack.peek().bracket == '(') {
                    arrayList.add(new Pair(stack.pop().index, i));
                }
            }
        }
        boolean[] selected = new boolean[arrayList.size()];
        for (int i = 1; i <= selected.length; i++) {
            combination(expressions, arrayList, selected, 0, selected.length, i);
        }
        Collections.sort(answerList);
        int size = answerList.size();
        for (int i = 0; i < size; i ++) {
            System.out.println(answerList.get(i));
        }
    }

    private void combination(String expressions, ArrayList<Pair> arrayList, boolean[] selected, int start, int n, int r) {
        if (r == 0) {
            print(expressions, arrayList, selected, n);
            return;
        }
        for (int i = start; i < n; i++) {
            selected[i] = true;
            combination(expressions, arrayList, selected, i + 1, n, r - 1);
            selected[i] = false;
        }
    }

    private void print(String expressions, ArrayList<Pair> arrayList, boolean[] selected, int n) {
        String answer = expressions;
        for (int i = 0; i < n; i ++) {
            if (selected[i]) {
                answer = answer.substring(0, arrayList.get(i).openBracketIndex) + 'X' + answer.substring(arrayList.get(i).openBracketIndex + 1, arrayList.get(i).closeBracketIndex) + 'X' + answer.substring(arrayList.get(i).closeBracketIndex + 1);
            }
        }
        StringBuilder printAnswer = new StringBuilder();
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) != 'X') {
                assert false;
                printAnswer.append(answer.charAt(i));
            }
        }
        //System.out.println(printAnswer);
        if (!answerList.contains(String.valueOf(printAnswer))) {
            answerList.add(String.valueOf(printAnswer));
        }
    }

    private static class Parentheses {
        private char bracket;
        private int index;

        public char getBracket() {
            return bracket;
        }

        public int getIndex() {
            return index;
        }

        public Parentheses(char bracket, int index) {
            this.bracket = bracket;
            this.index = index;
        }
    }

    private static class Pair {
        private int openBracketIndex, closeBracketIndex;

        public int getOpenBracketIndex() {
            return openBracketIndex;
        }

        public int getCloseBracketIndex() {
            return closeBracketIndex;
        }

        public Pair(int openBracketIndex, int closeBracketIndex) {
            this.openBracketIndex = openBracketIndex;
            this.closeBracketIndex = closeBracketIndex;
        }
    }
}
