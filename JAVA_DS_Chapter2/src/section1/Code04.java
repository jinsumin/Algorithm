package section1;

/*평면상에 좌표축에 평행한 n개의 직사각형에 관한 데이터를 입력받은 후 면적이 작은것 부터 큰것 순으로 정렬하여
출력하는 코드 작성*/

/*
입력파일 형식
0 1 2 4         // 왼쪽상단 꼭지점의 좌표 (0. 1) 이고 너비가 2, 높이가 4
1 4 7 8
4 3 12 9
8 18 11 30
5 10 6 11
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Code04 {

    static MyRectangle1[] rects;
    static int n = 0;

    public static void main(String[] args){

        rects = new MyRectangle1[10000];

        Stack stack = new Stack();

        try {
            Scanner in = new Scanner(new File("data.txt"));
            while(in.hasNext()) {
                rects[n] = new MyRectangle1();
                rects[n].leftUpper = new MyPoint1();
                rects[n].leftUpper.x = in.nextInt();
                rects[n].leftUpper.y = in.nextInt();
                rects[n].width = in.nextInt();
                rects[n].height = in.nextInt();
                stack.push(calcArea(rects[n]));
                n ++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file");
            System.exit(1);
        }

        /*bubbleSort();
        for(int i = 0; i < n; i ++){
            System.out.println(rects[i].leftUpper.x + "," + rects[i].leftUpper.y + " 넓이 : " + calcArea(rects[i]));
        }*/

        Collections.sort(stack);

        while(!stack.empty()){
            System.out.println(stack.pop());
        }

    }

    private static void bubbleSort() {
        for(int i = n-1; i > 0; i --){
            for(int j = 0; j < i; j ++){
                if(calcArea(rects[j]) > calcArea(rects[j+1])){
                    MyRectangle1 tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }
            }
        }
    }

    private static int calcArea(MyRectangle1 r){
        return r.width * r.height;
    }
}
