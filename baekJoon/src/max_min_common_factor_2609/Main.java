package max_min_common_factor_2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        solution.solution(n, m);
    }
}

class Solution {
    public void solution(int n, int m) {
        int commonDivisor = Math.min(n, m);
        for (int i = commonDivisor; i > 0; i --) {
            if (n % commonDivisor == 0 && m % commonDivisor == 0) {
                break;
            }
            commonDivisor --;
        }
        int commonMultiple = (n / commonDivisor) * (m / commonDivisor) * commonDivisor;
        System.out.println(commonDivisor);
        System.out.println(commonMultiple);
    }
}
