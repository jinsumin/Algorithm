package zero_10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Crab on 2020-08-24.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[K];
        for (int i = 0; i < numbers.length; i ++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers));
    }
}

class Solution {
    public int solution(int[] numbers) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int number : numbers) {
            if (number == 0) {
                linkedList.pop();
            } else {
                linkedList.push(number);
            }
        }
        return sumOfList(linkedList);
    }

    private int sumOfList(LinkedList<Integer> linkedList) {
        int result = 0;
        while (!linkedList.isEmpty()) {
            result += linkedList.pop();
        }
        return result;
    }
}
