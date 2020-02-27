package example4;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by REMI on 2020-02-11.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] clothes = {
                {"yellohat", "모자"},
                {"blue shoe", "신발"}
        };
        System.out.println(sol.solution(clothes));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Iterator<Integer> iterator = hashMap.values().iterator();
        return 0;
    }
}
