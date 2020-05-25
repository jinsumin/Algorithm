package octal_binary_1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Crab on 2020-05-25.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long octalNumber = Long.parseLong(bufferedReader.readLine());
        Solution solution = new Solution();
        System.out.println(solution.solution(octalNumber));
    }
}

class Solution {
    public long solution(long octalNumber) {
        String answer;
        long decimalNumber = 0;
        int index = 0;
        while (octalNumber > 0) {
            long temp = octalNumber % 10;
            decimalNumber += temp * Math.pow(8, index);
            octalNumber /= 10;
            index++;
        }
        answer = Long.toBinaryString(decimalNumber);
        return Integer.parseInt(answer);
    }
}
