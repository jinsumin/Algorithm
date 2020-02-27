package section2;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code08 {

    static MyRectangle[] rectangles;
    static int n = 0;

    public static void main(String[] args){
        rectangles = new MyRectangle[100];
        try {
            Scanner in = new Scanner(new File("data.txt"));
            while(in.hasNext()){
                int x = in.nextInt();
                int y = in.nextInt();
                int w = in.nextInt();
                int h = in.nextInt();
                rectangles[n] = new MyRectangle(x, y, w, h);
                n ++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file");
            System.exit(1);
        }

        bubbleSort();

        for(int i = 0; i < n; i ++){
            System.out.println(rectangles[i].toString() + " area is : " + rectangles[i].calcArea());
        }
    }

    private static void bubbleSort() {
        for(int i = n-1; i > 0; i --){
            for(int j = 0; j < i; j ++){
                if(rectangles[j].calcArea() > rectangles[j+1].calcArea()){
                    MyRectangle tmp = rectangles[j];
                    rectangles[j] = rectangles[j+1];
                    rectangles[j+1] = tmp;
                }
            }
        }
    }
}
