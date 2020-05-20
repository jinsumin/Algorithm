package operator_insertion_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] A = new int[N];
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] numberOfOperators = new int[4];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            numberOfOperators[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        solution.solution(A, numberOfOperators);
    }
}

class Solution {
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public void solution(int[] A, int[] numberOfOperators) {
        solve(A, numberOfOperators, 1, A[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public void solve(int[] A, int[] numberOfOperators, int index, int result) {
        for (int i = 0; i < 4; i++) {
            if (numberOfOperators[i] != 0) {
                numberOfOperators[i]--;
                switch (i) {
                    case 0:    // '+'
                        solve(A, numberOfOperators, index + 1, result + A[index]);
                        break;
                    case 1:    // '-'
                        solve(A, numberOfOperators, index + 1, result - A[index]);
                        break;
                    case 2:    // 'X'
                        solve(A, numberOfOperators, index + 1, result * A[index]);
                        break;
                    case 3:    // '/'
                        solve(A, numberOfOperators, index + 1, result / A[index]);
                        break;
                }
                numberOfOperators[i]++;
            }
        }
        if (index == A.length) {
            if (result > max) {
                max = result;
            }
            if (result < min) {
                min = result;
            }
        }
    }
}
