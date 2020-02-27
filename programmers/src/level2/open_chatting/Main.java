package level2.open_chatting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by REMI on 2020-02-05.
 */
public class Main {
    public static void main(String[] args) {
        String[] record = new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        Solution openChatting = new Solution();
        System.out.println((Arrays.toString(openChatting.solution(record))));
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
        for(int i = 0; i < record.length; i ++) {
            temp[i] = record[i].split(" ");
        }
        for(int j = 0; j < temp.length; j ++) {
            if(temp[j][0].equals("Enter")) {
                userIdMap.put(temp[j][1], temp[j][2]);
                answerSize ++;
            }else if(temp[j][0].equals("Change")) {
                userIdMap.replace(temp[j][1], temp[j][2]);
            }else {
                answerSize ++;
            }
        }

        answer = new String[answerSize];

        int answerIndex = 0;
        for(int i = 0; i < temp.length; i ++) {
            String actionType = temp[i][0];
            if(!actionType.equals(ACTION_TYPE[2])) {
                answer[answerIndex] = userIdMap.get(temp[i][1]) + answerMap.get(actionType);
                answerIndex ++;
            }
        }

        return answer;
    }
}
