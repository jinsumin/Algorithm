package find_number_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] array = new int[n + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[] targetNumbers = new int[m + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= m; i++) {
            targetNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Solution solution = new Solution();
        solution.solution(array, targetNumbers);
    }
}

class Solution {
    public void solution(int[] array, int[] targetNumbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        Collections.sort(arrayList);
        for (int i = 1; i < targetNumbers.length; i++) {
            if (binarySearch(arrayList, targetNumbers[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private boolean binarySearch(ArrayList<Integer> arrayList, int targetNumber) {
        int leftIndex = 0;
        int rightIndex = arrayList.size() - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (arrayList.get(midIndex) == targetNumber) {
                return true;
            } else if (arrayList.get(midIndex) < targetNumber) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        return false;
    }
}
