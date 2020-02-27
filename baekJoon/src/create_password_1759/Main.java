package create_password_1759;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by REMI on 2020-01-17.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static Character[] possibleNumbers;
    private ArrayList<String> choiceNumbers;
//    private ArrayListList<>

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int numberOfChoices = scanner.nextInt();
        int numberOfPossibleNumbers = scanner.nextInt();
        possibleNumbers = new Character[numberOfPossibleNumbers];
        boolean[] visited = new boolean[numberOfPossibleNumbers];
        Arrays.fill(visited, false);
        choiceNumbers = new ArrayList<>();
        for(int i = 0; i < numberOfPossibleNumbers; i ++) {
            possibleNumbers[i] = scanner.next().charAt(0);
        }
        combination(choiceNumbers, visited, 0, numberOfPossibleNumbers, numberOfChoices);
        printChoiceNumbers();
    }

    public void combination(ArrayList<String> choiceNumbers, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    password.append(possibleNumbers[i]);
                }
            }
            choiceNumbers.add(String.valueOf(password));
        } else {
            for(int i = start; i < n; i ++) {
                visited[i] = true;
                combination(choiceNumbers, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    private void printChoiceNumbers() {
        Collections.sort(choiceNumbers);
        for (String choiceNumber : choiceNumbers) {
            System.out.print(choiceNumber);
        }
        System.out.println();
    }
}
