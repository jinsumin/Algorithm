package intelligent_train_2455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-07-20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int[][] stations = new int[4][2];
        for (int i = 0; i < 4; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int minus = Integer.parseInt(stringTokenizer.nextToken());
            int plus = Integer.parseInt(stringTokenizer.nextToken());
            stations[i][0] = minus;
            stations[i][1] = plus;
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(stations));
    }
}

class Solution {
    public int solution(int[][] stations) {
        int answer = 0;
        int currentCountOfPeople = 0;
        for (int[] station : stations) {
            currentCountOfPeople -= station[0];
            currentCountOfPeople += station[1];
            if (currentCountOfPeople > answer) {
                answer = currentCountOfPeople;
            }
        }
        return answer;
    }
}
