package fast_sum_A_B_15552;

import java.io.*;

/**
 * Created by REMI on 2020-03-02.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testCase; t ++) {
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt((str[0]));
            int B = Integer.parseInt((str[1]));
            bw.write(String.valueOf(A + B));
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
