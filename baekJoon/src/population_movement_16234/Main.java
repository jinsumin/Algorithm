package population_movement_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, L, R));
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

    private boolean flag = false;
    private boolean[][] visited;
    private int[][] union;
    private int sum = 0;
    private int numberOfNations = 0;
    private ArrayList<Node> arrayList = new ArrayList<>();

    public int solution(int[][] map, int l, int r) {
        int count = 0;
        visited = new boolean[map.length][map[0].length];
        union = new int[map.length][map[0].length];
        while (true) {
            flag = false;
            for (int i = 0; i < map.length; i ++) {
                Arrays.fill(visited[i], false);
                Arrays.fill(union[i], 0);
            }
            int number = 1;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (!visited[i][j]) {
                        Node currentNode = new Node(i, j);
                        dfs(map, visited, union, currentNode, l, r, number);
                        if (flag) {
                            number++;
                            for (int s = 0; s < arrayList.size(); s ++) {
                                Node temp = arrayList.get(s);
                                map[temp.r][temp.c] = sum / numberOfNations;
                            }
                            sum = 0;
                            numberOfNations = 0;
                            arrayList.clear();
                        }
                    }
                }
            }
            if (number == 1) {
                break;
            }
            //movePopulation(map, union, number);
            count++;
        }
        return count;
    }

    private void dfs(int[][] map, boolean[][] visited, int[][] union, Node currentNode, int l, int r, int number) {
        for (int i = 0; i < 4; i++) {
            Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
            if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= map.length || nextNode.c >= map[0].length) {
                continue;
            }
            if (visited[nextNode.r][nextNode.c]) {
                continue;
            }
            if (Math.abs(map[currentNode.r][currentNode.c] - map[nextNode.r][nextNode.c]) < l
                    || Math.abs(map[currentNode.r][currentNode.c] - map[nextNode.r][nextNode.c]) > r) {
                continue;
            }
            visited[nextNode.r][nextNode.c] = true;
            union[nextNode.r][nextNode.c] = number;
            dfs(map, visited, union, nextNode, l, r, number);
            flag = true;
            sum += map[nextNode.r][nextNode.c];
            //System.out.println("number : " + number + " sum : " + sum);
            numberOfNations ++;
            arrayList.add(nextNode);
        }
    }

    private void movePopulation(int[][] map, int[][] union, int number) {
        while (number > 0) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (union[i][j] == number) {
                        sum += map[i][j];
                        count++;
                        System.out.println("number : " + number + " sum : " + sum);
                    }
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (union[i][j] == number) {
                        map[i][j] = sum / count;
                    }
                }
            }
            number--;
        }
    }
}
