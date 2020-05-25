package kiroger_5397;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Crab on 2020-05-21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        for (int t = 1; t <= testCase; t++) {
            String input = bufferedReader.readLine();
            Solution solution = new Solution();
            bufferedWriter.write(solution.solution(input) + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

class Solution {
    public String solution(String input) {
        StringBuilder password = new StringBuilder();
        LinkedList<Character> linkedList = new LinkedList<>();
        ListIterator<Character> listIterator = linkedList.listIterator();
        for (int i = 0; i < input.length(); i ++) {
            char currentChar = input.charAt(i);
            if (currentChar == '<') {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                }
                continue;
            }
            if (currentChar == '>') {
                if (listIterator.hasNext()) {
                    listIterator.next();
                }
                continue;
            }
            if (currentChar == '-') {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                    listIterator.remove();
                }
                continue;
            }
            listIterator.add(currentChar);
        }
        for (Character character : linkedList) {
            password.append(character);
        }
        return password.toString();
    }
}
