package problem1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Crab on 2020-03-29.
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}

class Solution {
    public int solution(int[] A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int value : A) {
            arrayList.add(value);
        }
        arrayList.sort(Collections.reverseOrder());
        int count = 1;
        int temp = arrayList.get(0);
        if (arrayList.get(0) == 1) {
            if (arrayList.size() == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        for (int i = 1; i < arrayList.size(); i ++) {
            if (arrayList.get(i) == 1) {
                if (i != arrayList.size() - 1) {
                    return 0;
                }
            }
            if (arrayList.get(i) > arrayList.size()) {
                continue;
            }
            if (arrayList.get(i) != temp) {
                temp = arrayList.get(i);
                count = 1;
                if(arrayList.get(i) == 1) {
                    if (arrayList.size() - 1 == i) {
                        return count;
                    }
                    return 0;
                }
            } else {
                if (arrayList.get(i) == 1) {
                    return count;
                }
                count++;
                if (count == arrayList.get(i)) {
                    if (i == arrayList.size() - 1) {
                        return count;
                    }
                    if (arrayList.get(i + 1) == temp) {
                        continue;
                    }
                    return count;
                }
            }
        }
        return 0;
    }
}
