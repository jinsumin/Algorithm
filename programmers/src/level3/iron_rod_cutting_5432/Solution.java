package level3.iron_rod_cutting_5432;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by REMI on 2020-01-29.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            String rod = scanner.next();
            Game game = new Game();
            game.play(rod);
            System.out.println("#" + t + " " + game.countOfCuttingRod());
        }
    }
}

class Game {
    private int cuttingRod = 0;

    public void play(String rod) {
        rod = rod.replace("()", "X");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < rod.length(); i++) {
            if (rod.charAt(i) == '(') {
                stack.push(rod.charAt(i));
            } else if (rod.charAt(i) == ')') {
                stack.pop();
                cuttingRod++;
            } else {
                cuttingRod += stack.size();
            }
        }
    }

    public int countOfCuttingRod() {
        return cuttingRod;
    }
}
