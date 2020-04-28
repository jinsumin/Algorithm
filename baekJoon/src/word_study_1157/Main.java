package word_study_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-04-28.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(word));
    }
}

class Solution {
    public char solution(String word) {
        word = word.toUpperCase();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < word.length(); i ++) {
            if (hashMap.containsKey(word.charAt(i))) {
                hashMap.put(word.charAt(i), hashMap.get(word.charAt(i)) + 1);
            } else {
                hashMap.put(word.charAt(i), 1);
            }
        }
        LinkedList<Map.Entry<Character, Integer>> list = new LinkedList<>(hashMap.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        if (list.size() > 1) {
            if (list.get(0).getValue().equals(list.get(1).getValue())) {
                return '?';
            } else {
                return list.get(0).getKey();
            }
        } else {
            return list.get(0).getKey();
        }
    }
}
