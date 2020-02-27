package n_and_m_15649;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by REMI on 2020-01-29.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        permutation(arr, visited, n, m, 0);
    }

    private void permutation(int[] arr, boolean[] visited, int n, int m, int depth) {
        if (depth == m) {
            print(arr, m);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = i + 1;
            permutation(arr, visited, n, m, depth + 1);
            visited[i] = false;
        }
    }

    private void print(int[] arr, int m) {
        for (int i = 0; i < m; i++) {
            if (i == m - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
