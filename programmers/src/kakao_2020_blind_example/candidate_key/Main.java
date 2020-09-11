package kakao_2020_blind_example.candidate_key;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Crab on 2020-08-26.
 */
public class Main {
    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(relation));
    }
}

class Solution {
    private int answer = 0;

    public int solution(String[][] relation) {
        for (int r = 1; r <= relation[0].length; r++) {
            boolean[] visited = new boolean[relation[0].length];
            isCandidateKey(relation, visited, 0, relation[0].length, r);
        }
        return answer;
    }

    public void isCandidateKey(String[][] relation, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            if (!isOverlaps(relation, visited)) {
                answer ++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            isCandidateKey(relation, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private boolean isOverlaps(String[][] relation, boolean[] visited) {
        Map<String, Integer> candidateKey = new HashMap<>();
        for (int i = 0; i < relation.length; i ++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < visited.length; j ++) {
                if (visited[j]) {
                    key.append(relation[i][j]);
                }
            }
            if (candidateKey.containsKey(key.toString())) {
                return true;
            }
            candidateKey.put(key.toString(), 1);
        }
        return false;
    }
}
