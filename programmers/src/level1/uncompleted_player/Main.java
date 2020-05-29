package level1.uncompleted_player;

import java.util.HashMap;

/**
 * Created by Crab on 2020-05-26.
 */
public class Main {
    public static void main(String[] args) {
        String[] participants = {
                "leo",
                "kiki",
                "eden"
        };
        String[] completions = {
                "eden",
                "kiki"
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(participants, completions));
    }
}

class Solution {
    public String solution(String[] participants, String[] completions) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String completion : completions) {
            if (hashMap.containsKey(completion)) {
                hashMap.put(completion, hashMap.get(completion) + 1);
            } else {
                hashMap.put(completion, 1);
            }
        }
        for (String participant : participants) {
            if (hashMap.containsKey(participant)) {
                if (hashMap.get(participant) > 0) {
                    hashMap.put(participant, hashMap.get(participant) - 1);
                } else {
                    return participant;
                }
            } else {
                return participant;
            }
        }
        return null;
    }
}


