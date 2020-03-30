package treasure_island_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-03-30.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        char[][] map = new char[row][col];
        for (int r = 0; r < row; r++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            for (int c = 0; c < col; c++) {
                map[r][c] = str.charAt(c);
            }
        }
//        for (int r = 0; r < row; r ++) {
//            for (int c = 0; c < col; c ++) {
//                System.out.print(map[r][c] + " ");
//            }
//            System.out.println();
//        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private static final int[] MOVE_R = {1, 0, -1, 0};
    private static final int[] MOVE_C = {0, 1, 0, -1};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(char[][] map) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == 'W') {
                    continue;
                }
                boolean[][] visited = new boolean[map.length][map[0].length];
                arrayList.add(bfs(map, visited, new Node(r, c)));
            }
        }
        arrayList.sort(Comparator.reverseOrder());
        return arrayList.get(0);
    }

    private int bfs(char[][] map, boolean[][] visited, Node startNode) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode.r][startNode.c] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s ++) {
                Node currentNode = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
                    if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map[0].length) {
                        continue;
                    }
                    if (map[nextNode.r][nextNode.c] == 'W') {
                        continue;
                    }
                    if (visited[nextNode.r][nextNode.c]) {
                        continue;
                    }
                    visited[nextNode.r][nextNode.c] = true;
                    queue.offer(nextNode);
                }
            }
            answer ++;
        }
        return answer - 1;
    }
}
