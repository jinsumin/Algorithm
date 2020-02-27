package SWEA_8900;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-11.
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 1; t <= testCase; t ++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            String[] winningNumber = new String[N];
            int[] winnings = new int[N];
            String[] idNumber = new String[M];
            for (int i = 0; i < N; i++) {
                winningNumber[i] = scanner.next();
                winnings[i] = scanner.nextInt();
            }
            for (int i = 0; i < M; i++) {
                idNumber[i] = scanner.next();
            }
            Function func = new Function();
            int sumOfWinning = func.function(winningNumber, winnings, idNumber);
            System.out.println("#" + t + " " + sumOfWinning);
        }
    }
}

class Function {
    private int sumOfWinnings = 0;
    public int function(String[] winningNumber, int[] winnings, String[] idNumber) {
        for(int i = 0; i < idNumber.length; i ++){
            findMatchingNumber(winningNumber, winnings, idNumber[i]);
        }
        return sumOfWinnings;
    }

    private void findMatchingNumber(String[] winningNumber, int[] winnings, String idNumber) {
        for(int i = 0; i < winningNumber.length; i ++){
            boolean check = true;
            for(int j = 0; j < 8; j ++){
                if(winningNumber[i].charAt(j) == '*'){
                    continue;
                }
                if(winningNumber[i].charAt(j) != idNumber.charAt(j)){
                    check = false;
                    break;
                }
            }
            if(check) {
                sumOfWinnings += winnings[i];
            }
        }
    }
}
