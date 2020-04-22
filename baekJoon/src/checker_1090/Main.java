package checker_1090;

import java.io.*;
import java.util.*;

/**
 * Created by Crab on 2020-04-21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<Node> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            arrayList.add(new Node(r, c));
        }
        Solution solution = new Solution();
        solution.solution(arrayList, n);
    }
}

class Node {
    int r, c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {

    private static class Checker {
        private int r, c;

        public Checker(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public ArrayList<Integer> distances = new ArrayList<>();
    }

    public void solution(ArrayList<Node> arrayList, int n) throws IOException {
        int maxX = 0, maxY = 0;
        for (Node value : arrayList) {
            if (value.r > maxX) {
                maxX = value.r;
            }
            if (value.c > maxY) {
                maxY = value.c;
            }
        }
        Checker[] checkers = new Checker[maxX * maxY];
        int index = 0;
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 1; i <= maxX; i++) {
            for (int j = 1; j <= maxY; j++) {
                checkers[index] = new Checker(i, j);
                for (Node node : arrayList) {
                    checkers[index].distances.add(getDistance(node, new Node(i, j)));
                }
                index++;
            }
        }
        for (int t = 1; t <= n; t++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < index; i++) {
                Arrays.sort(new ArrayList[]{checkers[i].distances});
                int temp = 0;
                for (int j = 0; j < t; j++) {
                    temp += checkers[i].distances.get(j);
                }
                if (temp < min) {
                    min = temp;
                }
            }
            answerList.add(min);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer integer : answerList) {
            bufferedWriter.write(integer + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private int getDistance(Node node1, Node node2) {
        return Math.abs(node1.r - node2.r) + Math.abs(node1.c - node2.c);
    }
}
