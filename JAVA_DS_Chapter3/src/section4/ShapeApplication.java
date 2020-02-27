package section4;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication {

    private int capacity = 100;
    private Shape[] shapes = new Shape[capacity];
    private int n = 0;
    private Scanner kb = new Scanner(System.in);

    public void processCommand(){
        while(true){
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("add"))
                handleAdd();
            else if (command.equals("show") || command.equals("show_detail"))
                handleShow(command.equals("show_detail"));
            else if (command.equals("sort"))
                // handleSort(shapes, n);
                Arrays.sort(shapes, 0, n);
            else if (command.equals("exit"))
                break;
        }
        kb.close();
    }

    private void handleSort(MyComparable[] data, int size) {
        for(int i = n-1; i > 0; i --){
            for(int j = 0; j < i; j ++){
                if(data[j].compareTo(data[j+1]) > 0){
                    MyComparable tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
    }

    /*private void handleSort() {
        // bubble sort
        for(int i = n-1; i > 0; i --){
            for(int j = 0; j < i; j ++){
                if(shapes[j].computeArea() > shapes[j+1].computeArea()){
                    Shape tmp = shapes[j];
                    shapes[j] = shapes[j+1];
                    shapes[j+1] = tmp;
                }
            }
        }
    }*/

    private void handleShow(boolean detailed) {
        for(int i = 0; i < n; i ++){
            System.out.println((i+1) + ". " + shapes[i].toString());
            if(detailed){
                System.out.println("   The area is " + shapes[i].computeArea());
                System.out.println("   The perimeter is " + shapes[i].computePerimeter());
            }
        }
    }

    private void handleAdd() {
        String type = kb.next();
        switch(type){
            case "R" :
                addShape(new Rectangle(kb.next(), kb.nextInt(), kb.nextInt()));
                break;
            case "C" :
                addShape(new Circle(kb.next(), kb.nextInt()));
                break;
            case "T" :
                break;
        }

    }

    private void addShape(Shape shape) {
        shapes[n++] = shape;
    }

    public static void main(String[] args){
        ShapeApplication app = new ShapeApplication();
        app.processCommand();
    }
}
