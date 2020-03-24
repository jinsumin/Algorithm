package example6;

/**
 * Created by Crab on 2020-03-19.
 */
public class Main {
    private static int a = 1;

    public static void main(String[] args) {
        System.out.println(a);
        func(a);
        System.out.println(a);
    }

    private static void func(int a) {
        a = a + 1;
        System.out.println(a);
    }
}
