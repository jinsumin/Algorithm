package goldbachs_conjecture_6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-16.
 */
public class Main {
    private static final int MAX = 1000000;
    private static int[] memo = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int testCase = 100000;
        setEratosthenes();
        for (int t = 1; t <= testCase; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int number = Integer.parseInt(stringTokenizer.nextToken());
            if (number == 0) {
                return;
            }
            Solution solution = new Solution();
            solution.solution(number, memo);
        }
    }

    public static void setEratosthenes() {
        for (int i = 2; i <= MAX; i++) {
            memo[i] = i;
        }
        for (int i = 2; i <= MAX; i++) {
            if (memo[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j <= MAX; j += i) {
                memo[j] = 0;
            }
        }
    }
}

class Solution {
    public void solution(int number, int[] memo) {
        for (int i = number - 3; i > 2; i--) {
            if (memo[i] != 0 && memo[number - i] != 0) {
                System.out.println(number + " = " + (number - i) + " + " + i);
                return;
            }
        }
    }
}
