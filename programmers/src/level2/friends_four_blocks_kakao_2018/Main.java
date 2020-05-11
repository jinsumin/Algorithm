package level2.friends_four_blocks_kakao_2018;

import java.util.ArrayList;

/**
 * Created by Crab on 2020-05-05.
 */
public class Main {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(m, n, board));
    }
}

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        ArrayList<Node>[] arrayLists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arrayLists[i] = new ArrayList();
        }
        int k = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                arrayLists[k % n].add(new Node(board[i].charAt(j), false));
                k++;
            }
        }
        while (true) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < arrayLists[i].size() - 1; j++) {
                    char temp = arrayLists[i].get(j).getAlphabet();
                    if (temp == '0') {
                        continue;
                    }
                    if (temp == arrayLists[i].get(j + 1).getAlphabet() &&
                            temp == arrayLists[i + 1].get(j).getAlphabet() &&
                            temp == arrayLists[i + 1].get(j + 1).getAlphabet()) {
                        arrayLists[i].get(j).setChecked(true);
                        arrayLists[i].get(j + 1).setChecked(true);
                        arrayLists[i + 1].get(j).setChecked(true);
                        arrayLists[i + 1].get(j + 1).setChecked(true);
                    }
                }
            }
            boolean flag = true;
            for (int i = n - 1; i >= 0; i --) {
                for (int j = m - 1; j >= 0; j --) {
                    if (arrayLists[i].get(j).isChecked()) {
                        arrayLists[i].remove(j);
                        arrayLists[i].add(new Node('0', false));
                        flag = false;
                        answer ++;
                    }
                }
            }
            if (flag) {
                break;
            }
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < m; j ++) {
                    arrayLists[i].get(j).setChecked(false);
                }
            }
        }
        return answer;
    }

    private static class Node {
        public char alphabet;
        public boolean checked;

        public char getAlphabet() {
            return alphabet;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setAlphabet(char alphabet) {
            this.alphabet = alphabet;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public Node(char alphabet, boolean checked) {
            this.alphabet = alphabet;
            this.checked = checked;
        }
    }
}
