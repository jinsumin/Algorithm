package kakao_2020_blind_example.open_chat_room;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Crab on 2020-08-25.
 */
public class Main {
    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
        };
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(record)));
    }
}

class Solution {
    private static final String[] ACTION_TYPE = {"Enter", "Leave", "Change"};

    public String[] solution(String[] record) {
        String[] answer;
        int answerSize = 0;
        Map<String, String> userIdMap = new HashMap<String, String>();
        Map<String, String> answerMap = new HashMap<String, String>();
        answerMap.put("Enter", "님이 들어왔습니다.");
        answerMap.put("Leave", "님이 나갔습니다.");
        String[][] temp = new String[record.length][3];
        // 문자열 space 기준으로 자르기
        for (int i = 0; i < record.length; i++) {
            temp[i] = record[i].split(" ");
        }
        // user id, nickname (key value) 세팅
        for (String[] strings : temp) {
            if (strings[0].equals("Enter")) {
                userIdMap.put(strings[1], strings[2]);
                answerSize++;
            } else if (strings[0].equals("Change")) {
                userIdMap.replace(strings[1], strings[2]);
            } else {
                answerSize++;
            }
        }
        // 출력할 문자열 Change action 제외하고 return
        answer = new String[answerSize];
        int answerIndex = 0;
        for (String[] strings : temp) {
            String actionType = strings[0];
            if (!actionType.equals(ACTION_TYPE[2])) {
                answer[answerIndex++] = userIdMap.get(strings[1]) + answerMap.get(actionType);
            }
        }
        return answer;
    }
}
