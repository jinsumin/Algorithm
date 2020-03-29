package problem2;

import java.util.*;

/**
 * Created by Crab on 2020-03-28.
 */
public class Main {
    public static void main(String[] args) {
        String s = "{3},{2,3}";
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(s)));
    }
}

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] sizeOfLists = new int[501];
        LinkedList<Integer>[] lists = new LinkedList[501];
        int index = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '{') {
                count = 0;
                lists[index] = new LinkedList<>();
            } else if (s.charAt(i) == '}') {
                sizeOfLists[index] = count;
                index ++;
            } else if (s.charAt(i) == ',') {
                continue;
            } else {
                StringBuilder str = new StringBuilder();
                while (s.charAt(i) != '{' && s.charAt(i) != '}' && s.charAt(i) != ',') {
                    str.append(s.charAt(i));
                    i ++;
                }
                lists[index].offer(Integer.parseInt(String.valueOf(str)));
                count ++;
            }
        }
        for (int length = 1; length <= index; length ++) {
            for (int i = 0; i <= index; i++) {
                if (sizeOfLists[i] == length) {
                    if (arrayList.isEmpty()) {
                        arrayList.add(lists[i].poll());
                    } else {
                        if (lists[i] != null) {
                            while (!lists[i].isEmpty()) {
                                boolean flag = false;
                                int temp = lists[i].poll();
                                for (int j = 0; j < arrayList.size(); j++) {
                                    if (temp == (Integer) arrayList.get(j)) {
                                        flag = true;
                                    }
                                }
                                if (!flag) {
                                    arrayList.add(temp);
                                }
                            }
                        }
                    }
                }
            }
        }
        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i ++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
