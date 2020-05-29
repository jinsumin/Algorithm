package level2.camouflage;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Crab on 2020-05-26.
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
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        for (Integer integer : hashMap.values()) {
            answer *= (integer + 1);
        }
        return answer - 1;
    }
}