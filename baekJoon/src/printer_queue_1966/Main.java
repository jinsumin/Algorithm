package printer_queue_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-04-23.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int testCase = Integer.parseInt(stringTokenizer.nextToken());
        for (int t = 1; t <= testCase; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int[] documents = new int[n];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                documents[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(documents, m));
        }
    }
}

class Solution {
    public int solution(int[] documents, int m) {
        int answer = 0;
        Queue<Documents> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < documents.length; i++) {
            Documents document = new Documents(i + 1, documents[i]);
            queue.offer(document);
            priorityQueue.offer(document.importance);
        }
        while(!queue.isEmpty()) {
            Documents tempDocuments = queue.poll();
            assert tempDocuments != null;
            if (priorityQueue.peek() == tempDocuments.importance) {
                priorityQueue.poll();
                answer++;
                if (tempDocuments.number == m + 1) {
                    break;
                }
            } else {
                queue.offer(tempDocuments);
            }
        }
        return answer;
    }

    private static class Documents {
        int number, importance;

        public Documents(int number, int importance) {
            this.number = number;
            this.importance = importance;
        }
    }
}
