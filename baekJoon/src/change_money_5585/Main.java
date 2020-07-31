package change_money_5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Crab on 2020-07-31.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(bufferedReader.readLine());
        Solution solution = new Solution();
        System.out.println(solution.solution(money));
    }
}

class Solution {
    public int solution(int money) {
        int answer = 0;
        int change = 1000 - money;
        while (change >= 500) {
            change -= 500;
            answer++;
        }
        while (change >= 100) {
            change -= 100;
            answer++;
        }
        while (change >= 50) {
            change -= 50;
            answer++;
        }
        while (change >= 10) {
            change -= 10;
            answer++;
        }
        while (change >= 5) {
            change -= 5;
            answer++;
        }
        while (change >= 1) {
            change -= 1;
            answer++;
        }
        return answer;
    }
}
