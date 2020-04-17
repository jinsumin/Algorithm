package gcd_sum_9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int testCase = Integer.parseInt(stringTokenizer.nextToken());
        for (int t = 1; t <= testCase; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Solution solution = new Solution();
            System.out.println(solution.solution(array));
        }
    }
}

class Solution {
    private long sumOfGCD = 0;

    public long solution(int[] array) {
        boolean[] selected = new boolean[array.length];
        combination(array, selected, 0, array.length, 2);
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                int bigElement = Math.max(array[i], array[j]);
//                int smallElement = Math.min(array[i], array[j]);
//                sumOfGCD += gcd(bigElement, smallElement);
//            }
//        }
        return sumOfGCD;
    }

    private void combination(int[] array, boolean[] selected, int startIndex, int n, int r) {
        if (r == 0) {
            int leftElement = 1, rightElement = 1;
            for (int i = 0; i < n; i ++) {
                if (selected[i]) {
                    leftElement = array[i];
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i --) {
                if (selected[i]) {
                    rightElement = array[i];
                    break;
                }
            }
            int bigElement = Math.max(leftElement, rightElement);
            int smallElement = Math.min(leftElement, rightElement);
            sumOfGCD += gcd(bigElement, smallElement);
            return;
        }
        for (int i = startIndex; i < n; i ++) {
            selected[i] = true;
            combination(array, selected, i + 1, n, r - 1);
            selected[i] = false;
        }
    }

    private long gcd(int bigElement, int smallElement) {
        if (bigElement % smallElement == 0) {
            return smallElement;
        }
        return gcd(smallElement, bigElement % smallElement);
    }
}
