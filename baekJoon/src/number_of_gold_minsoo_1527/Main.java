package number_of_gold_minsoo_1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-24.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(A, B));
    }
}

class Solution {
    public int solution(long a, long b) {
        int answer = 0;
        for (long number = a; number <= b; number ++) {
            if (isGoldMinSoo(number)) {
                answer ++;
            }
        }
        return answer;
    }

    private boolean isGoldMinSoo(long number) {
        String temp = Long.toString(number);
        for (int i = 0; i < temp.length(); i ++) {
            if (temp.charAt(i) != '4' && temp.charAt(i) != '7') {
                return false;
            }
        }
        return true;
    }
}
