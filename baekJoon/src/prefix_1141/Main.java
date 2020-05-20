package prefix_1141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Crab on 2020-05-18.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i ++) {
            words[i] = bufferedReader.readLine();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(words));
    }
}

class Solution {
    public int solution(String[] words) {
        ArrayList<String> wordsList = new ArrayList<>();
        for (String word : words) {
            if (wordsList.isEmpty()) {
                wordsList.add(word);
                continue;
            }
            for (int j = 0; j < wordsList.size(); j++) {
                if (word.startsWith(wordsList.get(j))) {
                    wordsList.remove(wordsList.get(j));
                    wordsList.add(word);
                    break;
                } else if (wordsList.get(j).startsWith(word)) {
                    break;
                }
                if (j == wordsList.size() - 1) {
                    if (word.startsWith(wordsList.get(j))) {
                        wordsList.remove(wordsList.get(j));
                        wordsList.add(word);
                        break;
                    } else if (!wordsList.get(j).startsWith(word)) {
                        wordsList.add(word);
                        break;
                    }
                }
            }
        }
        // System.out.println(wordsList);
        return wordsList.size();
    }
}
