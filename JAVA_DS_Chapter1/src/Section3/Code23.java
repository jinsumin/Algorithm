package Section3;

/*Code22 의 문제점
소수점, 쉼표 등의 특수기호가 단어에 포함
숫자 등이 단어로 취급
대문자와 소문자가 다른 단어로 취급
단어들이 정렬되어 있지 않음
의 문제점들을 개선하는 코드를 작성하라.*/

import java.io.*;
import java.util.Scanner;

public class Code23 {

    static String[] words = new String[100000];
    static int[] count = new int[100000];
    static int n = 0;

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        while(true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("read")){
                String fileName = kb.next();
                makeIndex(fileName);
            }else if(command.equals("find")){
                String str = kb.next();
                int index = findWord(str);
                if(index > -1){
                    System.out.println("The word " + str + " appears " + count[index] + " times.");
                }else{
                    System.out.println("The word " + str + " does not appear.");
                }
            }else if(command.equals("saveas")){
                String fileName = kb.next();
                saveAs(fileName);
            }else if(command.equals("exit")){
                break;
            }
        }

        kb.close();

        for(int i = 0; i < n; i ++){
            System.out.println(words[i] + " " + count[i]);
        }
    }

    private static void saveAs(String fileName) {
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(new FileWriter(fileName));
            for(int i = 0; i < n; i ++){
                outFile.println(words[i] + " " + count[i]);
            }
            outFile.close();
        } catch (IOException e) {
            System.out.println("Save failed");
            return;
        }
    }

    private static void makeIndex(String fileName){
        try {
            Scanner inFile = new Scanner(new File(fileName));
            while(inFile.hasNext()){
                String str = inFile.next();
                String trimmed = trimming(str); // 단어의 앞뒤에 붙은 특수문자 제거
                if(trimmed != null) {
                    String lowerWords = trimmed.toLowerCase();
                    addWord(lowerWords);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File");
            return;
        }
    }

    private static String trimming(String str) {
        int i = 0, j = str.length()-1;
        while(i < str.length() && !Character.isLetter(str.charAt(i))) // while i-th character is not letter
            i ++;
        while(j >= 0 && !Character.isLetter(str.charAt(j)))
            j --;
        if(i > j)
            return null;
        return str.substring(i, j+1);    // [, ) 폐구간, 개구간
    }

    private static void addWord(String str){
        int index = findWord(str);
        if(index != -1){    // found    words[index] == str
            count[index] ++;
        }else{   // not found
            int i = n-1;
            for(; i >= 0 && words[i].compareToIgnoreCase(str) > 0; i --) {
                words[i+1] = words[i];
                count[i+1] = count[i];
            }
            words[i+1] = str;
            count[i+1] = 1;
            n ++;
        }
    }

    private static int findWord(String str) {
        for(int i = 0; i < n; i ++){
            if(words[i].equalsIgnoreCase(str)){   // words[i].equalsIgnoreCase(str) 을 사용하면 대소문자 구분 X
                return i;
            }
        }
        return -1;
    }
}
