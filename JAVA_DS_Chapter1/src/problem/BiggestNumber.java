package problem;

import java.util.Arrays;
import java.util.Vector;

public class BiggestNumber {
    public static void main(String []args){
        String participant[] = {
                "leo", "kiki", "eden"
        };
        String completion[] = {
                "eden", "kiki"
        };
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(int i = 0; i < completion.length; i ++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }
}
