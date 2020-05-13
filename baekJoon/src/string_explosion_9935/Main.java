package string_explosion_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Crab on 2020-05-13.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String bomb = bufferedReader.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(input, bomb));
    }
}

class Solution {
    public String solution(String input, String bomb) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < input.length(); i ++) {
            arrayList.add(input.charAt(i));
            if (arrayList.get(arrayList.size() - 1) == bomb.charAt(bomb.length() - 1)) {
                if (isContainBombInLastIndex(arrayList, bomb)) {
                    deleteBomb(arrayList, bomb);
                }
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return "FRULA";
        }
        for (int i = 0; i < size; i ++) {
            answer.append(arrayList.get(i));
        }
        return answer.toString();
    }

    private boolean isContainBombInLastIndex(ArrayList<Character> arrayList, String bomb) {
        if (arrayList.size() < bomb.length()) {
            return false;
        }
        boolean flag = true;
        int index = arrayList.size() - bomb.length();
        for (int i = 0; i < bomb.length(); i ++) {
            if (arrayList.get(index) != bomb.charAt(i)) {
                flag = false;
                break;
            }
            index++;
        }
        return flag;
    }

    private void deleteBomb(ArrayList<Character> arrayList, String bomb) {
        for (int i = 0; i < bomb.length(); i ++) {
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
