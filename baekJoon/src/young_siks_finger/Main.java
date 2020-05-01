package young_siks_finger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-01.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long injuredFinger = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long countTimes = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(injuredFinger, countTimes));
    }
}

class Solution {
    public long solution(long injuredFinger, long countTimes) {
        // 1;9;17;25;
        // 2;8;10;16;18;24;26;
        // 3;7;11;15;19;23;27;
        // 4;6;12;14;20;22;28;
        // 5;13;21;29;
        if (injuredFinger == 1) {
            if (countTimes == 0) {
                return 0;
            }
            return (1 + (8 * (countTimes))) - 1;
        } else if (injuredFinger == 2) {
            if (countTimes == 0) {
                return 1;
            }
            if (countTimes % 2 == 0) {
                return (2 + (8 * ((countTimes) / 2)) - 1);
            } else {
                return (8 * (countTimes + 1) / 2) - 1;
            }
        } else if (injuredFinger == 3) {
            if (countTimes == 0) {
                return 2;
            }
            if (countTimes % 2 == 0) {
                return (3 + (8 * (countTimes) / 2) - 1);
            } else {
                return (8 * (countTimes + 1) / 2) - 2;
            }
        } else if (injuredFinger == 4) {
            if (countTimes == 0) {
                return 3;
            }
            if (countTimes % 2 == 0) {
                return (4 + (8 * (countTimes) / 2) - 1);
            } else {
                return (8 * (countTimes + 1) / 2) - 3;
            }
        } else {
            if (countTimes == 0) {
                return 4;
            }
            return (5 + (8 * (countTimes))) - 1;
        }
    }
}
