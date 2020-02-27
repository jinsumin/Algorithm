package poketmon_master_dasom_1620;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-06.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfMonster = scanner.nextInt();
        int numberOfQuestion = scanner.nextInt();
        String[] monsters = new String[numberOfMonster];
        for(int i = 0; i < numberOfMonster; i ++) {
            monsters[i] = scanner.next();
        }
        String[] questions = new String[numberOfQuestion];
        for(int i = 0; i < numberOfQuestion; i ++) {
            questions[i] = scanner.next();
        }
        Solution sol = new Solution();
        sol.solution(monsters, questions);
        sol.printAnswer();
    }
}

class Solution {
    private String[] answer;
    public void solution(String[] monsters, String[] questions) {
        answer = new String[questions.length];
        for(int i = 0; i < questions.length; i ++) {
            if(Character.isDigit(questions[i].charAt(0))) {
                answer[i] = monsters[Integer.parseInt(String.valueOf(questions[i])) - 1];
            } else {
                for(int j = 0; j < monsters.length; j ++) {
                    if(questions[i].equals(monsters[j])) {
                        answer[i] = String.valueOf(j + 1);
                        break;
                    }
                }
            }
        }
    }

    public void printAnswer() {
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
