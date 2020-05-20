package water_bottle_1052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-18.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(N, K));
    }
}

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        while (oneCount(Integer.toBinaryString(n)) > k) {
            n++;
            answer++;
        }
        return answer;
    }

    private int oneCount(String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); i ++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
