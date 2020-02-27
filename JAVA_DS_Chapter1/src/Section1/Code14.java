package Section1;
// 버블 정렬

import java.util.Scanner;

public class Code14 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i ++){
            data[i] = sc.nextInt();
        }

        for(int i = n-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(data[j] > data[j+1]){
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }

        System.out.println("Bubble Sorted data");
        for(int i = 0; i < n; i ++){
            System.out.print(data[i] + " ");
        }
    }
}
