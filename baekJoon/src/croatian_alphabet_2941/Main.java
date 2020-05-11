package croatian_alphabet_2941;

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
        String croatianWord = stringTokenizer.nextToken();
        Solution solution = new Solution();
        System.out.println(solution.solution(croatianWord));
    }
}

class Solution {
    private static final String[] croatianWords = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"
            , "v", "w", "x", "y", "z"
            , "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
    };

    public int solution(String input) {
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i + 2 < input.length()) {
                if (isCroatianWord(input, i, i + 3)) {
                    answer++;
                    i += 2;
                    continue;
                }
            }
            if (i + 1 < input.length()) {
                if (isCroatianWord(input, i, i + 2)) {
                    answer++;
                    i += 1;
                    continue;
                }
            }
            if (isCroatianWord(input, i, i + 1)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isCroatianWord(String input, int startIndex, int endIndex) {
        String temp = input.substring(startIndex, endIndex);
        for (String croatianWord : croatianWords) {
            if (temp.equals(croatianWord)) {
                //System.out.println("substring : " + temp);
                return true;
            }
        }
        return false;
    }
}
