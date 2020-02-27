package Section1;

import java.util.Scanner;

public class Code02 {
    public static void main(String []args){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i++){
            data[i] = scan.nextInt();
        }
        scan.close();

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += data[i];
        }
        System.out.println("The sum is " + sum);
    }
}
