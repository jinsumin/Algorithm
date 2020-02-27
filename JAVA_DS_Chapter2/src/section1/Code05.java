package section1;

/*
다항함수는 항들의 합이며, 항은 계수와 지수에 의해서 정의된다 계수는 0이 아닌 정수이고 지수는 음이 아닌 정수라고 가정
예를들면, f(x) = -x^5 + 2x^4 - 10x + 5
*/

/*$ create f      // 다항함수 f = 0 을 정의한다
$ add f 2 3     // fx 에 2x^3 을 더한다
$ add f -1 1    // fx 에 -x 를 더한다
$ add f 5 0     // fx 에 5 를 더한다
$ add f 2 1     // fx 에 2x 를 더한다
$ calc f 2      // x = 2 일 때 다항함수 f 의 값, 즉 f(2) = 23 을 계산하여 출력한다
23
$ print f       // 차수에 관한 내림차순으로 정렬하여 다음과 같이 출력한다.
2x^3 + x + 5    // 동일한 차수의 항은 하나로 합쳐져야 한다.
$ create g      // 다른 다항 함수 g 를 정의한다.
...
$ exit          // 종료*/

import java.util.Scanner;

public class Code05 {
    static Polynomial[] polynomial;
    static int n = 0;

    public static void main(String[] args){
        polynomial = new Polynomial[10000];
        Scanner kb = new Scanner(System.in);
        while(true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("create")){
                char funcName = kb.next().charAt(0);
                createPolynomial(funcName);
            }else if(command.equals("add")){
                char funcName = kb.next().charAt(0);
                int coef = kb.nextInt();
                int expo = kb.nextInt();
                addTerm(funcName, coef, expo);
            }else if(command.equals("calc")){
                char funcName = kb.next().charAt(0);
                int x = kb.nextInt();
                System.out.println(calcPolynomial(funcName, x));
            }else if(command.equals("print")){
                char funcName = kb.next().charAt(0);
                printPolynomial(funcName);
            }else if(command.equals("exit")){
                break;
            }else{
                System.out.println("wrong command");
            }
        }
        kb.close();
    }

    private static void printPolynomial(char funcName) {
        int index = findFunc(funcName);
        String res = "";
        for(int i = 99; i >= 0; i --){
            if(polynomial[index].terms[i] == null) continue;
            res += polynomial[index].terms[i].coef + "x^" + polynomial[index].terms[i].expo + " + ";
        }
        System.out.println(res.substring(0, res.length() - 3));
    }

    private static int calcPolynomial(char funcName, int x) {
        int res = 0;
        int index = findFunc(funcName);
        for(int i = 0; i < 100; i ++) {
            if(polynomial[index].terms[i] == null) continue;
            //  System.out.print("i 값은  : " + i + " ");
            //  System.out.println(polynomial[index].terms[i].coef * (int)Math.pow(x, polynomial[index].terms[i].expo));
            res += polynomial[index].terms[i].coef * (int)Math.pow(x, polynomial[index].terms[i].expo);
        }
        return res;
    }

    private static void addTerm(char funcName, int coef, int expo) {
        int index = findFunc(funcName);
        if(index == -1) {
            System.out.println("Undefined function");
        }else {
            if(polynomial[index].terms[expo] == null) {
                polynomial[index].terms[expo] = new Term();
                polynomial[index].terms[expo].coef = coef;
                polynomial[index].terms[expo].expo = expo;
                polynomial[index].nTerms++;
            }else{
                polynomial[index].terms[expo].coef += coef;
            }

        }
    }

    private static int findFunc(char funcName) {
        for(int i = 0; i < n; i ++){
            if(polynomial[i].name == funcName)
                return i;
        }
        return -1;
    }

    private static void createPolynomial(char funcName) {
        polynomial[n] = new Polynomial();
        polynomial[n].terms = new Term[100];
        polynomial[n].name = funcName;
        n ++;
    }
}
