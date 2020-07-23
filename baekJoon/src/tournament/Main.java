package tournament;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-07-23.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(N, A, B));
    }
}

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        Queue[] queues =new Queue[2];
        queues[0] = new LinkedList<Integer>();
        queues[1] = new LinkedList<Integer>();
        for (int i = 1; i <= n; i ++) {
            queues[0].offer(i);
        }
        int toggle = 0;
        while (true) {
            while (!queues[toggle].isEmpty()) {
                int left = 0;
                int right = 0;
                left = (int) queues[toggle].poll();
                if (!queues[toggle].isEmpty()) {
                    right = (int) queues[toggle].poll();
                }
                if (left == a && right == b) {
                    return answer;
                } else if (left == b && right == a) {
                    return answer;
                } else if (left == a || left == b) {
                    queues[(toggle + 1) % 2].offer(left);
                } else if (right == a || right == b) {
                    queues[(toggle + 1) % 2].offer(right);
                } else {
                    queues[(toggle + 1) % 2].offer(left);
                }
            }
            answer ++;
            toggle = (toggle + 1) % 2;
        }
    }
}
