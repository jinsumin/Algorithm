package beer_walk_9205;

import java.util.Scanner;

/**
 * Created by REMI on 2020-02-21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            Node homeNode = new Node(scanner.nextInt(), scanner.nextInt());
            Node[] storeNodes = new Node[n];
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                storeNodes[i] = new Node(x, y);
            }
            Node festivalNode = new Node(scanner.nextInt(), scanner.nextInt());
            Solution solution = new Solution();
            solution.solution(storeNodes, homeNode, festivalNode);
        }
    }
}

class Solution {
    private boolean[] visited;
    private boolean flag;

    public void solution(Node[] storeNodes, Node homeNode, Node festivalNode) {
        visited = new boolean[storeNodes.length];
        flag = false;
        dfs(storeNodes, visited, homeNode, festivalNode);
        if(flag) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }

    private void dfs(Node[] storeNodes, boolean[] visited, Node homeNode, Node festivalNode) {
        if (distance(homeNode, festivalNode) <= 1000) {
            flag = true;
            return;
        }

        for (int i = 0; i < storeNodes.length; i++) {
            if (distance(homeNode, storeNodes[i]) <= 1000 && !visited[i]) {
                visited[i] = true;
                dfs(storeNodes, visited, homeNode, festivalNode);
            }
        }
    }

    private int distance(Node homeNode, Node festivalNode) {
        return Math.abs(homeNode.getX() - festivalNode.getX()) + Math.abs(homeNode.getY() - festivalNode.getY());
    }
}

class Node {
    private int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
