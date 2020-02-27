package tetromino_14500;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-22.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution());
    }
}

class Solution {
    private static int[][] paper;
    private static int[][] sum;
    private static int n, m;
    public int solution() {
        initPaper();
        findWithPoly1();
        findWithPoly2();
        findWithPoly3();
        findWithPoly4();
        findWithPoly5();
        return findMaxOfSum();
    }

    private void initPaper() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        sum = new int[5][8];
        paper = new int[n + 1][m + 1];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                paper[i][j] = scanner.nextInt();
            }
        }
    }

    private void findWithPoly1() {
        int max = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m - 3; j ++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        sum[0][0] = max;
        int max2 = 0;
        for(int i = 0; i < n - 3; i ++) {
            for(int j = 0; j < m; j ++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
                if(sum > max2) {
                    max2 = sum;
                }
            }
        }
        sum[0][1] = max2;
    }

    private void findWithPoly2() {
        int max = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = 0; j < m - 1; j ++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        sum[1][0] = max;
    }

    private void findWithPoly3() {
        int max = 0;
        for(int i = 0; i < n - 2; i ++) {
            for(int j = 0; j < m - 1; j ++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        sum[2][0] = max;
        int max2 = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i][j + 2];
                if(sum > max2) {
                    max2 = sum;
                }
            }
        }
        sum[2][1] = max2;
        int max3 = 0;
        for(int i = 0; i < n - 2; i ++) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                if(sum > max3) {
                    max3 = sum;
                }
            }
        }
        sum[2][2] = max3;
        int max4 = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2] + paper[i][j + 2];
                if(sum > max4) {
                    max4 = sum;
                }
            }
        }
        sum[2][3] = max4;
        int max5 = 0;
        for(int i = 0; i < n - 2; i ++) {
            for(int j = 0; j < m - 1; j ++) {
                int sum = paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1] + paper[i + 1][j];
                if(sum > max5) {
                    max5 = sum;
                }
            }
        }
        sum[2][4] = max5;
        int max6 = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2];
                if(sum > max6) {
                    max6 = sum;
                }
            }
        }
        sum[2][5] = max6;
        int max7 = 0;
        for(int i = 0; i < n - 2; i ++) {
            for(int j = 0; j < m - 1; j ++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 2][j];
                if(sum > max7) {
                    max7 = sum;
                }
            }
        }
        sum[2][6] = max7;
        int max8 = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                if(sum > max8) {
                    max8 = sum;
                }
            }
        }
        sum[2][7] = max8;
    }

    private void findWithPoly4() {
        int max = 0;
        for(int i = 0; i < n - 2; i ++) {
            for(int j = 0; j < m - 1; j ++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        sum[3][0] = max;
        int max2 = 0;
        for(int i = 0; i < n - 1; i ++ ) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i + 1][j] + paper[i + 1][j + 1] + paper[i][j + 1] + paper[i][j + 2];
                if(sum > max2) {
                    max2 = sum;
                }
            }
        }
        sum[3][1] = max2;
        int max3 = 0;
        for(int i = 0; i < n - 2; i ++ ) {
            for(int j = 0; j < m - 1; j ++) {
                int sum = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j];
                if(sum > max3) {
                    max3 = sum;
                }
            }
        }
        sum[3][2] = max3;
        int max4 = 0;
        for(int i = 0; i < n - 1; i ++ ) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                if(sum > max4) {
                    max4 = sum;
                }
            }
        }
        sum[3][3] = max4;
    }

    private void findWithPoly5() {
        int max = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        sum[4][0] = max;
        int max2 = 0;
        for(int i = 0; i < n - 2; i ++) {
            for(int j = 0; j < m - 1; j ++) {
                int sum = paper[i + 1][j] + paper[i + 1][j + 1] + paper[i][j + 1] + paper[i + 2][j + 1];
                if(sum > max2) {
                    max2 = sum;
                }
            }
        }
        sum[4][1] = max2;
        int max3 = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = 0; j < m - 2; j ++) {
                int sum = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                if(sum > max3) {
                    max3 = sum;
                }
            }
        }
        sum[4][2] = max3;
        int max4 = 0;
        for(int i = 0; i < n - 2; i ++) {
            for(int j = 0; j < m - 1; j ++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j];
                if(sum > max4) {
                    max4 = sum;
                }
            }
        }
        sum[4][3] = max4;
    }

    private int findMaxOfSum() {
        int max = 0;
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 8; j ++) {
                if(sum[i][j] > max) {
                    max = sum[i][j];
                }
            }
        }
        return max;
    }
}
