package level3.path_finding_game;

import java.util.*;

/**
 * Created by Crab on 2020-07-02.
 */
public class Main {
    public static void main(String[] args) {
        int[][] nodeInfo = {
                {5, 3}, {11, 5,}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
        };
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(nodeInfo)));
    }
}

class Solution {
    public int[][] solution(int[][] nodeInfo) {
        int[][] answer = {};
        Pos[] poses = new Pos[nodeInfo.length];
        for (int i = 0; i < nodeInfo.length; i ++) {
            poses[i] = new Pos(nodeInfo[i][0], nodeInfo[i][1], i + 1);
        }
        ArrayList<Pos> posArrayList = new ArrayList<>();
        Collections.addAll(posArrayList, poses);
        Collections.sort(posArrayList, new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                if (o1.y > o2.y) {
                    return 1;
                } else {
                    if (o1.x > o2.x) {
                        return 1;
                    }
                    return -1;
                }
            }
        });
        Queue<Integer> preOrderQueue = new LinkedList<>();
        Queue<Integer> postOrderQueue = new LinkedList<>();
        Tree preOrderTree = new Tree(preOrderQueue);
        Tree postOrderTree = new Tree(postOrderQueue);

        return answer;
    }
}

class Pos {
    int x, y;
    int index;

    public Pos(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class Node {
    int data;
    Node left, right;
}

class Tree {
    public Node root;
    public Queue<Integer> queue;

    public Tree(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public Node createNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    public void preOrder(Node node) {
        if (node != null) {
            queue.offer(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            queue.offer(node.data);
        }
    }
}
