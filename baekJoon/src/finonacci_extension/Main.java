package finonacci_extension;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-21.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static long[] positiveMemo;
    private static long[] negativeMemo;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 0) {
            System.out.println(0);
            System.out.println(0);
        }
        else if(n > 0) {
            posFibonacci(n);
            System.out.println(isPositive(positiveMemo[n]));
            System.out.println(positiveMemo[n]);
        } else {
            n = Math.abs(n);
            negFibonacci(n);
            System.out.println(isPositive(negativeMemo[n]));
            System.out.println(Math.abs(negativeMemo[n]));
        }
    }

    private void posFibonacci(int n) {
        positiveMemo = new long[n + 1];
        Arrays.fill(positiveMemo, 0);
        positiveMemo[1] = 1;
        for(int i = 2; i <= n; i ++) {
            positiveMemo[i] = (positiveMemo[i - 1] + positiveMemo[i - 2]) % 1000000000;
        }
    }

    private void negFibonacci(int n) {
        negativeMemo = new long[n + 1];
        Arrays.fill(negativeMemo, 0);
        negativeMemo[1] = 1;
        for(int i = 2; i <= n; i ++) {
            negativeMemo[i] = (negativeMemo[i - 2] - negativeMemo[i - 1]) % 1000000000;
        }
    }

    private int isPositive(long l) {
        if(l > 0) {
            return 1;
        }else {
            return -1;
        }
    }
}
