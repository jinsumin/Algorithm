package hansoo_1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Crab on 2020-07-29.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Solution solution = new Solution();
        System.out.println(solution.solution(N));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isHanSoo(i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isHanSoo(int num) {
        int diff = 999;
        int prevNum = -1;
        while (num != 0) {
            int curNum = num % 10;
            if (prevNum != -1) {
                if (diff == 999) {
                    diff = curNum - prevNum;
                } else {
                    if (diff != curNum - prevNum) {
                        return false;
                    }
                }
            }
            prevNum = curNum;
            num /= 10;
        }
        return true;
    }
}
