package level1.x_distance_number_of_n;

/**
 * Created by REMI on 2020-01-09.
 */
public class Main {
    public static void main(String[] args){

    }
}

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        answer = new long[n];
        answer[0] = x;
        for(int i = 1; i < n; i ++){
            answer[i] = answer[i - 1] + x;
        }
        return answer;
    }
}