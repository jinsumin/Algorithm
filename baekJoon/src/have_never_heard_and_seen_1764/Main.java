package have_never_heard_and_seen_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-05-13.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        String[] neverHeardNameList = new String[N];
        String[] neverSeenNameList = new String[M];
        for (int i = 0; i < N; i ++) {
            neverHeardNameList[i] = bufferedReader.readLine();
        }
        for (int i = 0; i < M; i ++) {
            neverSeenNameList[i] = bufferedReader.readLine();
        }
        Solution solution = new Solution();
        solution.solution(neverHeardNameList, neverSeenNameList);
    }
}

class Solution {
    public void solution(String[] neverHeardNameList, String[] neverSeenNameList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedList<String> answerList = new LinkedList<>();
        for (String s : neverHeardNameList) {
            hashMap.put(s, 1);
        }
        for (String s : neverSeenNameList) {
            if (hashMap.containsKey(s)) {
                answerList.offer(s);
            }
        }
        Collections.sort(answerList);
        int size = answerList.size();
        System.out.println(size);
        while (size > 0) {
            System.out.println(answerList.pollFirst());
            size--;
        }
    }
}
