package problem3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Crab on 2020-03-28.
 */
public class Main {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"frodo", "fradi"};
        Solution solution = new Solution();
        System.out.println(solution.solution(user_id, banned_id));
    }
}

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        HashMap<Integer, String> hashMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i < banned_id.length; i++) {
            if (!hashMap.containsValue(banned_id[i])) {
                hashMap.put(index++, banned_id[i]);
            } else {
                hashMap.values().removeAll(Collections.singleton(banned_id[i]));
            }
        }
        int[] visited = new int[user_id.length];
        System.out.println(hashMap);
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            String banID = hashMap.get(key);
            System.out.println(banID);
            int count = 0;
            for (int j = 0; j < user_id.length; j++) {
                String userID = user_id[j];
                if (banID.length() != userID.length()) {
                    continue;
                }
                boolean flag = true;
                for (int k = 0; k < banID.length(); k++) {
                    if (banID.charAt(k) == '*') {
                        continue;
                    }
                    if (banID.charAt(k) != userID.charAt(k)) {
                        flag = false;
                    }
                }
                if (flag) {
                    visited[j]++;
                    count++;
                }
            }
            answer *= count;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0 || visited[i] == 1) {
                continue;
            }
            answer -= (visited[i] - 1);
        }
        return answer;
    }
}