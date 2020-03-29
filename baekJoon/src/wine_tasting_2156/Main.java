package wine_tasting_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-26.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfWineGlasses = Integer.parseInt(stringTokenizer.nextToken());
        int[] wines = new int[numberOfWineGlasses + 1];
        for (int i = 1; i <= numberOfWineGlasses; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            wines[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(wines, numberOfWineGlasses));
    }
}

class Solution {
    public int solution(int[] wines, int numberOfWineGlasses) {
        int[] memo = new int[numberOfWineGlasses + 1];
        if(numberOfWineGlasses == 1) {
            return wines[1];
        }
        if(numberOfWineGlasses == 2) {
            return wines[1] + wines[2];
        }
        memo[1] = wines[1];
        memo[2] = wines[1] + wines[2];
        for (int i = 3; i <= numberOfWineGlasses; i ++) {
            memo[i] = Math.max(memo[i - 1], Math.max(memo[i - 2] + wines[i], memo[i - 3] + wines[i - 1] + wines[i]));
        }
        return memo[numberOfWineGlasses];
    }
}
