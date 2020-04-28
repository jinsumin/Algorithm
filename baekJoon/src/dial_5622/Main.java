package dial_5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Crab on 2020-04-28.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}

class Solution {
    private HashMap<Character, Integer> hashMap = new HashMap<>();

    public int solution(String input) {
        int answer = 0;
        hashMap.put('A', 3);
        hashMap.put('B', 3);
        hashMap.put('C', 3);
        hashMap.put('D', 4);
        hashMap.put('E', 4);
        hashMap.put('F', 4);
        hashMap.put('G', 5);
        hashMap.put('H', 5);
        hashMap.put('I', 5);
        hashMap.put('J', 6);
        hashMap.put('K', 6);
        hashMap.put('L', 6);
        hashMap.put('M', 7);
        hashMap.put('N', 7);
        hashMap.put('O', 7);
        hashMap.put('P', 8);
        hashMap.put('Q', 8);
        hashMap.put('R', 8);
        hashMap.put('S', 8);
        hashMap.put('T', 9);
        hashMap.put('U', 9);
        hashMap.put('V', 9);
        hashMap.put('W', 10);
        hashMap.put('X', 10);
        hashMap.put('Y', 10);
        hashMap.put('Z', 10);
        for (int i = 0; i < input.length(); i ++) {
            answer += hashMap.get(input.charAt(i));
        }
        return answer;
    }
}
