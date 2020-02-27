package section2;

/*다각형과 점
입려긍로 하나의 직교 다각형과 또 하나의 점 p 가 주어질 때 그 점이 다각형의 내부에 있는지 외부에 있는지 판단하는 코드*/

/*꼭지점의 개수를 입력받고 이후 꼭지점들을 시계방향 순서로 입력받는다 마지막으로 테스트할 점 p 의 좌표를 입력받는다
input data 예시
        8
        0 0
        16 0
        16 8
        10 18
        10 6
        6 6
        6 12
        0 12
        7 7*/

/*LOGIC : 내부 / 와부 검사
점에서 시작하여 한 방향으로 무한히 뻗어가는 아무 직선이나 하나 그어서 그것이 다각형의 변과 짝수 번 교차하면 외부,
홀수 번 교차하면 내부에 있다*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code10 {

    public static void main(String[] args){
        try {
            Scanner in = new Scanner(new File("code10_input_data.txt"));
            int n = in.nextInt();
            OrthoPolygon thePolygon = new OrthoPolygon(n);
            for(int i = 0; i < n; i ++)
                thePolygon.addVertex(in.nextInt(), in.nextInt());
            MyPoint thePoint = new MyPoint(in.nextInt(), in.nextInt());
            in.close();
            if(thePolygon.contains(thePoint))
                System.out.println("Yes");
            else
                System.out.println("No");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
