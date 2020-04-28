package vertical_reading_10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-28.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        String[] strings = new String[5];
        for (int i = 0; i < 5; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            strings[i] = stringTokenizer.nextToken();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(strings));
    }
}

class Solution {
    public String solution(String[] strings) {
        StringBuilder answer = new StringBuilder();
        for (int length = 0; length < 15; length ++) {
            for (int i = 0; i < 5; i ++) {
                if (length < strings[i].length()) {
                    answer.append(strings[i].charAt(length));
                }
            }
        }
        return String.valueOf(answer);
    }
}
