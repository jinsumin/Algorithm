package Section2;

/*사람이름과 전화번호부 File 에서 읽어오는 코드*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code19 {

    public static void main(String[] args){

        String[] name = new String[1000];
        String[] number = new String[1000];
        int n = 0;
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("input.txt"));
            while(inFile.hasNext()){
                name[n] = inFile.next();
                number[n] = inFile.next();
                n ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        inFile.close();

        for(int i = 0; i < n; i ++){
            System.out.println(name[i] + " : " + number[i]);
        }
    }
}
