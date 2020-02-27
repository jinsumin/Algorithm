package com.company;

import java.util.Scanner;

public class SWEA2072 {
    private static int numberOfTestCase;
    private static int sumOfOddNumber;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        numberOfTestCase = scanner.nextInt();




        for(int i = 0; i < numberOfTestCase; i ++){
            sumOfOddNumber =0;
            solve();
            printResult(i);
        }
    }

    private static void solve() {
        for(int i = 0; i < 10; i ++){
            int number = scanner.nextInt();
            if(number % 2 == 1){ sumOfOddNumber+= number;}
        }
    }

    private static void printResult(int n) {
        System.out.println("#" + (n + 1) + " " + sumOfOddNumber);
    }
}
