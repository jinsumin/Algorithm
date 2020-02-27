package level2.make_min_sum;

import java.util.*;

/**
 * Created by REMI on 2020-02-05.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution
{
    public int solution(int []A, int []B) {
        int answer = 0;
        List<Integer> tempA = new ArrayList<>();
        List<Integer> tempB = new ArrayList<>();
        for(int i = 0; i < A.length; i ++) {
            tempA.add(A[i]);
            tempB.add(B[i]);
        }
        Collections.sort(tempA);
        Collections.sort(tempB, Collections.reverseOrder());
        Iterator iteratorA = tempA.iterator();
        Iterator iteratorB = tempB.iterator();
        while(iteratorA.hasNext()) {
            int elementA = (int) iteratorA.next();
            int elementB = (int) iteratorB.next();
            answer += elementA * elementB;
        }
        return answer;
    }
}
