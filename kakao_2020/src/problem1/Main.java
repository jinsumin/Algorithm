package problem1;

import java.util.Stack;

/**
 * Created by Crab on 2020-03-28.
 */
public class Main {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.solution(board, moves));
    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i ++) {
            for (int j = 0; j < board.length; j ++) {
                if (board[j][moves[i] - 1] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == board[j][moves[i] - 1] ){
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[j][moves[i] - 1]);
                        }
                    } else {
                        stack.push(board[j][moves[i] - 1]);
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
