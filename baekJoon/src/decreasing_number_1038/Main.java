package decreasing_number_1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Crab on 2020-05-20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    private ArrayList<Long> arrayList = new ArrayList<>();

    public Long solution(int n) {
        for (int i = 0; i <= 9; i ++) {
            arrayList.add((long) i);
        }
        for (int i = 1; i <= 9; i ++) {
            int size = arrayList.size();
            for (int j = 0; j < size; j ++) {
                String firstNumber = String.valueOf(i);
                String number = firstNumber + String.valueOf(arrayList.get(j));
                if (i > Integer.parseInt(String.valueOf(String.valueOf(arrayList.get(j)).charAt(0)))) {
                    arrayList.add(Long.valueOf((number)));
                }
            }
            Collections.sort(arrayList);
            if ( arrayList.size() > 1022 ) {
                return arrayList.get(n);
            }
        }
        return (long) -1;
    }
}
