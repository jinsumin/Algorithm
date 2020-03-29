package problem3;

import java.util.ArrayList;

/**
 * Created by Crab on 2020-03-29.
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}

class Solution {
    public int solution(int[] A) {
        int answer = 0;
        if (check(A, 0, 0)) {
            return 0;
        } else {
            for (int i = 0; i < A.length; i++) {
                if (check(A, i, 1)) {
                    //System.out.println("i : " + i);
                    answer ++;
                }
            }
        }
        if (answer == 0) {
            return -1;
        } else {
            return answer;
        }
    }

    private boolean check(int[] a, int index, int t) {
        if (t == 0) {
            int state = 0;
            for(int i = 1; i < a.length; i ++) {
                if(state == 0) {
                    if(a[i - 1] < a[i]) {
                        state = 1;
                    } else if (a[i - 1] > a[i]){
                        state = -1;
                    } else {
                        return false;
                    }
                } else {
                    if (state == 1) {
                        if (a[i - 1] <= a[i]) {
                            return false;
                        } else {
                            state = -1;
                        }
                    } else {
                        if (a[i - 1] >= a[i]) {
                            return false;
                        } else {
                            state = 1;
                        }
                    }
                }
            }
            return true;
        } else {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < a.length; i ++) {
                if (i == index) {
                    continue;
                }
                arrayList.add(a[i]);
            }
            int state = 0;
            for(int i = 1; i < arrayList.size(); i ++) {
                if(state == 0) {
                    if(arrayList.get(i - 1) < arrayList.get(i)) {
                        state = 1;
                    } else if (arrayList.get(i - 1) > arrayList.get(i)){
                        state = -1;
                    } else {
                        return false;
                    }
                } else {
                    if (state == 1) {
                        if (arrayList.get(i - 1) <= arrayList.get(i)) {
                            return false;
                        } else {
                            state = -1;
                        }
                    } else {
                        if (arrayList.get(i - 1) >= arrayList.get(i)) {
                            return false;
                        } else {
                            state = 1;
                        }
                    }
                }
            }
            return true;
        }
    }
}
