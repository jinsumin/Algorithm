package surveillance_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-22.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private static final int[] MOVE_R = {0, 0, 1, -1};
    private static final int[] MOVE_C = {1, -1, 0, 0};
    private static final int EMPTY = 0;
    private static final int CCTV_1 = 1;
    private static final int CCTV_2 = 2;
    private static final int CCTV_3 = 3;
    private static final int CCTV_4 = 4;
    private static final int CCTV_5 = 5;
    private static final int WALL = 6;

    public static class Node {
        private int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static class CCTV_1 {
        private final Node node;

        public CCTV_1(Node node) {
            this.node = new Node(node.r, node.c);
        }

        public int countCheck(int[][] map, boolean[][] visited, int direction) {
            int count = 0;
            int coefficient = 1;
            Node nextNode = new Node(node.r + MOVE_R[direction] * coefficient, node.c + MOVE_C[direction] * coefficient);
            while (map[nextNode.r][nextNode.c] != EMPTY) {
                if (!visited[nextNode.r][nextNode.c]) {
                    count++;
                    visited[nextNode.r][nextNode.c] = true;
                }
                coefficient++;
                nextNode = new Node(node.r + MOVE_R[direction] * coefficient, node.c + MOVE_C[direction] * coefficient);
            }
            return count;
        }
    }

    public static class CCTV_2 {
        private final Node node;

        public CCTV_2(Node node) {
            this.node = new Node(node.r, node.c);
        }

        public int countCheck(int[][] map, boolean[][] visited, int direction) {
            int count = 0;
            int coefficient1 = 1;
            int coefficient2 = 1;
            Node nextNode1 = new Node(node.r + MOVE_R[(direction) % 4] * coefficient1, node.c + MOVE_C[(direction) % 4] * coefficient1);
            Node nextNode2 = new Node(node.r + MOVE_R[(direction + 1) % 4] * coefficient2, node.c + MOVE_C[(direction + 1) % 4] * coefficient2);
            while (map[nextNode1.r][nextNode1.c] != EMPTY) {
                if (!visited[nextNode1.r][nextNode1.c]) {
                    count++;
                    visited[nextNode1.r][nextNode1.c] = true;
                }
                coefficient1++;
                nextNode1 = new Node(node.r + MOVE_R[(direction) % 4] * coefficient1, node.c + MOVE_C[(direction) % 4] * coefficient1);
            }
            while (map[nextNode2.r][nextNode2.c] != EMPTY) {
                if (!visited[nextNode2.r][nextNode2.c]) {
                    count++;
                    visited[nextNode2.r][nextNode2.c] = true;
                }
                coefficient2++;
                nextNode2 = new Node(node.r + MOVE_R[(direction + 1) % 4] * coefficient2, node.c + MOVE_C[(direction + 1) % 4] * coefficient2);
            }
            return count;
        }
    }

    public static class CCTV_3 {
        private final Node node;

        public CCTV_3(Node node) {
            this.node = new Node(node.r, node.c);
        }

        public int countCheck(int[][] map, boolean[][] visited, int direction) {
            int count = 0;
            int coefficient1 = 1;
            int coefficient2 = 1;
            Node nextNode1 = new Node(node.r + MOVE_R[(direction) % 4] * coefficient1, node.c + MOVE_C[(direction) % 4] * coefficient1);
            Node nextNode2 = new Node(node.r + MOVE_R[(direction + 2) % 4] * coefficient2, node.c + MOVE_C[(direction + 2) % 4] * coefficient2);
            while (map[nextNode1.r][nextNode1.c] != EMPTY) {
                if (!visited[nextNode1.r][nextNode1.c]) {
                    count++;
                    visited[nextNode1.r][nextNode1.c] = true;
                }
                coefficient1++;
                nextNode1 = new Node(node.r + MOVE_R[(direction) % 4] * coefficient1, node.c + MOVE_C[(direction) % 4] * coefficient1);
            }
            while (map[nextNode2.r][nextNode2.c] != EMPTY) {
                if (!visited[nextNode2.r][nextNode2.c]) {
                    count++;
                    visited[nextNode2.r][nextNode2.c] = true;
                }
                coefficient2++;
                nextNode2 = new Node(node.r + MOVE_R[(direction + 2) % 4] * coefficient2, node.c + MOVE_C[(direction + 2) % 4] * coefficient2);
            }
            return count;
        }
    }

    public static class CCTV_4 {
        private final Node node;

        public CCTV_4(Node node) {
            this.node = new Node(node.r, node.c);
        }

        public int countCheck(int[][] map, boolean[][] visited, int direction) {
            int count = 0;
            int coefficient1 = 1;
            int coefficient2 = 1;
            int coefficient3 = 1;
            Node nextNode1 = new Node(node.r + MOVE_R[(direction) % 4] * coefficient1, node.c + MOVE_C[(direction) % 4] * coefficient1);
            Node nextNode2 = new Node(node.r + MOVE_R[(direction + 1) % 4] * coefficient2, node.c + MOVE_C[(direction + 1) % 4] * coefficient2);
            Node nextNode3 = new Node(node.r + MOVE_R[(direction + 2) % 4] * coefficient3, node.c + MOVE_C[(direction + 2) % 4] * coefficient3);
            while (map[nextNode1.r][nextNode1.c] != EMPTY) {
                if (!visited[nextNode1.r][nextNode1.c]) {
                    count++;
                    visited[nextNode1.r][nextNode1.c] = true;
                }
                coefficient1++;
                nextNode1 = new Node(node.r + MOVE_R[(direction) % 4] * coefficient1, node.c + MOVE_C[(direction) % 4] * coefficient1);
            }
            while (map[nextNode2.r][nextNode2.c] != EMPTY) {
                if (!visited[nextNode2.r][nextNode2.c]) {
                    count++;
                    visited[nextNode2.r][nextNode2.c] = true;
                }
                coefficient2++;
                nextNode2 = new Node(node.r + MOVE_R[(direction + 1) % 4] * coefficient2, node.c + MOVE_C[(direction + 1) % 4] * coefficient2);
            }
            while (map[nextNode3.r][nextNode3.c] != EMPTY) {
                if (!visited[nextNode3.r][nextNode3.c]) {
                    count++;
                    visited[nextNode3.r][nextNode3.c] = true;
                }
                coefficient3++;
                nextNode3 = new Node(node.r + MOVE_R[(direction + 2) % 4] * coefficient3, node.c + MOVE_C[(direction + 2) % 4] * coefficient3);
            }
            return count;
        }
    }

    public static class CCTV_5 {
        private final Node node;

        public CCTV_5(Node node) {
            this.node = new Node(node.r, node.c);
        }

        public int countCheck(int[][] map, boolean[][] visited, int direction) {
            int count = 0;
            int coefficient1 = 1;
            int coefficient2 = 1;
            int coefficient3 = 1;
            int coefficient4 = 1;
            Node nextNode1 = new Node(node.r + MOVE_R[(direction) % 4] * coefficient1, node.c + MOVE_C[(direction) % 4] * coefficient1);
            Node nextNode2 = new Node(node.r + MOVE_R[(direction + 1) % 4] * coefficient2, node.c + MOVE_C[(direction + 1) % 4] * coefficient2);
            Node nextNode3 = new Node(node.r + MOVE_R[(direction + 2) % 4] * coefficient3, node.c + MOVE_C[(direction + 2) % 4] * coefficient3);
            Node nextNode4 = new Node(node.r + MOVE_R[(direction + 3) % 4] * coefficient4, node.c + MOVE_C[(direction + 3) % 4] * coefficient4);
            while (map[nextNode1.r][nextNode1.c] != EMPTY) {
                if (!visited[nextNode1.r][nextNode1.c]) {
                    count++;
                    visited[nextNode1.r][nextNode1.c] = true;
                }
                coefficient1++;
                nextNode1 = new Node(node.r + MOVE_R[(direction) % 4] * coefficient1, node.c + MOVE_C[(direction) % 4] * coefficient1);
            }
            while (map[nextNode2.r][nextNode2.c] != EMPTY) {
                if (!visited[nextNode2.r][nextNode2.c]) {
                    count++;
                    visited[nextNode2.r][nextNode2.c] = true;
                }
                coefficient2++;
                nextNode2 = new Node(node.r + MOVE_R[(direction + 1) % 4] * coefficient2, node.c + MOVE_C[(direction + 1) % 4] * coefficient2);
            }
            while (map[nextNode3.r][nextNode3.c] != EMPTY) {
                if (!visited[nextNode3.r][nextNode3.c]) {
                    count++;
                    visited[nextNode3.r][nextNode3.c] = true;
                }
                coefficient3++;
                nextNode3 = new Node(node.r + MOVE_R[(direction + 2) % 4] * coefficient3, node.c + MOVE_C[(direction + 2) % 4] * coefficient3);
            }
            while (map[nextNode4.r][nextNode4.c] != EMPTY) {
                if (!visited[nextNode4.r][nextNode4.c]) {
                    count++;
                    visited[nextNode4.r][nextNode4.c] = true;
                }
                coefficient4++;
                nextNode4 = new Node(node.r + MOVE_R[(direction + 3) % 4] * coefficient4, node.c + MOVE_C[(direction + 3) % 4] * coefficient4);
            }
            return count;
        }
    }

    private LinkedList<Node> linkedList = new LinkedList<>();

    public int solution(int[][] map) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //findCCTV(map);

        Collections.sort(arrayList);
        return arrayList.get(0);
    }
}
