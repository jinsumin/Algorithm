package section1;

/*데이터 파일로 부터 사람들의 이름과 전화번호를 입력받아 배열 members에 저장한 후, 입력된 순서대로 출력하려고 한다*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code02 {

    static Person1[] members;
    static int count = 0;

    public static void main(String[] args){
        members = new Person1[100];
        try {
            Scanner in = new Scanner(new File("input.txt"));
            while(in.hasNext()){
                String str1 = in.next();
                String str2 = in.next();
                members[count] = new Person1();
                members[count].name = str1;
                members[count].number = str2;
                count ++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < count; i ++){
            System.out.println(members[i].name + "'s phone number is " + members[i].number);
        }
    }
}
