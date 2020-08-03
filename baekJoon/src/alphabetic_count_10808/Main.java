package alphabetic_count_10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Crab on 2020-08-03.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Solution solution = new Solution();
        solution.solution(input);
    }
}

class Solution {
    public void solution(String input) {
        int[] alphabet = new int['z' - 'a' + 1];
        for (int i = 0; i < input.length(); i ++) {
            alphabet[input.charAt(i) - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int value : alphabet) {
            stringBuilder.append(value).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
