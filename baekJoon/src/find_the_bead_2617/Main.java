package find_the_bead_2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-06-01.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<Integer>[] moreLightLists = new ArrayList[N + 1];
        ArrayList<Integer>[] moreHeavyLists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            moreLightLists[i] = new ArrayList<>();
            moreHeavyLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int lightBead = Integer.parseInt(stringTokenizer.nextToken());
            int heavyBead = Integer.parseInt(stringTokenizer.nextToken());
            moreHeavyLists[lightBead].add(heavyBead);
            moreLightLists[heavyBead].add(lightBead);
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(N, moreLightLists, moreHeavyLists));
    }
}

class Solution {
    public int solution(int n, ArrayList<Integer>[] moreLightLists, ArrayList<Integer>[] moreHeavyLists) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] visitedLightLists = new boolean[moreLightLists.length];
            boolean[] visitedHeavyLists = new boolean[moreHeavyLists.length];
            if (dfsLightLists(moreLightLists, visitedLightLists, i) >= ((n + 1) / 2)
                    || dfsHeavyLists(moreHeavyLists, visitedHeavyLists, i) >= ((n + 1) / 2)) {
                answer++;
            }
        }
        return answer;
    }

    private int dfsLightLists(ArrayList<Integer>[] moreLightLists, boolean[] visitedLightLists, int startIndex) {
        int distance = 0;
        for (int i = 0; i < moreLightLists[startIndex].size(); i++) {
            if (!visitedLightLists[moreLightLists[startIndex].get(i)]) {
                visitedLightLists[moreLightLists[startIndex].get(i)] = true;
                distance += (dfsLightLists(moreLightLists, visitedLightLists, moreLightLists[startIndex].get(i)) + 1);
            }
        }
        return distance;
    }

    private int dfsHeavyLists(ArrayList<Integer>[] moreHeavyLists, boolean[] visitedHeavyLists, int startIndex) {
        int distance = 0;
        for (int i = 0; i < moreHeavyLists[startIndex].size(); i++) {
            if (!visitedHeavyLists[moreHeavyLists[startIndex].get(i)]) {
                visitedHeavyLists[moreHeavyLists[startIndex].get(i)] = true;
                distance += (dfsHeavyLists(moreHeavyLists, visitedHeavyLists, moreHeavyLists[startIndex].get(i)) + 1);
            }
        }
        return distance;
    }
}
