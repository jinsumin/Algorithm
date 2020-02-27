package section1;

public class Code01_2 {

    public static void main(String[] args){

        Person1 first = new Person1();
        first.name = "john";
        first.number = "11111112";

        Person1[] members = new Person1[100];
        for(int i = 0; i < 100; i ++){
            members[i] = new Person1();
            members[i].name = "spiderman" + i;
            members[i].number = "0000" + i;
        }

        for(int i = 0; i < 10; i ++){
            System.out.println(members[i].name + " " + members[i].number);
        }
    }
}
