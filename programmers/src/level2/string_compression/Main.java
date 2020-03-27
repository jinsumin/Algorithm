package level2.string_compression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-27.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String s = stringTokenizer.nextToken();
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int[] length = new int[s.length() + 1];
        length[0] = s.length();
        for (int unit = 1; unit <= s.length(); unit++) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < s.length(); i += unit) {
                if (i + unit > s.length()) {
                    arrayList.add(s.substring(i));
                } else {
                    arrayList.add(s.substring(i, i + unit));
                }
            }
            arrayList.add(".");
            int count = 1;
            StringBuilder compressedString = new StringBuilder();
            String temp = arrayList.get(0);
            for (int i = 1; i < arrayList.size(); i ++) {
                if (arrayList.get(i).equals(temp)) {    // 연속되면
                    count ++;
                } else {                                // 연속되지 않으면
                    if (count != 1) {                   // 그동안 연속된게 있으면
                        compressedString.append(count);
                    }
                    count = 1;
                    compressedString.append(temp);
                    temp = arrayList.get(i);
                }
            }
            System.out.println(compressedString);
            length[unit] = compressedString.length();
        }
        for (int value : length) {
            if (answer > value) {
                answer = value;
            }
        }
        return answer;
    }
}
