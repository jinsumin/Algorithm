package movie_director_shom_1436;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        int count = 0;
        for (int number = 666; number < Integer.MAX_VALUE; number ++) {
            if (isShomeNumber(number)) {
                count ++;
            }
            if (count == n) {
                return number;
            }
        }
        return -1;
    }

    private boolean isShomeNumber(int number) {
        int count = 0;
        while (number > 0) {
            if (number % 10 == 6) {
                count ++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
