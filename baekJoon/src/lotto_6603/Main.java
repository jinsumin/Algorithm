package lotto_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-27.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int number = Integer.parseInt(stringTokenizer.nextToken());
            if (number == 0) break;
            int[] numbers = new int[number];
            for (int i = 0; i < number; i++) {
                numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (checked[i]) {
                stringBuilder.append(numbers[i] + " ");
            }
        }
        System.out.println();
    }
}
