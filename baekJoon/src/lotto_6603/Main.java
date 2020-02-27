package lotto_6603;

import java.util.Scanner;

/**
 * Created by REMI on 2020-02-20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) break;
            int[] numbers = new int[number];
            for (int i = 0; i < number; i++) {
                numbers[i] = scanner.nextInt();
            }
            Lotto lotto = new Lotto();
            lotto.play(numbers);
        }
    }
}

class Lotto {
    private final static int GERMAN_LOTTO_COUNT = 6;

    public void play(int[] numbers) {
        boolean[] checked = new boolean[numbers.length];
        dfs(numbers, checked, 0, GERMAN_LOTTO_COUNT);
        System.out.println();
    }

    private void dfs(int[] numbers, boolean[] checked, int index, int count) {
        if (count == 0) {
            print(numbers, checked);
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(numbers, checked, i, count - 1);
                checked[i] = false;
            }
        }
    }

    private void print(int[] numbers, boolean[] checked) {
        for (int i = 0; i < numbers.length; i++) {
            if (checked[i]) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
    }
}
