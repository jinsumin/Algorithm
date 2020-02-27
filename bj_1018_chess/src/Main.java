import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by REMI on 2020-01-09.
 */
public class Main {
    public static void main(String[] args){

    }
}

class Solution{
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n)){
                    return 1;
                }else if(o1.charAt(n) < o2.charAt(n)){
                    return -1;
                }else {
                    return o1.compareTo(o2);
                }
            }
        };
        Arrays.sort(strings, myComparator);
        return answer = strings;
    }
}