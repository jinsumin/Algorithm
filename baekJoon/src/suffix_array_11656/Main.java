package suffix_array_11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Crab on 2020-08-04.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Solution solution = new Solution();
        solution.solution(input);
    }
}

class Solution {
    public void solution(String input) {
        ArrayList<String> suffixArrayList = new ArrayList<>();
        for (int i = 0; i < input.length(); i ++) {
            suffixArrayList.add(input.substring(i));
        }
        Collections.sort(suffixArrayList);
        printAnswer(suffixArrayList);
    }

    private void printAnswer(ArrayList<String> suffixArrayList) {
        for (String s : suffixArrayList) {
            System.out.println(s);
        }
    }
}
