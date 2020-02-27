package Section1;/*
1 부터 n 까지의 모든 소수를 찾는 코드
*/

import java.util.Scanner;

public class Code10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int n = 2; n <= input; n++) {
            boolean isPrime = true;
            for (int i = 2; i*i <= n && isPrime; i++)
                if (n % i == 0)
                    isPrime = false;
            if (isPrime)
                System.out.println(n);
        }
    }
}
