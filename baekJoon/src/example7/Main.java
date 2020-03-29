package example7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scin = new Scanner(System.in);
        int n = scin.nextInt();
        int count = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String A = scin.next();
            for (int j = 0; j < A.length(); j++) {
                char a = A.charAt(j);
                if (a == 'O') {
                    count++;
                    //result += count;
                } else {
                    count = 0;
                }
                result += count;
            }
            System.out.println(result);
            result = 0;
            count = 0;
        }
    }
}