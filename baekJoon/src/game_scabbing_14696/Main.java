package game_scabbing_14696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-19.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int numberOfRounds = Integer.parseInt(stringTokenizer.nextToken());
        for(int t = 1; t <= numberOfRounds; t ++) {
            int[] A = new int[6];
            int[] B = new int[6];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stringTokenizer.nextToken();
            while(stringTokenizer.hasMoreTokens()) {
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                //System.out.print(temp + ", ");
                A[temp] ++;
            }
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stringTokenizer.nextToken();
            while(stringTokenizer.hasMoreTokens()) {
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                //System.out.print(temp + ", ");
                B[temp] ++;
            }
            boolean flag = false;
            for(int index = 5; index >= 1; index --) {
                if(A[index] == B[index]) {
                    if(index == 1) {
                        flag = true;
                    }
                    continue;
                }
                if(A[index] > B[index]) {
                    System.out.println("A");
                    break;
                }
                if(A[index] < B[index]) {
                    System.out.println("B");
                    break;
                }
            }
            if(flag) {
                System.out.println("D");
            }
        }
    }
}
