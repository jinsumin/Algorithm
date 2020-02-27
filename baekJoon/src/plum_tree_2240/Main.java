package plum_tree_2240;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by REMI on 2020-02-21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int moveChance = scanner.nextInt();
        int[] trees = new int[T];
        PlumGame plumGame = new PlumGame(trees, moveChance);
        plumGame.play();
    }
}

class PlumGame {
    private static final int TREE_1 = 1;
    private static final int TREE_2 = 2;
    private static final int PLUM = 1;
    private int[] trees;
    private int[] memo;
    private int[] time;
    private int moveChance;

    public PlumGame(int[] trees, int moveChance) {
        this.trees = trees;
        this.memo = new int[moveChance + 1];
        this.moveChance = moveChance;
        this.time = new int[trees.length];
    }

    public void play() {
        int myPosition = TREE_1;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] == myPosition) {
                memo[0] += PLUM;
            }
        }

        for (int moveTime = 1; moveTime <= moveChance; moveTime++) {
            myPosition = (moveTime % 2);
        }
    }
}
