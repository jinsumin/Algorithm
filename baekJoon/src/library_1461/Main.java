package library_1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-30.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<Integer> positiveNumbers = new ArrayList<>();
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i ++) {
            int position = Integer.parseInt(stringTokenizer.nextToken());
            if (position > 0) {
                positiveNumbers.add(position);
            } else {
                negativeNumbers.add(-position);
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(positiveNumbers, negativeNumbers, M));
    }
}

class Solution {
    public int solution(ArrayList<Integer> inputPositiveNumbers, ArrayList<Integer> inputNegativeNumbers, int m) {
        int answer = 0;
        Collections.sort(inputPositiveNumbers);
        Collections.sort(inputNegativeNumbers);
        //System.out.println(inputPositiveNumbers);
        //System.out.println(inputNegativeNumbers);
        LinkedList<Integer> positiveNumbers = new LinkedList<>();
        LinkedList<Integer> negativeNumbers = new LinkedList<>();
        int sizeInputA = inputPositiveNumbers.size();
        int sizeInputB = inputNegativeNumbers.size();
        for (int i = sizeInputA - 1; i >= 0; i -= m) {
            positiveNumbers.offerFirst(inputPositiveNumbers.get(i));
        }
        for (int i = sizeInputB - 1; i >= 0; i -= m) {
            negativeNumbers.offerFirst(inputNegativeNumbers.get(i));
        }
        //System.out.println(positiveNumbers);
        //System.out.println(negativeNumbers);
        int lastReturnedMoved = 0;
        if (positiveNumbers.size() > 0) {
            if (positiveNumbers.getLast() > lastReturnedMoved) {
                lastReturnedMoved = positiveNumbers.getLast();
            }
        }
        if (negativeNumbers.size() > 0) {
            if (negativeNumbers.getLast() > lastReturnedMoved) {
                lastReturnedMoved = negativeNumbers.getLast();
            }
        }
        while (!positiveNumbers.isEmpty() || !negativeNumbers.isEmpty()) {
            int compareA = Integer.MAX_VALUE, compareB = Integer.MAX_VALUE;
            if (!positiveNumbers.isEmpty()) {
                compareA = positiveNumbers.getFirst();
            }
            if (!negativeNumbers.isEmpty()) {
                compareB = negativeNumbers.getFirst();
            }
            //System.out.println("compareA : " + compareA);
            //System.out.println("compareB : " + compareB);
            if (compareA < compareB) {
                answer += (compareA * 2);
                positiveNumbers.pollFirst();
            } else {
                answer += (compareB * 2);
                negativeNumbers.pollFirst();
            }
            //System.out.println(positiveNumbers);
            //System.out.println(negativeNumbers);
            //System.out.println("answer : " + (answer - lastReturnedMoved));
        }
        return answer - lastReturnedMoved;
    }
}
