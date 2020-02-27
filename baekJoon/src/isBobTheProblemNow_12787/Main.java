package isBobTheProblemNow_12787;

import java.util.*;

/**
 * Created by REMI on 2020-01-12.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public void solution() {
        int numberOfTestCase = scanner.nextInt();
        for(int i = 0; i < numberOfTestCase; i ++){
            int conversionCase = scanner.nextInt();
            if(conversionCase == 1){
                String data = scanner.next();
                printInteger(conversionToInteger(data));
            }else if(conversionCase == 2){
                String data = scanner.next();
                printString(conversionToString(data));
            }
        }
    }

    private StringBuilder conversionToInteger(String data) {
        StringBuilder result = new StringBuilder();
        String[] addr = data.split(".");
        for (String s : addr) {
            result.append(Integer.toBinaryString(Integer.parseInt(s)));
        }
        return result;
    }

    private StringBuilder conversionToString(String data) {
        StringBuilder result = new StringBuilder();
        int idx = 0;
        String temp = Integer.toBinaryString(Integer.parseInt(data));
        for(int i = 0; i < temp.length() / 8; i ++){
            result.append(Integer.toString(Integer.parseInt(temp.substring(idx, idx + 8)))).append(".");
            idx += 8;
        }
        result.deleteCharAt(result.lastIndexOf(String.valueOf(result.length())));
        return result;
    }

    private void printString(StringBuilder conversionToString) {
        System.out.println(conversionToString);
    }

    private void printInteger(StringBuilder conversionToInteger) {
        System.out.println(conversionToInteger);
    }
}
