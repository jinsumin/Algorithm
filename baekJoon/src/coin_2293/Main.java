package coin_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by REMI on 2020-01-14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] priceOfCoin = new int[n + 1];
        int[] kindOfCoin = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            priceOfCoin[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution sol = new Solution();
        System.out.println(sol.solution(priceOfCoin, kindOfCoin, n, k));
    }
}

class Solution {
    public int solution(int[] priceOfCoin, int[] kindOfCoin, int n, int k) {
        kindOfCoin[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = priceOfCoin[i]; j <= k; j++) {
                kindOfCoin[j] += kindOfCoin[j - priceOfCoin[i]];
            }
        }
        return kindOfCoin[k];
    }
}
