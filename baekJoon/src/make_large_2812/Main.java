package make_large_2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-01.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String number = stringTokenizer.nextToken();
        Solution solution = new Solution();
        System.out.println(solution.solution(N, K, number));
    }
}

class Solution {
    /* with combination
    private static int max = 0;

    public int solution(int n, int k, String number) {
        boolean[] visited = new boolean[n];
        combination(number, visited, 0, n, n - k);
        return max;
    }

    private void combination(String number, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            String temp = "0";
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    temp += number.charAt(i);
                }
            }
            if (max < Integer.parseInt(temp)) {
                max = Integer.parseInt(temp);
            }
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(number, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
     */

    public String solution(int n, int k, String number) {
        StringBuilder stringBuilder = new StringBuilder(number);
        int index = 0;
        while (k >= 0) {
            if (index > n - 2) {
                break;
            }
            char first = stringBuilder.charAt(index);
            char second = stringBuilder.charAt(index + 1);
            if ((int)second > (int)first) {
                stringBuilder.replace(index, index + 1, "X");
                k--;
                //System.out.println(arrayList);
            } else {
                index++;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            if (stringBuilder.charAt(i) != 'X') {
                answer.append(number.charAt(i));
            }
        }
        return answer.toString();
    }
}
