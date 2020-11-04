package level2.n_jin_game;

/**
 * Created by Crab on 2020-10-29.
 */
public class Main {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        Solution solution = new Solution();
        System.out.println(solution.solution(n, t, m, p));
    }
}

class Solution {
    private static final String[] ALPHABETS = {"A", "B", "C", "D", "E", "F"};

    public String solution(int n, int t, int m, int p) { // n진법, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        StringBuilder answer = new StringBuilder("");
        StringBuilder convertedString = new StringBuilder("0"); // 0부터 시작하기 때문에 0을 미리 넣어놓는다.
        int num = 1;
        while (convertedString.length() - 1 < t * m) { // 미리 구할 숫자의 갯수 * 인원의 길이까지 답이 나올만큼 반복한다.
            StringBuilder subBinarys = new StringBuilder("");
            int quot = num; // 몫
            int remain; // 나머지
            while (quot > 0) {
                remain = quot % n;
                quot = quot / n;

                if (remain >= 10 && remain <= 15) { // 알파벳으로 바꿔야 하는 경우
                    subBinarys.append(ALPHABETS[remain - 10]);
                } else {
                    subBinarys.append(remain);
                }
            }
            convertedString.append(subBinarys.reverse());
            num++;
        }
        int tubePlace = p;
        for (int i = 0; i < t; i++) {
            answer.append(convertedString.charAt(tubePlace - 1));
            tubePlace += m; // 튜브 차례
        }
        return answer.toString();
    }
}
