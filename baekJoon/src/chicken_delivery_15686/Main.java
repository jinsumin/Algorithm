package chicken_delivery_15686;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by REMI on 2020-03-01.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, n, m));
    }
}

class Solution {
    private static final int HOME = 1;
    private static final int CHICKEN_HOUSE = 2;

    private List<Node> listOfChickenHouse;
    private List<Node> listOfHome;
    private List<Integer> memo;

    public static class Node {
        int r, c;
        boolean selected;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] map, int n, int m) {
        listOfChickenHouse = new LinkedList<>();
        listOfHome = new LinkedList<>();
        memo = new LinkedList<>();
        findHomeAndChickenHouse(map, n);
        selectChickenHouse(map, n, 0, m);
        return findMinChickenDistance();
    }

    private void findHomeAndChickenHouse(int[][] map, int n) {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(map[i][j] == HOME) {
                    listOfHome.add(new Node(i, j));
                }
                if(map[i][j] == CHICKEN_HOUSE) {
                    listOfChickenHouse.add(new Node(i, j));
                }
            }
        }
    }

    private int findMinChickenDistance() {
        int min = Integer.MAX_VALUE;
        for (Integer integer : memo) {
            if (integer == 0) {
                continue;
            }
            if (min > integer) {
                min = integer;
            }
        }
        return min;
    }

    private int chickenDistance(Node a, Node b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }

    private void selectChickenHouse(int[][] map, int n, int start, int r) {
        if(r == 0) {
            calculateMinChickenDistance(map, n);
        } else {
            for(int i = start; i < listOfChickenHouse.size(); i ++) {
                listOfChickenHouse.get(i).selected = true;
                selectChickenHouse(map, n, i + 1, r - 1);
                listOfChickenHouse.get(i).selected = false;
            }
        }
    }

    private void calculateMinChickenDistance(int[][] map, int n) {
        int result = 0;
        for (Node homeNode : listOfHome) {
            int min = Integer.MAX_VALUE;
            for (Node chickenNode : listOfChickenHouse) {
                if (chickenNode.selected) {
                    int newMin = chickenDistance(homeNode, chickenNode);
                    if (min > newMin) {
                        min = newMin;
                    }
                }
            }
            result += min;
        }
        memo.add(result);
    }
}
