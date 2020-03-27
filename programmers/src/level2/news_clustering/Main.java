package level2.news_clustering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-27.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String str1 = stringTokenizer.nextToken();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String str2 = stringTokenizer.nextToken();
        Solution solution = new Solution();
        System.out.println(solution.solution(str1, str2));
    }
}

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i = 0; i < str1.length(); i ++ ) {
            if (i + 2 <= str1.length()) {
                String temp = str1.substring(i, i + 2);
                if ((temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z') || (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z')) {
                    if ((temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z') || (temp.charAt(1) >= 'a' && temp.charAt(1) <= 'z')) {
                        arrayList1.add(temp.toLowerCase());
                    }
                }
            }
        }
        for (int i = 0; i < str2.length(); i ++ ) {
            if (i + 2 <= str2.length()) {
                String temp = str2.substring(i, i + 2);
                if ((temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z') || (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z')) {
                    if ((temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z') || (temp.charAt(1) >= 'a' && temp.charAt(1) <= 'z')) {
                        arrayList2.add(temp.toLowerCase());
                    }
                }
            }
        }
        Collections.sort(arrayList1);
        Collections.sort(arrayList2);
        //System.out.println(arrayList1);
        //System.out.println(arrayList2);
        double union = 0;
        double intersection = 0;
        int temp = 0;
        for (int i = 0; i < arrayList1.size(); i++) {
            for (int j = temp; j < arrayList2.size(); j++) {
                if (arrayList1.get(i).equals(arrayList2.get(j))) {
                    intersection ++;
                    temp = j + 1;
                    break;
                }
            }
        }
        union = arrayList1.size() + arrayList2.size() - intersection;
        //System.out.println("합집합 갯수 : " + union);
        //System.out.println("교집합 갯수 : " + intersection);
        if (union == 0 && intersection == 0) {
            answer = 65536;
        } else {
            answer = (int) (((double)intersection / (double)union) * 65536.0);
        }
        return answer;
    }
}
