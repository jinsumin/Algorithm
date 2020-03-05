package gary_manderling_17779;

import java.util.*;

/**
 * Created by REMI on 2020-02-05.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        solution.solution(map);
        System.out.println(solution.findMinDiff());
    }
}

class Solution {
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private List<Integer> listOfDiff = new LinkedList<>();

    public void solution(int[][] map) {
        Node[] basePoints = new Node[(map.length - 1) * (map[0].length - 2)];
        int index = 0;
        for (int i = 0; i < map.length - 2; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                basePoints[index++] = new Node(i, j);
            }
        }
        for (int i = 0; i < basePoints.length; i++) {
            for (int d1 = 1; d1 < basePoints[i].c; d1++) {
                for (int d2 = 1; d2 < map[0].length - basePoints[i].c; d2++) {
                    Node upNode = new Node(basePoints[i].r, basePoints[i].c);
                    Node leftNode = new Node(basePoints[i].r + d1, basePoints[i].c - d1);
                    Node rightNode = new Node(basePoints[i].r + d2, basePoints[i].c + d2);
                    Node downNode = new Node(leftNode.r + d2, rightNode.c - d1);
                    List<Integer> listOfArea = new LinkedList<>();
                    int sumOfArea1 = calculateArea1(map, upNode, leftNode);
                    listOfArea.add(sumOfArea1);
                    int sumOfArea2 = calculateArea2(map, upNode, rightNode);
                    listOfArea.add(sumOfArea2);
                    int sumOfArea3 = calculateArea3(map, leftNode, downNode);
                    listOfArea.add(sumOfArea3);
                    int sumOfArea4 = calculateArea4(map, rightNode, downNode);
                    listOfArea.add(sumOfArea4);
                    int sumOfArea5 = totalSum(map) - (sumOfArea1 + sumOfArea2 + sumOfArea3 + sumOfArea4);
                    listOfArea.add(sumOfArea5);
                    listOfDiff.add(findMax(listOfArea) - findMin(listOfArea));
                }
            }
        }
    }

    private int calculateArea1(int[][] map, Node upNode, Node leftNode) {
        int sum = 0;
        int remain = 0;
        for (int i = 0; i < leftNode.r; i++) {
            for (int j = 0; j <= upNode.c; j++) {
                sum += map[i][j];
            }
        }
        int temp = 0;
        for (int i = upNode.r; i < leftNode.r; i++) {
            for (int j = leftNode.c + 1; j <= upNode.c - temp; j++) {
                remain += map[i][j];
                temp++;
            }
        }
        return sum - remain;
    }

    private int calculateArea2(int[][] map, Node upNode, Node rightNode) {
        int sum = 0;
        int remain = 0;
        for (int i = 0; i <= rightNode.r; i++) {
            for (int j = upNode.c + 1; j < map[0].length; j++) {
                sum += map[i][j];
            }
        }
        int temp = 0;
        for (int i = upNode.r + 1; i <= rightNode.r; i++) {
            for (int j = upNode.c + 1; j <= rightNode.c - temp; j++) {
                remain += map[i][j];
                temp++;
            }
        }
        return sum - remain;
    }

    private int calculateArea3(int[][] map, Node leftNode, Node downNode) {
        int sum = 0;
        int remain = 0;
        for (int i = leftNode.r; i < map.length; i++) {
            for (int j = 0; j < downNode.c; j++) {
                sum += map[i][j];
            }
        }
        int temp = 0;
        for (int i = leftNode.r; i < downNode.r; i++) {
            for (int j = leftNode.c; j < downNode.c - temp; j++) {
                remain += map[i][j];
                temp++;
            }
        }
        return sum - remain;
    }

    private int calculateArea4(int[][] map, Node rightNode, Node downNode) {
        int sum = 0;
        int remain = 0;
        for (int i = rightNode.r + 1; i < map.length; i++) {
            for (int j = downNode.c; j < map[0].length; j++) {
                sum += map[i][j];
            }
        }
        int temp = 0;
        for (int i = rightNode.r + 1; i < downNode.r; i++) {
            for (int j = downNode.c; j < rightNode.c - temp; j++) {
                remain += map[i][j];
                temp++;
            }
        }
        return sum - remain;
    }

    private int totalSum(int[][] map) {
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private int findMax(List<Integer> listOfArea) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < listOfArea.size(); i++) {
            int temp = listOfArea.get(i);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    private int findMin(List<Integer> listOfArea) {
        int min = MAX_VALUE;
        for (int i = 0; i < listOfArea.size(); i++) {
            int temp = listOfArea.get(i);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public int findMinDiff() {
        int min = MAX_VALUE;
        for (int i = 0; i < listOfDiff.size(); i++) {
            int temp = listOfDiff.get(i);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}
