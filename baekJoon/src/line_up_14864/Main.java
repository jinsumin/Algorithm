package line_up_14864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-25.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfStudents = Integer.parseInt(stringTokenizer.nextToken());
        int numberOfCards = Integer.parseInt(stringTokenizer.nextToken());
        int[][] cards = new int[numberOfCards][2];
        for (int i = 0; i < numberOfCards; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            cards[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            cards[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        solution.solution(cards, numberOfStudents, numberOfCards);
    }
}

class Solution {
    public void solution(int[][] cards, int numberOfStudents, int numberOfCards) {
        ArrayList<Integer> students = new ArrayList<>();
        for (int id = 1; id <= numberOfStudents; id ++) {
            students.add(id);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList[] list = new ArrayList[numberOfStudents + 1];
        for (int id = 1; id <= numberOfStudents; id ++) {
            list[id] = new ArrayList();
        }

        for (int i = 0; i < numberOfCards; i ++) {
            list[cards[i][0]].add(cards[i][1]);
        }

        for (int id = 1; id <= numberOfStudents; id ++) {
            int index = list[id].size();
            answer.add(students.get(index));
            students.remove(index);
        }

        for (int i = 0; i < numberOfCards; i ++) {
            if(answer.get(cards[i][0] - 1) < answer.get(cards[i][1] - 1)) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 0; i < answer.size(); i ++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }
}
