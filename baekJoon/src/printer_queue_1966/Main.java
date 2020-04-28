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
        List<Documents> list = new LinkedList<>();
        Queue<Documents> queue = new LinkedList<>();
        Queue<Documents> queue2 = new LinkedList<>();
        for (int i = 0; i < documents.length; i++) {
            Documents document = new Documents(i + 1, documents[i]);
            list.add(document);
            queue.offer(document);
        }
        list.sort(new Comparator<Documents>() {
            @Override
            public int compare(Documents o1, Documents o2) {
                if (o1.importance < o2.importance) {
                    return 1;
                } else if (o1.importance == o2.importance) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < documents.length; i++) {
            queue2.offer(list.get(i));
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            assert queue.peek() != null;
            assert queue2.peek() != null;
            if (queue2.peek().importance == queue.peek().importance) {
                answer++;
                if (queue.peek().number == m + 1) {
                    break;
                }
                queue.poll();
                queue2.poll();
            } else {
                Documents temp = queue.poll();
                queue.offer(temp);
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
