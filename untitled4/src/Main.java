
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-09.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numberOfCTP = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        Integer[] A = new Integer[numberOfCTP];
        for(int i = 0; i < numberOfCTP; i ++){
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A, Collections.reverseOrder());
        Solution sol = new Solution();
        int res = sol.solution(M, K, A);
        if(res == -1){
            System.out.println("STRESS");
        }else{
            System.out.println(sol.solution(M, K, A));
        }
    }
}

class Solution{
    public int solution(int M, int K, Integer[] A){
        int sum = M * K;
        int temp = 0;
        for(int i = 0; i < A.length; i ++){
            temp += A[i];
            if(temp >= sum) {
                return i + 1;
            }
        }
        return -1;
    }
}
