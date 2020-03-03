package slope_14890;

        import java.util.Scanner;

/**
 * Created by REMI on 2020-01-28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(map, n, l));
    }
}

class Solution {
    private int answer;
    private boolean[] visited;

    public int solution(int[][] map, int n, int l) {
        for (int i = 0; i < n; i++) {
            int[] rows = new int[n];
            int[] cols = new int[n];
            for (int j = 0; j < n; j++) {
                rows[j] = map[i][j];
                cols[j] = map[j][i];
            }
            validCheck(rows, n, l);
            validCheck(cols, n, l);
        }
        return answer;
    }

    private void validCheck(int[] path, int n, int l) {
        visited = new boolean[n];
        for(int i = 0; i < n - 1; i ++) {
            if(path[i] == path[i + 1]) {
                continue;
            }
            if(Math.abs(path[i] - path[i + 1]) > 1) {
                return;
            }
            if(path[i] == path[i + 1] + 1) {
                if(i + l > n - 1) {
                    return;
                }
                if(!sameHeightOfPath(path, i + 1, i + l)) {
                    return;
                }
            }
            if(path[i] == path[i + 1] - 1) {
                if(i - l + 1 < 0) {
                    return;
                }
                if(!sameHeightOfPath(path, i - l + 1, i)) {
                    return;
                }
            }
        }
        answer ++;
    }

    private boolean sameHeightOfPath(int[] path, int start, int end) {
        int temp = path[start];
        for (int i = start; i <= end; i++) {
            if (temp != path[i] || visited[i]) {
                return false;
            }
            visited[i] = true;
        }
        return true;
    }
}
