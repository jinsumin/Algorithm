package white_compartment_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Crab on 2020-05-13.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    public int solution(char[][] map) {
        int answer = 0;
        int startIndex = 0;
        for (int i = 0; i < 8; i++) {
            startIndex %= 2;
            for (int j = startIndex; j < 8; j += 2) {
                if (map[i][j] == 'F') {
                    answer++;
                }
            }
            startIndex++;
        }
        return answer;
    }
}
