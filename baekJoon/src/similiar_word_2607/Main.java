package similiar_word_2607;

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
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String word = stringTokenizer.nextToken();
        String[] compareWords = new String[n - 1];
        for (int i = 0; i < n - 1; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            compareWords[i] = stringTokenizer.nextToken();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(word, compareWords));
    }
}

class Solution {
    private static final int[] alphabets = new int[200];

    public int solution(String word, String[] compareWords) {
        int answer = 0;
        for (int i = 0; i < word.length(); i ++) {
            alphabets[word.charAt(i)]++;
        }
        for (int i = 0; i < compareWords.length; i ++) {
            int[] copiedAlphabets = new int[200];
            System.arraycopy(alphabets, 0, copiedAlphabets, 0, 200);
            for (int j = 0; j < compareWords[i].length(); j ++) {
                copiedAlphabets[compareWords[i].charAt(j)] --;
            }
            int countPlus1 = 0;
            int countMinus1 = 0;
            for (int j = 0; j < 200; j ++) {
                if (copiedAlphabets[j] < 0) {
                    countMinus1 += copiedAlphabets[j];
                } else if (copiedAlphabets[j] > 0) {
                    countPlus1 += copiedAlphabets[j];
                }
            }
            if (countPlus1 <= 1 && countMinus1 >= -1) {
                answer++;
            }
        }
        return answer;
    }
}
