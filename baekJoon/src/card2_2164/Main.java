package card2_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-23.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            linkedList.add(i);
        }
        while (!linkedList.isEmpty()) {
            linkedList.pollFirst();
            if (linkedList.isEmpty()) {
                answer = linkedList.pollFirst();
                linkedList.offerLast(answer);
            }
        }
        return answer;
    }
}
