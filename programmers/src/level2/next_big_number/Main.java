package next_big_number;

/**
 * Created by Crab on 2020-11-06.
 */
public class Main {
    public static void main(String[] args) {
        int n = 78;
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        int compareN = n + 1;
        while (!isSameCountOfOne(n, compareN)) {
            compareN++;
        }
        answer = compareN;
        return answer;
    }

    private boolean isSameCountOfOne(int n, int compareN) {
        String binaryN = Integer.toBinaryString(n);
        String binaryComparedN = Integer.toBinaryString(compareN);
        int countOneOfN = 0, countOneOfComparedN = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') {
                countOneOfN++;
            }
        }
        for (int i = 0; i < binaryComparedN.length(); i++) {
            if (binaryComparedN.charAt(i) == '1') {
                countOneOfComparedN++;
            }
        }
        return countOneOfN == countOneOfComparedN;
    }
}
