package triangle_snail;

import java.util.Arrays;

/**
 * Created by Crab on 2020-11-04.
 */
public class Main {
    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(n)));
    }
}

class Solution {
    private static final int[] MOVE_R = {1, 0, -1};
    private static final int[] MOVE_C = {0, 1, -1};

    public int[] solution(int n) {
        int[] answer = new int[(n + 1) * n / 2];
        int[][] map = new int[n + 1][n + 1];
        int r = 0, c = 0;
        int number = 1;
        int index = 0;
        for (int times = n; times >= 1; times --) {
            for(int direction = 0; direction < times; direction ++) {
                r += MOVE_R[index];
                c += MOVE_C[index];
                map[r][c] = number++;
            }
            index++;
            index = index % 3;
        }
        //System.out.println(Arrays.deepToString(map));
        int indexOfAnswer = 0;
        for (int i = 0; i < n + 1; i ++) {
            for (int j = 0; j < n + 1; j ++) {
                if (map[i][j] != 0) {
                    answer[indexOfAnswer++] = map[i][j];
                }
            }
        }
        return answer;
    }
}
