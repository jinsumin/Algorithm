package Section2;

/*이름과 전화번호 쌍을 입력 받은 후 이름의 알파벳 순으로 정렬하여 출력*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {

    String[] name;
    String[] number;
    int n;

    Code20(String[] name, String[] number, int n){
        this.name = name;
        this.number = number;
        this.n = n;
    }

    public static void main(String[] args){

        Code20 text = new Code20(new String[1000], new String[1000], 0);

        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("input.txt"));
            while(inFile.hasNext()){
                text.name[text.n] = inFile.next();
                text.number[text.n] = inFile.next();
                text.n ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        inFile.close();

        bubbleSort(text.name, text.number, text.n);

        for(int i = 0; i < text.n; i ++){
            System.out.println(text.name[i] + " : " + text.number[i]);
        }
    }

    private static void bubbleSort(String[] name, String[] number, int n){
        for(int i = n-1; i > 0; i --){
            for(int j = 0; j < i; j ++){
                if(name[j].compareTo(name[j+1]) > 0) {
                    String tmp = name[j];
                    name[j] = name[j+1];
                    name[j+1] = tmp;

                    tmp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = tmp;
                }
            }
        }
    }

}
