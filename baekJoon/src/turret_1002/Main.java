package turret_1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-25.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int testCase = Integer.parseInt(bufferedReader.readLine());
        for (int t = 1; t <= testCase; t++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int r1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            int r2 = Integer.parseInt(stringTokenizer.nextToken());
            Solution solution = new Solution();
            System.out.println(solution.solution(x1, y1, r1, x2, y2, r2));
        }
    }
}

class Solution {
    public int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        if (r1 + r2 < distance) {
            return 0;
        }
        if (r1 + r2 == distance) {
            return 1;
        }
        if (Math.abs(r1 - r2) < distance && distance < r1 + r2) {
            return 2;
        }
        if (Math.abs(r1 - r2) == distance) {
            return 1;
        }
        if (Math.abs(r1 - r2) > distance) {
            return 0;
        }
        return -1;
    }
}
