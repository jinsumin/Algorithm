package number_of_words_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Crab on 2020-04-28.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public int solution(String input) {
        if (input.equals(" ")) {
            return 0;
        }
        input = input.trim();
        String[] words = input.split(" ");
        return words.length;
    }
}
