package section3;

public class Test {

    public int a, b = 0;
    public double x = 10.0;

    public String toString(){
        return a + " " + x;
    }

    public static void main(String[] args){
        Test test = new Test();
        Object test2 = new Test();
        System.out.println(test2.toString());
    }
}
