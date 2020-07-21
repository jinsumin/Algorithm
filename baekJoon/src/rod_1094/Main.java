package rod_1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Crab on 2020-07-21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(bufferedReader.readLine());
        Solution solution = new Solution();
        System.out.println(solution.solution(X));
    }
}

class Solution {
    public int solution(int x) {
        int answer = 1;
        int lengthOfRod = 64;
        int shortestPieceOfRod = lengthOfRod;
        while (x != lengthOfRod) {
            shortestPieceOfRod /= 2;
            answer ++;
            if (lengthOfRod - shortestPieceOfRod >= x) {
                lengthOfRod -= shortestPieceOfRod;
                answer --;
            }
        }
        return answer;
    }
}
