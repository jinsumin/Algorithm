package problem;

import java.util.*;

public class Solution {
    int capacity = 1;
    public int[] solution(int []arr) {
        int[] answer = new int[1];
        answer[0] = arr[0];
        for(int i = 1; i < arr.length; i ++){
            int index = answer.length;  // 1
            if(arr[i] != answer[index - 1]) {
                answer = addArrayLength(answer);
                answer[index] = arr[i];
            }
        }
        return answer;
    }

    public int[] addArrayLength(int[] answer){
        int[] temp = new int[capacity + 1];
        for(int i = 0; i < temp.length; i ++){
            temp[i] = answer[i];
        }
        capacity += 1;
        answer = temp;
        return answer;
    }
}
