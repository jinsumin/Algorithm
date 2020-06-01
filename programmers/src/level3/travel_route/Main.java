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
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        return answer;
    }
}