package Section1;

import java.util.Scanner;

public class Code09 {
    /*
    n개의 정수를 입력받아 순서대로 배열에 저장. 모든 정수들을 한칸씩 오른쪽으로 shift 하고
    마지막 정수는 배열의 첫 칸으로 이동하는 코드
    */
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i ++){
            data[i] = sc.nextInt();
        }
        sc.close();

        int tmp = data[n-1];
        for(int i = n-2; i >= 0; i--){
            data[i+1] = data[i];
        }
        data[0] = tmp;

        for(int i = 0; i < data.length; i ++){
            System.out.print(data[i]);
        }
    }
}
