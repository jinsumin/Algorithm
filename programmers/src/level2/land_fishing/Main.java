package land_fishing;

/**
 * Created by Crab on 2020-11-09.
 */
public class Main {
    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(land));
    }
}

class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
            land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
            land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }
        return Math.max(Math.max(Math.max(land[land.length - 1][0], land[land.length - 1][1]), land[land.length - 1][2]), land[land.length - 1][3]);
    }
}
