package red_greed_pill_10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] picture = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            for (int j = 0; j < n; j++) {
                picture[i][j] = str.charAt(j);
            }
        }
        Solution solution = new Solution();
        solution.solution(picture, n);
    }
}

class Solution {
    private static final int[] MOVE_R = {0, 1, 0, -1};
    private static final int[] MOVE_C = {1, 0, -1, 0};

    private int countZone;
    private boolean[][] visited;

    public class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void solution(char[][] picture, int n) {
        visited = new boolean[n][n];
        //bfs(picture);
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(!visited[i][j]) {
                    Node startNode = new Node(i, j);
                    dfs(picture, startNode);
                    countZone ++;
                }
            }
        }
        System.out.print(countZone);
        redGreenPillInit(picture, n);
        //bfs(picture);
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(!visited[i][j]) {
                    Node startNode = new Node(i, j);
                    dfs(picture, startNode);
                    countZone ++;
                }
            }
        }
        System.out.println(" " + countZone);
    }

    private void dfs(char[][] picture, Node startNode) {
        for(int i = 0; i < 4; i ++) {
            Node nextNode = new Node(startNode.r + MOVE_R[i], startNode.c + MOVE_C[i]);
            if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= picture.length || nextNode.c >= picture[0].length) {
                continue;
            }
            if (visited[nextNode.r][nextNode.c]) {
                continue;
            }
            if (picture[nextNode.r][nextNode.c] != picture[startNode.r][startNode.c]) {
                continue;
            }
            visited[nextNode.r][nextNode.c] = true;
            dfs(picture, nextNode);
        }
    }

    private void redGreenPillInit(char[][] picture, int n) {
        visited = new boolean[n][n];
        countZone = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(picture[i][j] == 'R') {
                    picture[i][j] = 'G';
                }
            }
        }
    }

    private void bfs(char[][] picture) {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture.length; j++) {
                if (!visited[i][j]) {
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    countZone++;
                }
                while (!queue.isEmpty()) {
                    Node currentNode = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        Node nextNode = new Node(currentNode.r + MOVE_R[k], currentNode.c + MOVE_C[k]);
                        if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= picture.length || nextNode.c >= picture[0].length) {
                            continue;
                        }
                        if (visited[nextNode.r][nextNode.c]) {
                            continue;
                        }
                        if (picture[nextNode.r][nextNode.c] != picture[currentNode.r][currentNode.c]) {
                            continue;
                        }
                        queue.offer(nextNode);
                        visited[nextNode.r][nextNode.c] = true;
                    }
                }
            }
        }
    }

}
