package teaching_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-08-04.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());   // 3 6
        int N = Integer.parseInt(stringTokenizer.nextToken());  // str[0] = 3
        int K = Integer.parseInt(stringTokenizer.nextToken());  // str[1] = 6
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = bufferedReader.readLine();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(N, K, words));
    }
}

class Solution {
    private static int answer = 0;
    private static final char[] LEARNED_LETTERS = {'a', 'c', 'i', 'n', 't'};

    public int solution(int n, int k, String[] words) {
        if (k < 5) {
            return 0;
        }
        char[] letters = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};
        int numberOfCanLearnLetters = k - 5;
        boolean[] learned = new boolean[letters.length];
        combination(words, letters, learned, 0, letters.length, numberOfCanLearnLetters);
        return answer;
    }

    private void combination(String[] words, char[] letters, boolean[] learned, int start, int n, int r) {
        ArrayList<Character> arrayList = new ArrayList<>();
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (learned[i]) {
                    arrayList.add(letters[i]);
                }
            }
            int max = 0;
            for (String word : words) {
                if (isPossibleToReadWordWith(arrayList, word)) {
                    max++;
                }
            }
            if (max > answer) {
                answer = max;
            }
        }

        for (int i = start; i < n; i++) {
            learned[i] = true;
            combination(words, letters, learned, i + 1, n, r - 1);
            learned[i] = false;
        }
    }

    private boolean isPossibleToReadWordWith(ArrayList<Character> arrayList, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (isContainOfLearnedLetters(word.charAt(i))) {
                continue;
            }
            if (arrayList.contains(word.charAt(i))) {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean isContainOfLearnedLetters(char letter) {
        for (char learnedLetter : LEARNED_LETTERS) {
            if (learnedLetter == letter) {
                return true;
            }
        }
        return false;
    }
}
