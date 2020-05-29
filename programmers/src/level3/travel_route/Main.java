package level3.travel_route;

import java.util.*;

/**
 * Created by Crab on 2020-05-28.
 */
public class Main {
    public static void main(String[] args) {
        String[][] tickets = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" }, { "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(tickets)));
    }
}

class Solution {
    private static ArrayList<String> arrayList = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer;
        String route = "";
        for (int i = 0; i < tickets.length; i ++) {
            boolean[] visited = new boolean[tickets.length];
            dfs(tickets, visited, i, route);
        }
        Collections.sort(arrayList);
        System.out.println(arrayList);
        answer = new String[tickets.length + 1];
        String answerString = arrayList.get(0);
        int index = 0;
        for (int i = 0 ; i < answer.length; i ++) {
            answer[i] = answerString.substring(index, index + 3);
            index += 3;
        }
        return answer;
    }

    private void dfs(String[][] tickets, boolean[] visited, int index, String route) {
        if (isAllVisited(visited)) {
            if (route.length() >= (tickets.length + 1) * 3) {
                arrayList.add(String.valueOf(route));
            }
            return;
        }
        if (!visited[index]) {
            if (route.length() < 1) {
                route += (tickets[index][0]) + (tickets[index][1]);
                for (int i = 0; i < tickets.length; i ++) {
                    visited[index] = true;
                    dfs(tickets, visited, i, route);
                }
            } else {
                if (route.substring(0, 3).equals(tickets[index][1])) {
                    route = (tickets[index][0] + route);
                    for (int i = 0; i < tickets.length; i ++) {
                        visited[index] = true;
                        dfs(tickets, visited, i, route);
                    }
                } else if (route.substring(route.length() - 3).equals(tickets[index][0])) {
                    route += (tickets[index][1]);
                    for (int i = 0; i < tickets.length; i ++) {
                        visited[index] = true;
                        dfs(tickets, visited, i, route);
                    }
                }
            }
        }
    }

    private boolean isAllVisited(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
