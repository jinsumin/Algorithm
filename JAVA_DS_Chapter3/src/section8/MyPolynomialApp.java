package section8;

import section7.Polynomial;

import java.util.Scanner;

public class MyPolynomialApp {

    private Polynomial[] polys = new Polynomial[100];
    private int n = 0;
    private Scanner sc = new Scanner(System.in);

    public MyPolynomialApp(){

    }

    public void processCommand(){
        while(true){
            System.out.print("$ ");
            String command = sc.next();
            if(command.equals("create"))
                handleCreate();
            else if(command.equals("add"))
                handleAdd();
            else if(command.equals("calc"))
                handleCalc();
            else if(command.equals("print"))
                handlePrint();
            else if(command.equals("exit"))
                break;
        }
        sc.close();
    }

    private void handlePrint() {
        char name = sc.next().charAt(0);
        int index = find(name);
        if(index < 0){
            System.out.println("No such polynomial");
            return;
        }
        System.out.println(polys[index].toString());
    }

    private void handleCalc() {
        char name = sc.next().charAt(0);
        int x = sc.nextInt();
        int index = find(name);
        if(index < 0){
            System.out.println("No such polynomial");
            return;
        }
        System.out.println(polys[index].calc(x));
    }

    private void handleAdd() {
        char name = sc.next().charAt(0);
        int coef = sc.nextInt();
        int expo = sc.nextInt();
        int index = find(name);
        if(index < 0) {
            System.out.println("No such polynomial");
            return;
        }
        polys[index].addTerm(coef, expo);
    }

    private int find(char name) {
        for(int i = 0; i < n; i ++){
            if(polys[i].name == name)
                return i;
        }
        return -1;
    }

    private void handleCreate() {
        char name = sc.next().charAt(0);    // 입력받은 문자열의 첫 글자
        Polynomial p = new Polynomial(name);
        polys[n++] = p;
    }

    public static void main(String[] args){
        MyPolynomialApp app = new MyPolynomialApp();
        app.processCommand();
    }
}
