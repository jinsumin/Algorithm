package group_word_checker_1316;

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
        String[] words = new String[n];
        for (int i = 0; i < n; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            words[i] = stringTokenizer.nextToken();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(words));
    }
}

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        for (String word : words) {
            if (isGroupWord(word)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isGroupWord(String word) {
        boolean[] visited = new boolean[200];
        for (int i = 1; i < word.length(); i ++) {
            if (visited[word.charAt(i)]) {
                return false;
            }
            if (word.charAt(i) != word.charAt(i - 1)) {
                visited[word.charAt(i - 1)] = true;
            }
        }
        return true;
    }
}
