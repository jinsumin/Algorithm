package eratosthenes_sieve_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-09-16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(N, K));
    }
}

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int count = 0;
        boolean[] erased = new boolean[n + 1];
        while (!isAllErased(erased)) {
            int p = getMinValue(erased);
            for (int i = 1; i * p < n + 1; i ++) {
                if (!erased[i * p]) {
                    erased[i * p] = true;
                    count++;
                    if (count == k) {
                        answer = i * p;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    private int getMinValue(boolean[] erased) {
        for (int i = 2; i < erased.length; i ++) {
            if (!erased[i]) {
                return i;
            }
        }
        return -1;
    }

    private boolean isAllErased(boolean[] erased) {
        for (int i = 2; i < erased.length; i ++) {
            if (!erased[i]) {
                return false;
            }
        }
        return true;
    }
}


