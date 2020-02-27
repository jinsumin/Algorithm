package level2.english_ending;

/**
 * Created by REMI on 2020-01-09.
 */
public class Main {
    public static void main(String[] args){

    }
}

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        answer = new int[2];
        for(int i = 0; i < words.length; i ++){
            for(int j = i + 1; j < words.length; j ++){
                if(words[i].equals(words[j])){
                    answer[0] = (j + 1) % n;
                    answer[1] = (j + 1) / n;
                    return answer;
                }
            }
        }
        return answer;
    }
}
