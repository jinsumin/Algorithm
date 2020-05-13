package deduplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-13.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        boolean[] A = new boolean[33554432];
        while (stringTokenizer.hasMoreTokens()) {
            int input = Integer.parseInt(stringTokenizer.nextToken());
            if (!A[input]) {
                System.out.print(input + " ");
                A[input] = true;
            }
        }
    }
}
