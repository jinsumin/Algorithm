package level2.stock_price;

import java.util.*;

/**
 * Created by Crab on 2020-05-28.
 */
public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(prices)));
    }
}

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
}