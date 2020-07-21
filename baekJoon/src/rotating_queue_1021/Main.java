package rotating_queue_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-07-21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            linkedList1.add(i + 1);
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            linkedList2.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(linkedList1, linkedList2));
    }
}

class Solution {
    public int solution(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        int answer = 0;
        while (!linkedList2.isEmpty()) {
            if (linkedList1.getFirst().equals(linkedList2.getFirst())) {
                linkedList1.pollFirst();
                linkedList2.pollFirst();
            } else {
                int distance1 = 0;
                int distance2 = 0;
                int target = linkedList2.getFirst();
                int size = linkedList1.size();
                for (int i = 0; i < size; i++) {
                    if (target == linkedList1.get(i)) {
                        break;
                    }
                    distance1++;
                }
                for (int i = size - 1; i >= 0; i--) {
                    distance2++;
                    if (target == linkedList1.get(i)) {
                        break;
                    }
                }
                if (distance1 < distance2) {
                    for (int i = 0; i < distance1; i++) {
                        int temp = linkedList1.pollFirst();
                        linkedList1.offerLast(temp);
                    }
                    answer += distance1;
                } else {
                    for (int i = 0; i < distance2; i++) {
                        int temp = linkedList1.pollLast();
                        linkedList1.offerFirst(temp);
                    }
                    answer += distance2;
                }
            }
        }
        return answer;
    }
}
