package kakao_2020_blind_example.string_compression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Crab on 2020-08-25.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    public int solution(String input) {
        int answer = Integer.MAX_VALUE;
        int[] compressedLength = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            compressedLength[i] = compressStringWithUnit(input, i + 1);
        }
        for (int i = 0; i < compressedLength.length; i++) {
            if (answer > compressedLength[i]) {
                answer = compressedLength[i];
            }
        }
        return answer;
    }

    private int compressStringWithUnit(String input, int unit) {
        // split input string
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < input.length(); i += unit) {
            if (i + unit > input.length()) {
                arrayList.add(input.substring(i));
            } else {
                arrayList.add(input.substring(i, i + unit));
            }
        }
        arrayList.add(".");

        // convert input string to compressed string
        StringBuilder compressedString = new StringBuilder();
        String temp = arrayList.get(0);
        int count = 1;
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(temp)) {
                count ++;
            } else {
                if (count != 1) {
                    compressedString.append(count);
                }
                count = 1;
                compressedString.append(temp);
                temp = arrayList.get(i);
            }
        }
        System.out.println(compressedString);
        return compressedString.length();
    }
}
