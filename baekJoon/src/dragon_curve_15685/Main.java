package dragon_curve_15685;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-22.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private static int numberOfCurve;
    private static int[] x, y, d, g;

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        numberOfCurve = scanner.nextInt();
        for(int i = 0; i < numberOfCurve; i ++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
            g[i] = scanner.nextInt();
        }
    }
}
