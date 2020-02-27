package level2.poketmon;

import java.util.Arrays;

/**
 * Created by REMI on 2020-01-13.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int kind = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i - 1] != nums[i]) {
                kind ++;
            }
        }
        if(nums.length / 2 < kind) {
            answer = nums.length / 2;
            return answer;
        }
        answer = kind;
        return answer;
    }
}