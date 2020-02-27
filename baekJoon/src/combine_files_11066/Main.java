package combine_files_11066;

import java.util.Scanner;

/**
 * Created by REMI on 2020-02-21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 1; t <= testCase; t++) {
            int k = scanner.nextInt();
            int[] files = new int[k];
            for(int i = 0; i < k; i ++) {
                files[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            solution.solution(files);
        }
    }
}

class Solution {
    public void solution(int[] files) {

    }
}
