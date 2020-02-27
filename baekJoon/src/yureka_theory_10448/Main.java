package yureka_theory_10448;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-06.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int number = scanner.nextInt();
            Solution sol = new Solution();
            System.out.println(sol.solution(number));
        }
    }
}

class Solution {
    private static final int[] EUREKA = new int[1000];
    private static boolean flag = false;

    public int solution(int number) {
        initEurekaArray();
        return isComposedThreeTriangulation(number);
    }

    private void initEurekaArray() {
        for (int i = 0; i < 1000; i++) {
            if (i == 0) {
                EUREKA[i] = 0;
            } else {
                EUREKA[i] = EUREKA[i - 1] + i;
            }
        }
    }

    private int isComposedThreeTriangulation(int number) {
        LinkedList<Integer> list = new LinkedList<>();
        reCombination(number, list, 1000, 3, 0);
        if(flag) {
            return 1;
        } else {
            return 0;
        }
    }

    private void reCombination(int number, LinkedList<Integer> list, int n, int r, int index) {
        if (r == 0) {
            int sum = 0;
            for (int i : list) {
                sum += list.get(i);
            }
            if (sum == number) {
                flag = true;
                return;
            }
            return;
        }
        if(index == n) {
            return;
        }
        list.add(index);
        reCombination(number, list, n, r - 1, index);
        list.removeLast();
        reCombination(number, list, n, r, index + 1);
    }
}
