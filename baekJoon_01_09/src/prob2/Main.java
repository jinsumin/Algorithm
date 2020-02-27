package prob2;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-09.
 * 비트 우정지수
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCase = scanner.nextInt();
        Solution[] sol = new Solution[numberOfTestCase];
        for(int i = 0; i < numberOfTestCase; i ++){
            sol[i] = new Solution();
            System.out.println(sol[i].solution(scanner.next(), scanner.next()));
        }
    }
}

class Solution{
    public int solution(String N, String M){
        int countOfOne = 0;
        int countOfZero = 0;
        int countFriendShip = 0;
        for(int i = 0; i < N.length(); i ++){
            if(N.charAt(i) != M.charAt(i)) {
                countFriendShip ++;
                if(N.charAt(i) == '0') { countOfZero ++; }
                if(N.charAt(i) == '1') { countOfOne ++; }
            }
        }
        countFriendShip -= Math.min(countOfOne, countOfZero);
        return countFriendShip;
    }
}
