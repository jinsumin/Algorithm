package im_a_frog_5550;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-18.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 1; t <= testCase; t ++) {
            String sound = scanner.next();
            Frog frog = new Frog();
            frog.croak(sound);
            System.out.println("#" + t + " " + frog.count());
        }
    }
}

class Frog {
    private static int countOfFrog = 0;
    private static String frogSound = "croak";
    private static int[] alphabet = new int[5];
    public void croak(String sound) {
        boolean c = false;
        boolean k = false;
        Arrays.fill(alphabet, 0);
        for(int i = 0; i < sound.length(); i ++) {
            if(isWrongSound()) {
                countOfFrog = -1;
                return;
            }
            if(sound.charAt(i) == 'c') { alphabet[0] ++; c = true;}
            if(sound.charAt(i) == 'r') { alphabet[1] ++; }
            if(sound.charAt(i) == 'o') { alphabet[2] ++; }
            if(sound.charAt(i) == 'a') { alphabet[3] ++; }
            if(sound.charAt(i) == 'k') { alphabet[4] ++; k = true;}
            if(c && k ) { countOfFrog --; c = false; k = false; }
        }
        countOfFrog += alphabet[0];
    }

    private boolean isWrongSound() {
        for(int i = 1; i < 5; i ++) {
            if(alphabet[i - 1] < alphabet[i]) {
                return true;
            }
        }
        return false;
    }

    public int count() {
        return countOfFrog;
    }
}
