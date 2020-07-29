package treasure_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-07-27.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arrayA = new int[N];
        int[] arrayB = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i ++) {
            arrayA[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i ++) {
            arrayB[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(arrayA, arrayB));
    }
}

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        answer = calculateAnswer(arrayA, arrayB);
        return answer;
    }

    private int calculateAnswer(int[] arrayA, int[] arrayB) {
        int answer = 0;
        for (int i = 0; i < arrayA.length; i ++) {
            answer += arrayA[i] * arrayB[arrayB.length - 1 - i];
        }
        return answer;
    }
}
