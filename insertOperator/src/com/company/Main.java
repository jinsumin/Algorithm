package com.company;

/**
 * Created by REMI on 2019-12-30.
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int countOfNumber = scanner.nextInt();
        int[] A = new int[countOfNumber];
        for(int i = 0; i < countOfNumber; i ++){
            A[i] = scanner.nextInt();
        }
        int[] kindOfOperator = new int[4];
        for(int i = 0; i < 4; i ++){
            kindOfOperator[i] = scanner.nextInt();
        }
        Solution sol = new Solution(kindOfOperator, A, countOfNumber);
        sol.solve(1, A[0]);
        sol.printMaxResult();
        sol.printMinResult();
    }
}

class Solution {
    private int[] kindOfOperator;
    private int[] A;
    private int countOfNumber;
    private ArrayList<Integer> list;

    public Solution(int[] kindOfOperator, int[] A, int countOfNumber) {
        this.kindOfOperator = kindOfOperator;
        this.A = A;
        this.countOfNumber = countOfNumber;
        list = new ArrayList<>();
    }

    public void solve(int index, int sum){
        for(int i = 0; i < 4; i ++){
            if(kindOfOperator[i] != 0){
                kindOfOperator[i] --;
                switch (i) {
                    case 0 :
                        solve(index + 1, sum + A[index]);
                        break;
                    case 1 :
                        solve(index + 1, sum - A[index]);
                        break;
                    case 2 :
                        solve(index + 1, sum * A[index]);
                        break;
                    case 3 :
                        solve(index + 1, sum / A[index]);
                        break;
                }
                kindOfOperator[i] ++;
            }
        }

        if(index == countOfNumber) {
            list.add(sum);
        }
    }

    public void printMaxResult() {
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

    public void printMinResult() {
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
