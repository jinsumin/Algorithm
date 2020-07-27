package arrange_numbers_3_10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Crab on 2020-07-27.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i ++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Solution solution = new Solution();
        solution.solution(array);
    }
}

class Solution {
    public void solution(int[] array) {
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }

    private void quickSort(int[] array, int start, int end) {
        int pivot = partition(array, start, end);
        if(start < pivot - 1) {
            quickSort(array, start, pivot - 1);
        }
        if(pivot < end) {
            quickSort(array, pivot, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        while (start <= end) {
            while (array[start] < pivot) {
                start++;
            }
            while (array[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }

    private void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int value : array) {
            stringBuilder.append(value).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
