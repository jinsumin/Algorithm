package sortSequence_1015;

import java.util.*;

/**
 * Created by REMI on 2020-01-12.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public void solution() {
        int N = scanner.nextInt();
        Map<Integer, Integer> A = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            A.put(scanner.nextInt(), i);
        }
//        final List<Map.Entry<Integer, Integer>> data = new ArrayList<>(A.entrySet());
//        data.sort((o1, o2) -> o1.getValue() > o2.getValue() ? 1 : -1);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : A.entrySet()) {
            System.out.println(integerIntegerEntry);
        }
    }
}
