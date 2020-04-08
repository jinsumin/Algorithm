package complex_numbering_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-13.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int sizeOfMap = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[sizeOfMap][sizeOfMap];
        for (int i = 0; i < sizeOfMap; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            for (int j = 0; j < sizeOfMap; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        Solution solution = new Solution();
        solution.solution(map, sizeOfMap);
        solution.printNumberOfComplex();
        solution.printCountOfComplexes();
    }
}

class Solution {
    private static final int[] MOVE_R = {0, 1, 0, -1};
    private static final int[] MOVE_C = {1, 0, -1, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int number = 0;
    private List<Integer> list = new LinkedList<>();
    private int count = 0;

    public void solution(int[][] map, int sizeOfMap) {
        boolean[][] visited = new boolean[sizeOfMap][sizeOfMap];
        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                if (map[i][j] == 1) {
                    if (!visited[i][j]) {
                        number++;
                        Node currentNode = new Node(i, j);
                        visited[i][j] = true;
                        dfs(map, visited, sizeOfMap, currentNode);
                        list.add(count);
                        count = 0;
                    }
                }
            }
        }
        Collections.sort(list);
    }

    private void dfs(int[][] map, boolean[][] visited, int sizeOfMap, Node currentNode) {
        for (int i = 0; i < 4; i++) {
            Node nextNode = new Node(currentNode.r + MOVE_R[i], currentNode.c + MOVE_C[i]);
            if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r >= sizeOfMap || nextNode.c >= sizeOfMap) {
                continue;
            }
            if (map[nextNode.r][nextNode.c] == 0) {
                continue;
            }
            if (visited[nextNode.r][nextNode.c]) {
                continue;
            }
            visited[nextNode.r][nextNode.c] = true;
            dfs(map, visited, sizeOfMap, nextNode);
        }
        count ++;
    }

    public void printNumberOfComplex() {
        System.out.println(number);
    }

    public void printCountOfComplexes() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
