package level1.hasard_number;

/**
 * Created by REMI on 2020-01-09.
 */
public class Main {
    public static void main(String[] args){

    }
}

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        return answer = isHasard(x);
    }

    private boolean isHasard(int x) {
        int temp = x;
        int sumOfDigits = 0;
        while(temp > 0){
            sumOfDigits += temp % 10;
            temp /= 10;
        }
        return x % sumOfDigits == 0;
    }
}