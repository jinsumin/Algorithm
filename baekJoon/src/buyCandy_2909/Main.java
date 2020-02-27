package buyCandy_2909;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int priceOfCandy = scanner.nextInt();
        int k = scanner.nextInt();
        int bill = 1;
        for(int i = 0; i < k; i ++){
            bill *= 10;
        }
        Solution sol = new Solution(priceOfCandy, bill);
        sol.printResult();
    }
}

class Solution {
    private static double result = 0;
    public Solution(int priceOfCandy, int bill) {
        solution(priceOfCandy, bill);
    }
    private void solution(int priceOfCandy, int bill) {
        result = (double)priceOfCandy + (double)(bill / 2);
        result -= (result % bill);
    }

    public void printResult() {
        System.out.println((int)result);
    }
}
