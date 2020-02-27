package example3;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-29.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        System.out.println(sol.solution(x, y, w, h));
    }
}

class Solution {
    public int solution(int x, int y, int w, int h) {
        int temp1;
        if(w - x < x) {
            temp1 = w - x;
        } else {
            temp1 = x;
        }
        int temp2;
        if(h - y < y) {
            temp2 = h - y;
        }else {
            temp2 = y;
        }
        if(temp1 < temp2) {
            return temp1;
        } else {
            return temp2;
        }
    }
}