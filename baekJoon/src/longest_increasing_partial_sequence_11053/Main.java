package longest_increasing_partial_sequence_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-29.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] sequence = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(sequence));
    }
}

class Solution {
    public int solution(int[] sequence) {
        int max = 0;
        int[] memo = new int[sequence.length];
        Arrays.fill(memo, 1);
        for (int i = sequence.length - 2; i >= 0; i--) {
            int longest = 0;
            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[i] < sequence[j]) {
                    if (memo[j] > longest) {
                        longest = memo[j];
                    }
                }
            }
            memo[i] += longest;
            if (memo[i] > max) {
                max = memo[i];
            }
        }
        return max;
    }
}
