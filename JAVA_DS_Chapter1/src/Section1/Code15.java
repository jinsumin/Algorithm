package Section1;
/*
사용자로부터 n개의 정수를 입력받는다. 정수가 하나씩 입력될 때 마다 현재까지 입력된 정수들을
오름차순으로 정렬하여 출력
*/

import java.util.Scanner;

public class Code15 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i ++){
            int tmp = sc.nextInt();
            int j = i - 1;
            while(j >= 0 && data[j] > tmp) {
                data[j+1] = data[j];
                j--;
            }data[j+1] = tmp;
        }
        sc.close();

        for(int i = 0; i < n; i ++){
            System.out.print(data[i] + " ");
        }
    }
}
