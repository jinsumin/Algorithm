package level3.bus_route_6485;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-29.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 1; t <= testCase; t ++) {
            int[] a, b;
            int n = scanner.nextInt();
            a = new int[n + 1];
            b = new int[n + 1];
            for(int i = 1; i <= n; i ++) {
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
            }
        }
    }
}

class Bus {

}
