package gary_manderling_17779;

import java.util.*;

/**
 * Created by REMI on 2020-02-05.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                a[i][j] = scanner.nextInt();
            }
        }
        Solution sol = new Solution();
        sol.solution(a);
        System.out.println(sol.getMinDiff());
    }
}

class Solution {

    private class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int minDiff = 0;
    private static List<Integer> listOfMaxDiff = new ArrayList<Integer>();

    public void solution(int[][] a) {
        for(int i = 0; i < a.length - 2; i ++) {
            for(int j = 1; j < a.length - 1; j ++) {
                for(int d1 = 1; d1 <= j; d1 ++) {
                    for(int d2 = 1; d2 < a.length - j; d2 ++) {
                        divideMap(a, i, j, d1, d2);
                    }
                }
            }
        }
        Collections.sort(listOfMaxDiff);
        minDiff = listOfMaxDiff.get(0);
    }

    private void divideMap(int[][] a, int x, int y, int d1, int d2) {
        Pair vertex1 = new Pair(x, y);
        Pair vertex2 = new Pair(x + d1, y - d1);
        Pair vertex3 = new Pair(x + d2, y + d2);
        Pair vertex4 = new Pair(x + d1 + d2, y + d2 - d1);
        List<Integer> listSumOfElectionDistrict = new ArrayList<>();
        listSumOfElectionDistrict.add(sumOfElectionDistrict1(a, vertex1, vertex2));
        listSumOfElectionDistrict.add(sumOfElectionDistrict2(a, vertex1, vertex3));
        listSumOfElectionDistrict.add(sumOfElectionDistrict3(a, vertex2, vertex4));
        listSumOfElectionDistrict.add(sumOfElectionDistrict4(a, vertex3, vertex4));
        int sumOfFour = 0;
        for (int i = 0; i < 4; i++) {
            sumOfFour += listSumOfElectionDistrict.get(i);
        }
        int sum = 0;
        for (int[] ints : a) {
            for (int j = 0; j < a.length; j++) {
                sum += ints[j];
            }
        }
        listSumOfElectionDistrict.add(sum - sumOfFour);
        Collections.sort(listSumOfElectionDistrict);
        int lastElement = listSumOfElectionDistrict.get(listSumOfElectionDistrict.size() - 1);
        int firstElement = listSumOfElectionDistrict.get(0);
        listOfMaxDiff.add(listSumOfElectionDistrict.get(lastElement - firstElement));
    }

    private int sumOfElectionDistrict1(int[][] a, Pair vertex1, Pair vertex2) {
        int sum = 0;
        for(int i = 0; i < vertex2.r; i ++) {
            for(int j = 0; j <= vertex1.c; j ++) {
                sum += a[i][j];
            }
        }
        for(int i = vertex1.r; i <= vertex1.r; i ++) {
            for(int j = vertex1.c; j > vertex2.c; j --) {
                sum -= a[i][j];
            }
        }
        return sum;
    }

    private int sumOfElectionDistrict2(int[][] a, Pair vertex1, Pair vertex3) {
        int sum = 0;
        for(int i = 0; i <= vertex3.r; i ++) {
            for(int j = vertex1.c + 1; j < a.length; j ++) {
                sum += a[i][j];
            }
        }
        for(int i = vertex1.r + 1; i < vertex3.r; i ++) {
            for(int j = vertex1.c + 1; j <= vertex3.c; j ++) {
                sum -= a[i][j];
            }
        }
        return sum;
    }

    private int sumOfElectionDistrict3(int[][] a, Pair vertex2, Pair vertex4) {
        int sum = 0;
        for(int i = vertex2.r; i < a.length; i ++) {
            for(int j = 0; j < vertex4.c; j ++) {
                sum += a[i][j];
            }
        }
        for(int i = vertex2.r; i <= vertex4.r; i ++) {
            for(int j = vertex2.c; j < vertex4.c; j ++) {
                sum -= a[i][j];
            }
        }
        return sum;
    }

    private int sumOfElectionDistrict4(int[][] a, Pair vertex3, Pair vertex4) {
        int sum = 0;
        for(int i = vertex3.r + 1; i < a.length; i ++) {
            for(int j = vertex4.c; j < a.length; j ++) {
                sum += a[i][j];
            }
        }
        for(int i = vertex3.r + 1; i <= vertex4.r; i ++) {
            for(int j = vertex4.c; j < vertex3.c; j ++) {
                sum -= a[i][j];
            }
        }
        return sum;
    }

    public int getMinDiff() {
        return minDiff;
    }
}
