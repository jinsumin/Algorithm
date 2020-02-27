import java.util.Scanner;

public class Solution {
    public static void main(String []args){
        String str = "hello world";
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("please type a string : ");

        input = keyboard.nextLine();

        if(str.equals(input)){
            System.out.println("match string");
        }else{
            System.out.println("no match string");
        }
        keyboard.close();
    }
}
