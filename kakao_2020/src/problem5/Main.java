package problem5;

/**
 * Created by Crab on 2020-03-28.
 */
public class Main {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.solution(stones, k));
    }
}


class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int count = 0;
        int number = Integer.MAX_VALUE;
        while (number > 0) {
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] <= k) {
                    count++;
                    //System.out.println("count : " + count);
                } else {
                    count = 0;
                }
                if (count >= k) {
                    answer += k;
                    return answer;
                }
            }
            number --;
            answer ++;
            for (int i = 0; i < stones.length; i ++) {
                stones[i] --;
            }
            //System.out.println("k : " + k);
        }
        return answer;
    }
}
