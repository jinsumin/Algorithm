package level3.most_biggest_number;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by REMI on 2020-01-20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for(int i = 0; i < 5; i ++){
            numbers[i] = scanner.nextInt();
        }
        Solution sol = new Solution();
        System.out.println(sol.solution(numbers));
    }
}
/*

class Solution {
    private static boolean[] visited;
    private static int max;
    private static LinkedList<Integer> list = new LinkedList<>();
    public String solution(int[] numbers) {
        visited = new boolean[numbers.length];
        permutation(numbers, visited, 0, numbers.length, numbers.length);
        return Integer.toString(max);
    }

    private void permutation(int[] numbers, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            StringBuilder result = new StringBuilder();
            for(Integer num : list) {
                result.append(num);
            }
            if(Integer.parseInt(result.toString()) > max) {
                max = Integer.parseInt(result.toString());
            }
            return;
        }

        for(int i = 0; i < n; i ++) {
            if(!visited[i]) {
                list.add(numbers[i]);
                visited[i] = true;
                permutation(numbers, visited, depth + 1, n, r);
                visited[i] = false;
                list.removeLast();
            }
        }
    }
}
*/

class Solution {
    private static List<Integer> list = new ArrayList<>();

    public String solution(int[] numbers) {
        String answer = "";
        for (int number : numbers) {
            list.add(number);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String as = String.valueOf(o1);
                String bs = String.valueOf(o2);
                if (Integer.parseInt(as + bs) > Integer.parseInt(bs + as)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
}
