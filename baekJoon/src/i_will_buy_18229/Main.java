package i_will_buy_18229;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-14.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static int[][] people;
    private static int[] winner;

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int numberOfCycle = scanner.nextInt();
        int distance = scanner.nextInt();
        people = new int[numberOfPeople+1][numberOfCycle+1];
        winner = new int[numberOfPeople+1];
        for(int i = 0; i < numberOfPeople; i ++) {
            for (int j = 0; j < numberOfCycle; j++) {
                people[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < numberOfPeople; i ++) {
            winner[i] = 0;
        }
        for(int j = 0; j < numberOfCycle; j ++) {
            for(int i = 0; i < numberOfPeople; i ++) {
                winner[i] += people[i][j];
                if(winner[i] >= distance) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }
}