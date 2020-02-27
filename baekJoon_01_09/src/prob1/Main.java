package prob1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by REMI on 2020-01-09.
 * 원피스
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String H = scanner.next();
        String N = scanner.next();
        Solution solve = new Solution();
        System.out.println(solve.solution(H, N));
    }
}

class Solution{
    public int solution(String H, String N){
        int count = 0;
        Pattern pattern = Pattern.compile(N);
        Matcher matcher = pattern.matcher(H);
        while(matcher.find()){
            count ++;
        }
        return count;
    }
}
