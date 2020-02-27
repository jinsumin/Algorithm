package sort_coordinates_11650;

import java.util.*;

/**
 * Created by REMI on 2020-01-29.
 */

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static class Pair {
        int left, right;
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    private static class MyComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.left > o2.left) {
                if(o1.right > o2.right) {
                    return 1;
                }else {
                    return -1;
                }
            }else if(o1.left < o2.left) {
                return -1;
            }else {
                return 0;
            }
        }
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            list.add(new Pair(left, right));
        }
        list.sort(new MyComparator());
        System.out.println(list);
    }
}
