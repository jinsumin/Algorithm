package Section2;

/*2차원 배열에서 소수 찾기
입력으로 nXn 개의 음이 아닌 한자리 정수가 그림과 같이 주어진다. 이 정수들 중 가로, 세로, 대각선의
8방향으로 연속된 숫자들을 합쳐서(?) 만들 수 있는 모든 소수를 찾아서 나열하는 코드 작성*/

/*모든 가능한 수열들에 대해서 정수값으로 환산한다 모두 검사
하나의 수열은 시작점, 방향, 길이에 의해서 결정된다
방향은 0~7 번까지의 수로 표현하자 (임의의 시작좌표점에 대해서 9가지 방향이 있음)

for(int x = 0; x < n; x ++)
    for(int y = 0; y < n; y ++)
        for(int dir = 0; dir < 8; dir ++)
            for(int length = 1; length <= n; length ++)
                int value = computeValue(x, y, dir, length);
                if(value != -1 && isPrime(value))
                    System.out.println(value);*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code21 {

    private int[][] grid;
    private int n;

    public Code21(int[][] grid, int n) {
        this.grid = grid;
        this.n = n;
    }

    public static void main(String[] args){
        Scanner inFile;
        try {
            inFile = new Scanner(new File("data.txt"));
            int m = inFile.nextInt();
            Code21 data = new Code21(new int[m][m], m);
            for(int i = 0; i < data.n; i ++){
                for(int j = 0; j < data.n; j ++){
                    data.grid[i][j] = inFile.nextInt();
                }
            }
            inFile.close();

            for(int x = 0; x < data.n; x ++){
                for(int y = 0; y < data.n; y ++){
                    for(int dir = 0; dir < 8; dir ++){
                        for(int len = 1; len <= data.n; len++){
                            int val = computeValue(data, x, y, dir, len);
                            if(val != -1 && isPrime(val))
                                System.out.println(val);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int computeValue(Code21 c, int x, int y, int dir, int len){
        int value = 0;
        for(int i = 0; i < len; i ++){
            int digit = getDigit(c, x, y, dir, i);
            if(digit == -1)
                return -1;
            value = value * 10 + digit;
        }
        return value;
    }

    public static int getDigit(Code21 c, int x, int y, int dir, int k){
        int newX = x, newY = y;
        switch(dir){
            case 0: newY -= k; break;
            case 1: newX += k; newY -= k; break;
            case 2: newX += k; break;
            case 3: newX += k; newY += k; break;
            case 4: newY += k; break;
            case 5: newX -= k; newY += k; break;
            case 6: newX -= k; break;
            case 7: newX -= k; newY -= k; break;
        }
        if(newX < 0 || newX >= c.n || newY < 0 || newY >= c.n)
            return -1;
        return c.grid[newX][newY];
    }

    public static boolean isPrime(int k){
        if(k < 2) return false;
        for(int i = 2; i*i <= k; i ++){
            if(k % i == 0) return false;
        }
        return true;
    }
}
