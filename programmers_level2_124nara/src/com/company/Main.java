package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Solution solve = new Solution();
    }
}

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int digit = 0;
        int[] nara = new int[1000];
        while(n != 0) {
            nara[digit++] = (n % 3);
            n = n / 3;
        }
        for(int i = 0; i < digit; i ++){
            if(nara[digit - i - 1] == 0){
                answer.append('1');
            }else if(nara[digit - i - 1] == 1){
                answer.append('2');
            }else if(nara[digit - i - 1] == 2){
                answer.append('4');
            }
        }
        return answer.toString();
    }
}