package friend_1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfPeople = Integer.parseInt(stringTokenizer.nextToken());
        LinkedList<Integer>[] linkedLists = new LinkedList[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            linkedLists[i] = new LinkedList<>();
        }
        for (int i = 0; i < numberOfPeople; i++) {
            String relationShip = bufferedReader.readLine();
            for (int j = 0; j < numberOfPeople; j++) {
                if (relationShip.charAt(j) == 'Y') {
                    linkedLists[i].add(j);
                }
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(linkedLists));
    }
}

class Solution {
    public int solution(LinkedList<Integer>[] linkedLists) {
        int max = 0;
        for (int i = 0; i < linkedLists.length; i++) {
            boolean[] visited = new boolean[linkedLists.length];
            int relationShipCount = calculateRelationShip(linkedLists, visited, i);
            if (relationShipCount > max) {
                max = relationShipCount;
            }
        }
        return max;
    }

    private int calculateRelationShip(LinkedList<Integer>[] linkedLists, boolean[] visited, int start) {
        int count = 0;
        visited[start] = true;
        for (int i = 0; i < linkedLists[start].size(); i ++) {
            if (!visited[linkedLists[start].get(i)]) {
                visited[linkedLists[start].get(i)] = true;
                count++;
            }
            for (int j = 0; j < linkedLists[linkedLists[start].get(i)].size(); j ++) {
                int nextFriend = linkedLists[linkedLists[start].get(i)].get(j);
                if (!visited[nextFriend]) {
                    visited[nextFriend] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
