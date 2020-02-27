package Section1;

import java.util.Scanner;

/*
n개의 정수를 입력받는다. 이후 임의의 연속된 구간의 합이 최대가 되는 값을 찾는 코드를 작성
*/

public class Code12 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // array length n
        int[] data = new int[n];
        for(int i = 0; i < n; i ++)
            data[i] = sc.nextInt();
        sc.close();

        int maxSum = 0;
        for(int i = 0; i < n; i ++){
            for(int j = i; j < n; j ++){
                int sum = 0;
                for(int k = 0; k <= j; k++){
                    sum += data[k];
                }
                if(sum > maxSum) maxSum = sum;
            }
        }
        System.out.println("The max sum is : " + maxSum);
    }
}
