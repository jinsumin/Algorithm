package section2;

/*
클래스는 서로 관련있는 데이터들을 하나의 단위로 묶어두기 위함
서로 관련있는 데이터들 (field) 뿐 아니라, 그 데이터와 관련이 깊은 메서드 (method) 도 함께 묶을 수 있다
코드의 응집도를 높이고 결합도를 낮춤 high cohesion loose coupling
*/

/*객체지향 프로그래밍에서 객체란 데이터 + 메서드 이다 데이터는 객체의 정적 속성을 표현하고 메서드는 객체의
기능(동적속성) 을 표현한다*/

import java.util.Scanner;

public class Code07 {

    private Polynomial[] polynomials = new Polynomial[100];
    private int n = 0;

    private void processCommand(){
        Scanner kb = new Scanner(System.in);
        label:
        while(true){
            System.out.print("$ ");
            String command = kb.next();
            switch (command) {
                case "create": {
                    char name = kb.next().charAt(0);
                    polynomials[n] = new Polynomial(name);
                    n++;
                    break;
                }
                case "add": {
                    char name = kb.next().charAt(0);
                    int index = findIndex(name);
                    if (index == -1) {
                        System.out.println("Undefined function");
                    } else {
                        int coef = kb.nextInt();
                        int expo = kb.nextInt();
                        polynomials[index].addTerm(coef, expo);
                    }
                    break;
                }
                case "calc": {
                    char name = kb.next().charAt(0);
                    int index = findIndex(name);
                    if (index == -1) {
                        System.out.println("Undefined function");
                    } else {
                        int x = kb.nextInt();
                        int result = polynomials[index].calcPolynomial(x);
                        System.out.println(result);
                    }
                    break;
                }
                case "print": {
                    char name = kb.next().charAt(0);
                    int index = findIndex(name);
                    if (index == -1) {
                        System.out.println("Undefined function");
                    } else {
                        polynomials[index].printPolynomial();
                    }
                    break;
                }
                case "exit":
                    break label;
            }
        }
        kb.close();
    }

    private int findIndex(char name) {
        for(int i = 0; i < n; i ++){
            if(polynomials[i].name == name)
                return i;
        }
        return -1;
    }

    public static void main(String[] args){
        Code07 app = new Code07();
        app.processCommand();
    }
}
