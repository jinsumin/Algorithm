package make_bridge_2146;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

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

    private int land = 1;
    private boolean[][] visited;

    public int solution(int[][] map) {
        int min = Integer.MAX_VALUE;
        visited = new boolean[map.length][map[0].length];
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[0].length; j ++) {
                Node currentNode = new Node(i, j);
                if(visited[currentNode.r][currentNode.c]) {
                    continue;
                }
                if(map[currentNode.r][currentNode.c] == 0) {
                    continue;
                }
                dfsLand(map, currentNode);
                land ++;
            }
        }
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[0].length; j ++) {
                if(map[i][j] != 0) {
                    continue;
                }
                visited = new boolean[map.length][map[0].length];
                Node oceanNode = new Node(i, j);
                int temp = bfsOcean(map, oceanNode);
                if(min > temp) {
                    min = temp;
                }
            }
        }
        return min;
    }

    private void dfsLand(int[][] map, Node currentNode) {
        map[currentNode.r][currentNode.c] = land;
        visited[currentNode.r][currentNode.c] = true;
        for(int i = 0; i < 4; i ++) {
            Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
            if(nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map[0].length) {
                continue;
            }
            if(visited[nextNode.r][nextNode.c]) {
                continue;
            }
            if(map[nextNode.r][nextNode.c] == 0) {
                continue;
            }
            map[nextNode.r][nextNode.c] = land;
            visited[nextNode.r][nextNode.c] = true;
            dfsLand(map, nextNode);
        }
    }

    private int bfsOcean(int[][] map, Node oceanNode) {
        int lengthOfLand = 1;
        int depth = 0;
        int count = 0;
        int nameOfLand = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(oceanNode);
        visited[oceanNode.r][oceanNode.c] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0; s < size; s ++) {
                Node temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Node nextTemp = new Node(temp.r + MOVE_R[i], temp.c + MOVE_C[i]);
                    if (nextTemp.r < 0 || nextTemp.c < 0 || nextTemp.r >= map.length || nextTemp.c >= map[0].length) {
                        continue;
                    }
                    if (map[nextTemp.r][nextTemp.c] == nameOfLand || map[nextTemp.r][nextTemp.c] == 0) {
                        continue;
                    }
                    nameOfLand = map[nextTemp.r][nextTemp.c];
                    count++;
                    lengthOfLand += depth;
                }
                if (count == 2) {
                    return lengthOfLand;
                }
                for (int i = 0; i < 4; i++) {
                    Node nextOceanNode = new Node(temp.r + MOVE_R[i], temp.c + MOVE_C[i]);
                    if (nextOceanNode.r < 0 || nextOceanNode.c < 0 || nextOceanNode.r >= map.length || nextOceanNode.c >= map[0].length) {
                        continue;
                    }
                    if (visited[nextOceanNode.r][nextOceanNode.c]) {
                        continue;
                    }
                    if (map[nextOceanNode.r][nextOceanNode.c] != 0) {
                        continue;
                    }
                    visited[nextOceanNode.r][nextOceanNode.c] = true;
                    queue.offer(nextOceanNode);
                }
            }
            depth ++;
        }
        return Integer.MAX_VALUE;
    }
}
