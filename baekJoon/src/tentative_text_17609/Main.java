package tentative_text_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-19.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int numberOfStrings = Integer.parseInt(stringTokenizer.nextToken());
        String[] strings = new String[numberOfStrings];
        for (int i = 0; i < numberOfStrings; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            strings[i] = stringTokenizer.nextToken();
        }

        Solution solution = new Solution();
        solution.solution(strings, numberOfStrings);
        solution.printAnswers();
    }
}

class Solution {
    private int[] answers;

    public void solution(String[] strings, int numberOfStrings) {
        answers = new int[numberOfStrings];
        LinkedList<Character>[] linkedLists = new LinkedList[numberOfStrings];
        for (int i = 0; i < numberOfStrings; i++) {
            int countDiff = 0;
            linkedLists[i] = new LinkedList<>();
            for (int j = 0; j < strings[i].length(); j++) {
                linkedLists[i].offer(strings[i].charAt(j));
            }
            while (linkedLists[i].size() > 1) {
                if (linkedLists[i].getFirst() == linkedLists[i].getLast()) {
                    linkedLists[i].pollFirst();
                    linkedLists[i].pollLast();
                } else {
                    countDiff++;
                    if (countDiff >= 2) {
                        break;
                    }
                    int length = linkedLists[i].size();
                    if (linkedLists[i].get(0) == linkedLists[i].get(length - 2)) {
                        if (linkedLists[i].size() < 3) {
                            linkedLists[i].pollLast();
                        } else {
                            if (linkedLists[i].get(1) == linkedLists[i].get(length - 3)) {
                                linkedLists[i].pollLast();
                                continue;
                            }
                        }
                    }
                    if (linkedLists[i].get(1) == linkedLists[i].get(length - 1)) {
                        if (linkedLists[i].size() < 3) {
                            linkedLists[i].pollFirst();
                        } else {
                            if (linkedLists[i].get(2) == linkedLists[i].get(length - 2)) {
                                linkedLists[i].pollFirst();
                            }
                        }
                    } else {
                        countDiff++;
                        break;
                    }
                }
            }
            if(countDiff >= 2) {
                countDiff = 2;
            }
            answers[i] = countDiff;
        }
    }

    public void printAnswers() {
        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}
