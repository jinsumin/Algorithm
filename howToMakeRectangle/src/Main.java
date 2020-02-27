import java.util.Scanner;

/**
 * Created by REMI on 2019-12-31.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfUnitSquare = scanner.nextInt();
        int[] sum = new int[100000];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 2;
        for(int i = 3; i <= numberOfUnitSquare; i ++) {
            sum[i] = sum[i - 1] + solve(i);
        }
        System.out.println(sum[numberOfUnitSquare]);
    }

    public static int solve(int numberOfUnitSquare) {
        int numberOfRectangle = 0;
        for(int i = 1; i <= Math.sqrt(numberOfUnitSquare); i ++) {
            if(numberOfUnitSquare % i == 0) {
                numberOfRectangle ++;
            }
        }
        return numberOfRectangle;
    }
}