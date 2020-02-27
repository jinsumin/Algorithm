package picture_compare_2160;

import java.util.*;

/**
 * Created by REMI on 2020-02-06.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][][] map = new char[n][5][7];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < 5; j ++) {
                for(int k = 0; k < 7; k ++) {
                    map[i][j][k] = scanner.next().charAt(0);
                }
            }
        }
        Solution sol = new Solution();
        sol.solution(map);
        sol.printMinDiffPicture();
    }
}

class Solution {
    public class Compare {
        int leftPicture, rightPicture;
        int diff;

        public Compare(int leftPicture, int rightPicture, int diff) {
            this.leftPicture = leftPicture;
            this.rightPicture = rightPicture;
            this.diff = diff;
        }
    }

    List<Compare> list = new LinkedList<>();

    public void solution(char[][][] map) {
        boolean[] visited = new boolean[map.length];
        combination(map, visited, 0, map.length, 2);
        Collections.sort(list, new Comparator<Compare>() {
            @Override
            public int compare(Compare o1, Compare o2) {
                if (o1.diff > o2.diff) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    public void combination(char[][][] map, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            countDiff(map, visited, n);
            return;
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(map, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    private void countDiff(char[][][] map, boolean[] visited, int n) {
        int leftPicture = 0;
        int rightPicture = 0;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                leftPicture = i;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (visited[i]) {
                rightPicture = i;
            }
        }
        for (int i = 0; i < map[i].length; i++) {
            for (int j = 0; j < map[i][j].length; j++) {
                if (map[leftPicture][i][j] != map[rightPicture][i][j]) {
                    diff++;
                }
            }
        }
        list.add(new Compare(leftPicture, rightPicture, diff));
    }

    public void printMinDiffPicture() {
        System.out.println(list.get(0).leftPicture + " " + list.get(0).rightPicture);
    }
}
