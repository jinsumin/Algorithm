package example;

/**
 * Created by Crab on 2020-03-30.
 */

class PersonInfo {
    String name;
    int age;
    double height;
    PersonInfo() {

    }
}

public class Main {
    public static void main(String[] args) {
        PersonInfo p = new PersonInfo();
        p.name = "ALICE";
        p.age = 18;
        p.height = 120.5;
        System.out.println("p.name : " + p.name);
        System.out.println("p.age : " + p.age);
        System.out.println("p.height : " + p.height);
    }
}
