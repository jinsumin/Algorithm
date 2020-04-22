package exam_supervisor_13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-22.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] sites = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            sites[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int generalSupervisor = Integer.parseInt(stringTokenizer.nextToken());
        int deputySupervisor = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(sites, generalSupervisor, deputySupervisor));
    }
}

class Solution {
    public long solution(int[] sites, int generalSupervisor, int deputySupervisor) {
        long answer = 0;
        for (int i = 0; i < sites.length; i++) {
            sites[i] -= generalSupervisor;
            answer++;
            if (sites[i] > 0) {
                answer += (sites[i] / deputySupervisor);
                if (sites[i] % deputySupervisor != 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
