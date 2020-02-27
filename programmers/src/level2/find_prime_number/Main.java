package level2.find_prime_number;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-15.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new Scanner(System.in).next()));
    }
}

class Solution {
    private static int countPrimeNumber = 0;
    private static char[] numbers;
    private static boolean[] visited;

    public int solution(String numbers) {
        Solution.numbers = numbers.toCharArray();
        Solution.visited = new boolean[(int) Math.pow(10, numbers.length())];
        Arrays.fill(Solution.visited, false);
        Arrays.sort(Solution.numbers);
        int[] selected = new int[Solution.numbers.length];
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 1; i <= Solution.numbers.length; i ++){
            permutation(Solution.numbers.length, i, list, selected);
        }
        for(int i = 1; i < Solution.visited.length; i ++) {
            if(Solution.visited[i]) {
                Solution.countPrimeNumber ++;
            }
        }
        return countPrimeNumber;
    }

    private void permutation(int n, int r, LinkedList<Character> list, int[] selected) {
        if(list.size() == r) {
            StringBuilder number = new StringBuilder();
            for(Character ch : list) {
                number.append(ch);
            }
            if(isPrimeNumber(Integer.parseInt(number.toString()))) {
                visited[Integer.parseInt(number.toString())] = true;
            }
            return;
        }

        for(int i = 0; i < n; i ++) {
            if(selected[i] == 0) {
                list.add(Solution.numbers[i]);
                selected[i] = 1;
                permutation(n, r, list, selected);
                selected[i] = 0;
                list.removeLast();
            }
        }
    }

    private boolean isPrimeNumber(int number) {
        if(number == 1) { return false; }
        for(int i = 2; i <= Math.sqrt(number); i ++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
