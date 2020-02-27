import java.util.Scanner;

/**
 * Created by REMI on 2020-01-11.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 1; t <= testCase; t ++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int N = scanner.nextInt();  // 점의 개수
            int[] x = new int[N];
            int[] y = new int[N];
            for (int i = 0; i < N; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
            RectAndDot rad = new RectAndDot(x1, y1, x2, y2, x, y, N);
            System.out.println("#" + t + " " + rad.innerDot() + " " +
            rad.linerDot() + " " +
            rad.outerDot());
        }
    }
}

class RectAndDot {
    int x1, y1, x2, y2;
    int[] x;
    int[] y;
    int N;
    public RectAndDot(int x1, int y1, int x2, int y2, int[] x, int[] y, int N) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.x = x;
        this.y = y;
        this.N = N;
        x = new int[N];
        y = new int[N];
    }

    public int innerDot(){
        int result = 0;
        for(int i = 0; i < N; i ++){
            if(x[i] > x1 && x[i] < x2 && y1 < y[i] && y2 > y[i]){
                result ++;
            }
        }
        return result;
    }
    public int outerDot(){
        int result = 0;
        for(int i = 0; i < N; i ++){
            if(x[i] < x1 && x[i] > x2 && y1 > y[i] && y2 < y[i]){
                result ++;
            }
        }
        return result;
    }
    public int linerDot(){
        int result = 0;
        for(int i = 0; i < N; i ++){
            if((x[i] == x1 || x[i] == x2) && (y1 == y[i] || y2 == y[i])){
                result ++;
            }
        }
        return result;
    }
}
