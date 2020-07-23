package ball_1547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-07-23.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int M = Integer.parseInt(bufferedReader.readLine());
        int[][] actions = new int[M][2];
        for (int i = 0; i < M; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            actions[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            actions[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(actions));
    }
}

class Solution {
    public int solution(int[][] actions) {
        int answer;
        int[] map = new int[4];
        initMap(map);
        swapBalls(map, actions);
        answer = map[1];
        return answer;
    }

    private void initMap(int[] map) {
        for (int i = 1; i <= 3; i ++) {
            map[i] = i;
        }
    }

    private void swapBalls(int[] map, int[][] actions) {
        for (int[] action : actions) {
            int indexOfX = find(map, action[0]);
            int indexOfY = find(map, action[1]);
            int temp = map[indexOfX];
            map[indexOfX] = map[indexOfY];
            map[indexOfY] = temp;
        }
    }

    private int find(int[] map, int target) {
        for (int i = 1; i <= 3; i ++) {
            if (map[i] == target) {
                return i;
            }
        }
        return 0;
    }
}
