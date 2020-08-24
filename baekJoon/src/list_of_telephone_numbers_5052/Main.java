package list_of_telephone_numbers_5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Crab on 2020-08-24.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        for (int t = 1; t <= testCase; t++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] phoneNumbers = new String[n];
            for (int i = 0; i < phoneNumbers.length; i ++) {
                phoneNumbers[i] = bufferedReader.readLine();
            }
            Solution solution = new Solution();
            solution.solution(phoneNumbers);
        }
    }
}

class Solution {
    public void solution(String[] phoneNumbers) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < phoneNumbers.length; i++) {
            phoneNumbers[i] = phoneNumbers[i].replace(" ", "");
            arrayList.add(phoneNumbers[i]);
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i + 1).startsWith(arrayList.get(i))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
