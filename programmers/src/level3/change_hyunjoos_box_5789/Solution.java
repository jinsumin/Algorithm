package level3.change_hyunjoos_box_5789;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-29.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            Box hyunJoo = new Box();
            hyunJoo.box(scanner);
            System.out.print("#" + t);
            hyunJoo.printResult();
        }
    }
}

class Box {
    private int[] arr;

    public static class Pair {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public void box(Scanner scanner) {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        arr = new int[n + 1];
        List<Pair> list = new LinkedList<>();
        for (int i = 0; i < q; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            list.add(new Pair(left, right));
        }
        Iterator<Pair> iterator = list.iterator();
        int num = 1;
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            for (int i = pair.left; i <= pair.right; i++) {
                arr[i] = num;
            }
            num++;
        }
    }

    public void printResult() {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
}
