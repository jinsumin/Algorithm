package Section1;
/*두 정수 a, b를 입력받아 a의 b제곱을 계산하여라*/

import java.util.Scanner;

public class Code16 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = power(a, b);
        System.out.println("The a power b is " + result);
    }

    private static int power(int a, int b){
        int result = 1;
        for(int i = 0; i < b; i++){
            result *= a;
        }
        return result;
    }
}
