package electric_wire_2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int number = Integer.parseInt(stringTokenizer.nextToken());
        int[] poleA = new int[501];
        int[] poleB = new int[501];
        int maxA = 0, maxB = 0;
        for (int i = 0; i < number; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int lineA = Integer.parseInt(stringTokenizer.nextToken());
            int lineB = Integer.parseInt(stringTokenizer.nextToken());
            if (lineA > maxA) {
                maxA = lineA;
            }
            if (lineB > maxB) {
                maxB = lineB;
            }
            poleA[lineA] = lineB;
            poleB[lineB] = lineA;
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(poleA, poleB, number, maxA, maxB));
    }
}

class Solution {
    private int max = 0;

    public int solution(int[] poleA, int[] poleB, int number, int lengthA, int lengthB) {
        for (int i = 1; i <= lengthA; i++) {
            findWay(poleA, poleB, i, lengthA);
        }
        for (int i = 1; i <= lengthB; i++) {
            findWay(poleB, poleA, i, lengthB);
        }
        return number - max;
    }

    private void findWay(int[] poleA, int[] poleB, int startIndex, int length) {
        int count = 0;
        int indexA = startIndex;
        int indexB = 1;
        for (int i = indexA; i <= length; i++) {
            if (poleA[i] != 0) {
                if (poleA[i] >= indexB) {
                    indexB = poleA[i];
                    count++;
                    for (int j = indexB + 1; j <= length; j++) {
                        if (poleB[j] >= indexA) {
                            indexA = poleB[j];
                            i = indexA + 1;
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        if (count > max) {
            max = count;
        }
    }
}
