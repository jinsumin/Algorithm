package level2.most_biggest_square;

import java.util.Arrays;

/**
 * Created by Crab on 2020-10-27.
 */
public class Main {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0},
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(board));
    }
}

class Solution {
    public int solution(int[][] board) {
        int answer = 1;
        for (int i = 0; i < 10; i++) {
            int[][] copiedBoard = board.clone();
            for (int r = 0; r < board.length; r ++) {
                for (int c = 0; c < board[0].length; c ++) {
                    System.out.print(copiedBoard[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println(Arrays.deepToString(board));
            for (int r = 1; r < board.length; r++) {
                for (int c = 1; c < board[0].length; c++) {
                    System.out.println("모든 r, c :" + r + " , " + c);
                    if (board[r][c] == board[r][c - 1] && board[r][c] == board[r - 1][c] && board[r][c] == board[r - 1][c - 1] && board[r][c] > 0) {
                        System.out.println("r : " + r + ", c : " + c);
                        copiedBoard[r][c] += 1;
                        if (answer < copiedBoard[r][c]) {
                            answer = copiedBoard[r][c];
                        }
                    }
                }
            }
            for (int r = 0; r < board.length; r ++) {
                for (int c = 0; c < board[0].length; c ++) {
                    System.out.print(copiedBoard[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
            board = copiedBoard.clone();
        }
        return answer * answer;
    }
}
