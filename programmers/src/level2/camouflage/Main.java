package level2.camouflage;

import java.util.*;

/**
 * Created by Crab on 2020-09-02.
 */

public class Main {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(clothes));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        answer = getNumberOfAllCombinations(hashMap);
        return answer;
    }

    private int getNumberOfAllCombinations(HashMap<String, Integer> hashMap) {
        int result = 1;
        for (Integer integer : hashMap.values()) {
            result *= (integer + 1);
        }
        return result - 1;
    }
}
