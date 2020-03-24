package stick_17608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-19.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int numberOfSticks = Integer.parseInt(stringTokenizer.nextToken());
        int[] heightsOfSticks = new int[numberOfSticks];
        for(int i = 0; i < numberOfSticks; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            heightsOfSticks[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Solution solution = new Solution();
        System.out.println(solution.solution(heightsOfSticks, numberOfSticks));
    }
}

class Solution {
    public int solution(int[] heightsOfSticks, int numberOfSticks) {
        int answer = 1;
        int min = heightsOfSticks[numberOfSticks - 1];
        for(int i = numberOfSticks - 1; i >= 0 ; i --) {
            if(min < heightsOfSticks[i]) {
                answer++;
                min = heightsOfSticks[i];
            }
        }
        return answer;
    }
}
