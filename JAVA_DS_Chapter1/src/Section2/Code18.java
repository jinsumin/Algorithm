package Section2;

import java.util.Scanner;

public class Code18 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i ++){
            data[i] = sc.nextInt();
        }
        sc.close();

        bubbleSort(data);

        System.out.println("Sorted data : ");
        for(int i = 0; i < n; i ++){
            System.out.print(" " + data[i]);
        }
    }

    private static void bubbleSort(int[] data){
        for(int i = 0; i < data.length; i ++){
            for(int j = i-1; j >= 0; j --){
                if(data[j] > data[j+1]){
                    swap(data[j], data[j+1]);
                }
            }
        }
    }

    private static void swap(int a, int b){ // JAVA 는 call by reference 안됌...
        int tmp = a;
        a = b;
        b = tmp;
    }
}
