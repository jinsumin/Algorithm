import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int x = 1; x <= a; x++) {
            for (int z = 1; z < x; z++) {
                System.out.print(" ");
            }
            for (int y = 0; y <= 2 *(a - x) - 2; y++){
                System.out.print("*");
            }

            System.out.println();
        }

        for (int x = 1; x < a; x++) {
            for (int b = 2; b <= a - x; b++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= 2 * x +1; c++) {
                System.out.print("*");
            }

            System.out.println();
        }


    }
}