package kakao_2020_internship.problem4;

/**
 * Created by Crab on 2020-05-09.
 */
public class Main {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(board));
    }
}

class Solution {
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};
    private static final int SAME_DIRECTION_PRICE = 100;
    private static final int ANOTHER_DIRECTION_PRICE = 600;
    private static final int WALL = 1;
    private static final int EMPTY = 0;

    private static int g_min = Integer.MAX_VALUE;
    //private static LinkedList<Integer> totalPriceList = new LinkedList<>();

    public int solution(int[][] board) {
        int answer = 0;
        Node startNode = new Node(0, 0);
        Node endNode = new Node(board.length - 1, board.length - 1);
        boolean[][] visited = new boolean[board.length][board.length];
        dfs(startNode, endNode, board, visited, 0, 4);
        //Collections.sort(totalPriceList);
        //answer = totalPriceList.pollFirst();
        answer = g_min;
        return answer;
    }

    private void dfs(Node currentNode, Node endNode, int[][] board, boolean[][] visited, int price, int direction) {
        visited[currentNode.r][currentNode.c] = true;
        if (currentNode.r == endNode.r && currentNode.c == endNode.c) {
            //totalPriceList.offer(price - 500);
            g_min = price - 500;
            return;
        }
        for (int i = 0; i < 4; i++) {
            Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
            int nextPrice = price;
            int nextDirection = i;
            if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= board.length || nextNode.c >= board.length) {
                continue;
            }
            if (visited[nextNode.r][nextNode.c]) {
                continue;
            }
            if (board[nextNode.r][nextNode.c] == WALL) {
                continue;
            }
            if (nextDirection == direction) {
                nextPrice += SAME_DIRECTION_PRICE;
            } else {
                nextPrice += ANOTHER_DIRECTION_PRICE;
            }
            if (nextPrice >= g_min) {
                continue;
            }
            visited[nextNode.r][nextNode.c] = true;
            dfs(nextNode, endNode, board, visited, nextPrice, nextDirection);
            visited[nextNode.r][nextNode.c] = false;
        }
    }

    private static class Node {
        public int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
