package level2.file_name_sorting_kakao_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Crab on 2020-05-07.
 */
public class Main {
    public static void main(String[] args) {
        String[] files = {
                "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
        };
        Solution solution = new Solution();
        solution.solution(files);
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        ArrayList<File> arrayLists = new ArrayList<>();
        int index = 0;
        for (String file : files) {
            arrayLists.add(new File(file));
            //System.out.println(arrayLists.get(index).head + " " + arrayLists.get(index).number + " " + arrayLists.get(index).tail);
            index++;
        }
        Collections.sort(arrayLists, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.head.equals(o2.head)) {
                    return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
                } else {
                    return o1.head.compareTo(o2.head);
                }
            }
        });
        answer = new String[arrayLists.size()];
        for (int i = 0; i < arrayLists.size(); i ++) {
            answer[i] = arrayLists.get(i).fileName;
            //System.out.print(answer[i] + " ");
        }
        return answer;
    }

    private static class File {
        private String fileName;
        private String head = "";
        private String number = "";
        private String tail = "";

        public File(String fileName) {
            this.fileName = fileName;
            String[] str = fileName.toLowerCase().split("\\.");
            int splitIndex = 0;
            for (int i = 0; i < str[0].length(); i ++) {
                if (Character.isDigit(str[0].charAt(i))) {
                    splitIndex = i;
                    break;
                }
            }
            int notDigitIndex = str[0].length();
            for (int i = splitIndex; i < str[0].length(); i ++) {
                if (!Character.isDigit(str[0].charAt(i))) {
                    notDigitIndex = i;
                    break;
                }
            }
            String temp3 = str[0].substring(0, splitIndex);
            String temp4 = str[0].substring(splitIndex, notDigitIndex);
            String[] temp1 = temp3.split("-");
            this.head = temp3;
            this.number = temp4;
            //System.out.println(head + " " + number);
            if (str.length > 1) {
                this.tail = str[1];
            }
        }
    }
}
