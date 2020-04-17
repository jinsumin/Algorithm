package fibonacci_function_1003;

import java.util.Scanner;

/**
 * Created by Crab on 2020-04-14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            Solution solution = new Solution();
            solution.solution(n);
        }
    }
}

class Solution {
    public void solution(int n) {
        int[] memoZero = new int[41];
        int[] memoOne = new int[41];
        memoZero[0] = 1;
        memoOne[0] = 0;
        memoZero[1] = 0;
        memoOne[1] = 1;
        memoZero[2] = 1;
        memoOne[2] = 2;
        for (int i = 3; i <= n; i ++) {
            memoZero[i] = memoZero[i - 1] + memoZero[i - 2];
            memoOne[i] = memoOne[i - 2] + memoZero[i - 1];
            //System.out.println(memoZero[i] + " " + memoOne[i]);
        }
        System.out.println(memoZero[n] + " " + memoOne[n]);
    }
}
