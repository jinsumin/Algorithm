package IOIOI_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by REMI on 2020-02-25.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Solution solution = new Solution();
        System.out.println(solution.solution(n, m, str));
    }
}

class Solution {
    public int solution(int n, int m, String str) {
        int result = 0;
        int patternCount = 0;
        for(int i = 1; i < m - 1; i ++) {
            if(str.charAt(i - 1) == 'I' && str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                patternCount ++;
                if(patternCount == n) {
                    patternCount --;
                    result ++;
                }
                i ++;
            } else {
                patternCount = 0;
            }
        }
        return result;
    }
}
