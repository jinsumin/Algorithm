package level2.example8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i ++) {
            array[i] = scanner.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i ++) {
            int sum = 0;
            for (int j = i; j < array.length; j ++) {
                sum += array[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}