package why_KMP_2902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-13.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] names = input.split("-");
        Solution solution = new Solution();
        System.out.println(solution.solution(names));
    }
}

class Solution {
    public String solution(String[] names) {
        StringBuilder answer = new StringBuilder();
        for (String name : names) {
            answer.append(name.charAt(0));
        }
        return answer.toString();
    }
}
