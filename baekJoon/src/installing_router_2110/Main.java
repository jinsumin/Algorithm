package installing_router_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfHomes = Integer.parseInt(stringTokenizer.nextToken());
        int numberOfRouters = Integer.parseInt(stringTokenizer.nextToken());
        int[] homes = new int[numberOfHomes];
        for (int i = 0; i < numberOfHomes; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            homes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(homes, numberOfRouters));
    }
}

class Solution {
    public int solution(int[] homes, int numberOfRouters) {
        int answer = 0;

        return answer;
    }
}
