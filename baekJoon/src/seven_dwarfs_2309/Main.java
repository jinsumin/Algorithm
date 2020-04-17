package seven_dwarfs_2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 9; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arrayList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        Solution solution = new Solution();
        solution.solution(arrayList);
    }
}

class Solution {
    public void solution(ArrayList<Integer> arrayList) {
        Collections.sort(arrayList);
        boolean[] selected = new boolean[9];
        combination(arrayList, selected, 0, 9, 7);
    }

    private void combination(ArrayList<Integer> arrayList, boolean[] selected, int startIndex, int n, int r) {
        if (r == 0) {
            if (sumOfHeight(arrayList, selected) == 100) {
                printArrayList(arrayList, selected);
                System.exit(0);
            }
        }
        for (int i = startIndex; i < n; i ++) {
            selected[i] = true;
            combination(arrayList, selected, i + 1, n, r - 1);
            selected[i] = false;
        }
    }

    private int sumOfHeight(ArrayList<Integer> arrayList, boolean[] selected) {
        int sum = 0;
        for (int i = 0; i < 9; i ++) {
            if (selected[i]) {
                sum += arrayList.get(i);
            }
        }
        return sum;
    }

    private void printArrayList(ArrayList<Integer> arrayList, boolean[] selected) {
        for (int i = 0; i < 9; i ++) {
            if (selected[i]) {
                System.out.println(arrayList.get(i));
            }
        }
    }
}
