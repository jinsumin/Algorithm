package sort_inside_1427;

import java.util.Scanner;

/**
 * Created by Crab on 2020-04-08.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Solution solution = new Solution();
        solution.solution(number);
        solution.printAnswer();
    }
}

class Solution {
    private int[] array = new int[10];  // 0부터 9까지 숫자 갯수 저장할 배열

    public void solution(int number) {
        while(number > 0) {
            array[number % 10] ++;      // number 마지막 자리수 숫자를 인덱스로하는 array 배열에 접근하여 갯수 증가
            number /= 10;               // number 를 10으로 나누어서 새로 저장
        }
    }

    public void printAnswer() {
        StringBuilder answer = new StringBuilder();
        for (int index = 9; index >= 0; index --) {
            while (array[index] > 0) {
                answer.append(index);
                array[index] --;
            }
        }
        System.out.println(Integer.parseInt(String.valueOf(answer)));
    }
}
