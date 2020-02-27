package drunken_sangbum_6359;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 0; t < testCase; t ++) {
            int numberOfRooms = scanner.nextInt();
            Solution sol = new Solution(numberOfRooms);
            for(int i = 1; i <= numberOfRooms; i ++) {  // 1 to 5
                sol.run(i);
            }
            System.out.println(sol.countOfEscape());
        }
    }
}

class Solution {
    private static final boolean OPENED = true;
    private static final boolean CLOSED = false;
    private static boolean[] numberOfRooms;
    public Solution(int numberOfRooms) {
        Solution.numberOfRooms = new boolean[numberOfRooms + 1];    // 0 to 5
        Arrays.fill(Solution.numberOfRooms, CLOSED);
    }

    public void run(int k) {
        for(int i = k; i <= numberOfRooms.length - 1; i += k) {
            if(numberOfRooms[i] == CLOSED) {
                numberOfRooms[i] = OPENED;
            }else {
                numberOfRooms[i] = CLOSED;
            }
        }
    }

    public int countOfEscape() {
        int count = 0;
        for(int i = 1; i <= numberOfRooms.length - 1; i ++) {
            if(numberOfRooms[i] == OPENED) {
                count ++;
            }
        }
        return count;
    }
}
