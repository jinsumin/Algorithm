package level3.express_to_N;

import java.util.ArrayList;

/**
 * Created by Crab on 2020-11-12.
 */
public class Main {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        Solution solution = new Solution();
        System.out.println(solution.solution(N, number));
    }
}

class Solution {
    public int solution(int N, int number) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        int serialNumber = 0;
        int prevSize = arrayList.size();
        for (int i = 1; i <= 8; i++) {
            serialNumber += Math.pow(10, i - 1) * N;
            System.out.println(serialNumber);
            arrayList.add(serialNumber);
            System.out.println(arrayList);
            int currentSize = arrayList.size();
            for (int j = prevSize; j < currentSize; j ++) {
                int temp = arrayList.get(j);
                if (temp == number) {
                    return i;
                }
                arrayList.add(temp + N);
                arrayList.add(temp - N);
                arrayList.add(temp * N);
                arrayList.add(temp / N);
            }
            prevSize = currentSize;
        }
        return -1;
    }
}
