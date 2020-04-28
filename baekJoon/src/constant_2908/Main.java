package constant_2908;

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
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String A = stringTokenizer.nextToken();
        String B = stringTokenizer.nextToken();
        Solution solution = new Solution();
        System.out.println(solution.solution(A, B));
    }
}

class Solution {
    public int solution(String a, String b) {
        StringBuilder answerA = new StringBuilder();
        StringBuilder answerB = new StringBuilder();
        for (int i = 2; i >= 0; i --) {
            answerA.append(a.charAt(i));
            answerB.append(b.charAt(i));
        }
        return Math.max((Integer.parseInt(String.valueOf(answerA))), (Integer.parseInt(String.valueOf(answerB))));
    }
}
