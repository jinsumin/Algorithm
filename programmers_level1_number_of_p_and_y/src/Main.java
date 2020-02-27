/**
 * Created by REMI on 2020-01-09.
 */
public class Main {
    public static void main(String[] args){

    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = countPrimeNumber(n);
        return answer;
    }

    public int countPrimeNumber(int n){
        int count = 0;
        for(int i = 2; i <= n; i ++){
            if(isPrimeNumber(i)) {
                count ++;
            }
        }
        return count;
    }

    private boolean isPrimeNumber(int n) {
        if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i ++){
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}