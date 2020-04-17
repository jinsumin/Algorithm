package stark_and_link_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }
}

class Solution {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public int solution(int[][] map) {
        for (int i = 0; i < map.length; i ++) {
            for (int j = 0; j < map.length; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        boolean[] selected = new boolean[map.length];
        combination(map, selected, 0, map.length, map.length / 2);
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i ++) {
            System.out.println(arrayList.get(i));
        }
        return arrayList.get(0);
    }

    private void combination(int[][] map, boolean[] selected, int startIndex, int n, int r) {
        if (r == 0) {
            int teamA = 0, teamB = 0;
            for (int i = 0; i < n; i ++) {
                if (selected[i]) {
                    for (int j = 0; j < n; j ++) {
                        if (selected[j]) {
                            teamA += map[i][j] + map[j][i];
                        }
                    }
                } else {
                    for (int j = 0; j < n; j ++) {
                        if (!selected[j]) {
                            teamB += map[i][j] + map[j][i];
                        }
                    }
                }
            }
            arrayList.add(Math.abs(teamA - teamB) / 2);
            return;
        }
        for (int i = startIndex; i < n; i ++) {
            selected[i] = true;
            combination(map, selected, i + 1, n, r - 1);
            selected[i] = false;
        }
    }
}
