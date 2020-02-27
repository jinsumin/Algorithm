package level2.representation_of_number;

/**
 * Created by REMI on 2020-01-13.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i < n / 2 + 1; i ++) {
            if(i % 2 == 1) {
                if(n % i == 0) { answer ++; }
            }else {
                if(n % i == 1) { answer ++; }
            }
        }
        return answer;
    }
}
