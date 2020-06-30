package stand_in_one_line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-06-30.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int numberOfPeoples = Integer.parseInt(bufferedReader.readLine());
        People[] peoples = new People[numberOfPeoples];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < numberOfPeoples; i++) {
            int countOfLeft = Integer.parseInt(stringTokenizer.nextToken());
            peoples[i] = new People(i + 1, countOfLeft);
        }
        Solution solution = new Solution();
        solution.solution(numberOfPeoples, peoples);
    }
}

class People {
    int height;
    int countOfLeft;

    public People(int height, int countOfLeft) {
        this.height = height;
        this.countOfLeft = countOfLeft;
    }
}

class Solution {
    public void solution(int numberOfPeoples, People[] peoples) {
        int[] memo = new int[numberOfPeoples];
        ArrayList<People> arrayList = new ArrayList<>();
        for (int i = 0; i < numberOfPeoples; i++) {
            arrayList.add(peoples[i]);
        }
    }
}
