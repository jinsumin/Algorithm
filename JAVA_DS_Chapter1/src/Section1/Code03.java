package Section1;

public class Code03 {

/*
    배열을 입력받아 소수인지 판별하는 코드
*/

    public static void main(String[] args) {
        for (int n = 2; n < 1000; n++) {
            boolean isPrime = true;
            for (int i = 2; i <= n / 2 && isPrime; i++) {
                if (n % i == 0) { // not prime
                    isPrime = false;
                    // break;
                }
            }
            if (isPrime)
                System.out.println(n + " is prime number");
        }
    }
}
