package level3.Sae_sam_735_game_5948;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int i = 0; i < testCase; i ++) {
            int[] numbers = new int[7];
            for(int j = 0; j < 7; j ++) {
                numbers[j] = scanner.nextInt();
            }
            Game game = new Game();
            game.play(numbers);
            System.out.println("#" + (i + 1) + " " + game.findFifthComb());
        }
    }
}

class Game {
    private static int[] numbers;
    private static boolean[] comb = new boolean[1000];

    public void play(int[] numbers) {
        Game.numbers = numbers;
        LinkedList<Integer> list = new LinkedList<>();
        int[] selected = new int[7];
        Arrays.fill(Game.comb, false);
        permutation(7, 3, list, selected);
    }

    private void permutation(int n, int r, LinkedList<Integer> list, int[] selected) {
        if(list.size() == r) {
            int number = 0;
            for(Integer num : list) {
                number += num;
            }
            Game.comb[number] = true;
            return;
        }

        for(int i = 0; i < n; i ++) {
            if(selected[i] == 0) {
                list.add(Game.numbers[i]);
                selected[i] = 1;
                permutation(n, r, list, selected);
                selected[i] = 0;
                list.removeLast();
            }
        }
    }

    public int findFifthComb() {
        int count = 0;
        for(int i = 999; i > 0; i --){
            if(Game.comb[i]) { count ++; }
            if(count == 5) { return i; }
        }
        return 0;
    }
}
