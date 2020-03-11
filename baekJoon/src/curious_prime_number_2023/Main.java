package curious_prime_number_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-03-11.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        solution.solution(n);
        solution.printList();
    }
}

class Solution {
    private List<String> list = new ArrayList<>();

    public void solution(int n) {
        findCuriousPrimeNumber("", 0, n);
        Collections.sort(list);
    }

    private void findCuriousPrimeNumber(String str, int digit, int n) {
        if (digit == n) {
            list.add(str);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (isPrimeNumber(str + i)) {
                findCuriousPrimeNumber(str + i, digit + 1, n);
            }
        }
    }

    private boolean isPrimeNumber(String str) {
        int n = Integer.parseInt(str);
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void printList() {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
