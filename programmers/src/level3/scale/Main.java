package level3.scale;

import java.util.Arrays;

/**
 * Created by REMI on 2020-01-23.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] weight = {3, 1, 6, 2, 7, 30, 1};
        //int[] weight = {1, 2, 3, 4, 5};
        System.out.println(sol.solution(weight));
    }
}

class Solution {
    private static int[] memo;
    public int solution(int[] weight) {
        int answer = 0;
        memo = new int[1000000];
        Arrays.sort(weight);
        solve(weight);
        return answer;
    }

    private void solve(int[] weight) {
        if(weight.length == 1) { return; }
        int sum = 0;
        int[] temp = new int[weight.length - 1];
        for(int i = 0; i < weight.length - 1; i ++) {
            temp[i] = weight[i];
            sum += temp[i];
            memo[sum] = 1;
        }
        solution(temp);
    }

    private int printResult() {
        for(int i = 0; i < 1000000; i ++) {
            if(memo[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
