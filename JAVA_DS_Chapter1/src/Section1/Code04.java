package Section1;

import java.util.Scanner;

/*
n개의 정수를 입력받아 순서대로 배열에 저장한다. 중복된 정수쌍의 개수를 카운트하여 출력한다
예를 들어 n = 6 이고 2, 4, 2, 4, 5, 2 이면 중복된 정수 쌍은 22 22 22 44 로 4쌍이다
*/

public class Code04 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] data = new int[n];

        for(int i = 0; i < n; i++)
            data[i] = scan.nextInt();
        scan.close();

        int count = 0;
        for(int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (data[i] == data[j]) count++;
            }
        }
        System.out.println(count);
    }
}
