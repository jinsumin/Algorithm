package level1.dart_game_kakao_2018;

import java.util.ArrayList;

/**
 * Created by Crab on 2020-05-05.
 */
public class Main {
    public static void main(String[] args) {
        String dartResult = "1D2S3T*";
        Solution solution = new Solution();
        System.out.println(solution.solution(dartResult));
    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        int continuous = 0;
        int lastIndex = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char temp = dartResult.charAt(i);
            if (Character.isDigit(temp)) {
                continuous++;
            } else {
                if (continuous != 0) {
                    arrayList.add(dartResult.substring(lastIndex, lastIndex + continuous));
                }
                arrayList.add(String.valueOf(dartResult.charAt(i)));
                lastIndex = i + 1;
                continuous = 0;
            }
        }
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i ++) {
            switch (arrayList.get(i)) {
                case "S": {
                    int number = Integer.parseInt(arrayList.get(i - 1));
                    arrayList.set(i - 1, String.valueOf(number));
                    break;
                }
                case "D": {
                    int number = Integer.parseInt(arrayList.get(i - 1));
                    arrayList.set(i - 1, String.valueOf(number * number));
                    break;
                }
                case "T": {
                    int number = Integer.parseInt(arrayList.get(i - 1));
                    arrayList.set(i - 1, String.valueOf(number * number * number));
                    break;
                }
                case "*": {
                    if (i - 5 >= 0) {
                        String temp = arrayList.get(i - 5);
                        if (!temp.equals("S") && !temp.equals("D") && !temp.equals("T") && !temp.equals("#") && !temp.equals("*")) {
                            int number = Integer.parseInt(arrayList.get(i - 5));
                            arrayList.set(i - 5, String.valueOf(number * 2));
                        }
                    }
                    if (i - 4 >= 0) {
                        String temp = arrayList.get(i - 4);
                        if (!temp.equals("S") && !temp.equals("D") && !temp.equals("T") && !temp.equals("#") && !temp.equals("*")) {
                            int number = Integer.parseInt(arrayList.get(i - 4));
                            arrayList.set(i - 4, String.valueOf(number * 2));
                        }
                    }
                    int number = Integer.parseInt(arrayList.get(i - 2));
                    arrayList.set(i - 2, String.valueOf(number * 2));
                    break;
                }
                case "#": {
                    int number = Integer.parseInt(arrayList.get(i - 2));
                    arrayList.set(i - 2, String.valueOf(number * (-1)));
                    break;
                }
            }
        }
        for (String temp : arrayList) {
            if (!temp.equals("S") && !temp.equals("D") && !temp.equals("T") && !temp.equals("#") && !temp.equals("*")) {
                answer += Integer.parseInt(temp);
            }
        }
        return answer;
    }
}
