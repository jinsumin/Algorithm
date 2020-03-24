package example7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scin = new Scanner(System.in);

        int n = scin.nextInt();


        for (int a = 1; a <= n; a++) {
            for (int c = 1; c <= n - a; c++) {
                System.out.print(" ");
            }


            for (int b = 1; b <= a; b ++) {
                System.out.print("*");
            }
            System.out.println();


        }

    }
}
