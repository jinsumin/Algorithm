package room_number_1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-04.
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
    private static final int[] memo = new int[10];

    public int solution(int number) {
        int answer = 1;
        while (number > 0) {
            memo[number % 10]++;
            number /= 10;
        }
        int temp = (memo[6] + memo[9] + 1) / 2;
        memo[6] = temp;
        memo[9] = temp;
        for (int i = 0; i <= 9; i ++) {
            if (answer < memo[i]) {
                answer = memo[i];
            }
        }
        return answer;
    }
}
