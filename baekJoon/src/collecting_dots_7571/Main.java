package collecting_dots_7571;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-06-25.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        Dot[] dots = new Dot[m];
        int maxR = 0;
        int minR = Integer.MAX_VALUE;
        int maxC = 0;
        int minC = Integer.MAX_VALUE;
        int sumOfR = 0, sumOfC = 0;
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            dots[i] = new Dot(r, c);
            if (dots[i].r > maxR) {
                maxR = dots[i].r;
            }
            if (dots[i].r < minR) {
                minR = dots[i].r;
            }
            if (dots[i].c > maxC) {
                maxC = dots[i].c;
            }
            if (dots[i].c < minC) {
                minC = dots[i].c;
            }
            sumOfR += r;
            sumOfC += c;
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(n, m, dots, maxR, minR, maxC, minC, sumOfR, sumOfC));
    }
}

class Dot {
    int r, c;

    public Dot(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    private static int minOfTotalDistance = Integer.MAX_VALUE;

    public int solution(int n, int m, Dot[] dots, int maxR, int minR, int maxC, int minC, int sumOfR, int sumOfC) {
        ArrayList<Integer> rowList = new ArrayList<>();
        ArrayList<Integer> colList = new ArrayList<>();
        for (int i = 0; i < m; i ++) {
            rowList.add(dots[i].r);
            colList.add(dots[i].c);
        }
        Collections.sort(rowList);
        Collections.sort(colList);
        int targetR,targetC;
        targetR = rowList.get(rowList.size() / 2);
        targetC = colList.get(colList.size() / 2);
        int totalDistance = 0;
        for (int i = 0; i < m; i ++) {
            totalDistance += Math.abs(dots[i].r - targetR) + Math.abs(dots[i].c - targetC);
        }
        return minOfTotalDistance = totalDistance;
    }
}
