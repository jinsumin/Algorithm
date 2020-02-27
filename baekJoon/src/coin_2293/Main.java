package coin_2293;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-14.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static int[] kindOfCoin;
    private static int[] priceOfCoin;

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //  동전의 종류 수
        int k = scanner.nextInt();  //  동전 가치의 총합
        kindOfCoin = new int[k + 1];
        priceOfCoin = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            priceOfCoin[i] = scanner.nextInt();
        }
        kindOfCoin[0] = 1;
        for(int i = 1; i <= n; i ++) {
            for(int j = priceOfCoin[i]; j <= k; j ++) {
                kindOfCoin[j] += kindOfCoin[j - priceOfCoin[i]];
            }
        }
        System.out.println(kindOfCoin[k]);
    }
}
