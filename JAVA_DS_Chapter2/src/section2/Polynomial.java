package section2;

public class Polynomial {
    private char name;       // 다항식의 이름 f g h 등
    private Term[] terms;     // 다항식을 구성하는 항들
    private int nTerms;           // 다항식을 구성하는 항의 개수

    public Polynomial(){
        this.nTerms = 0;
        this.terms = new Term[100];
    }

    public Polynomial(char name){
        this.setName(name);
        this.nTerms = 0;
        this.terms = new Term[100];
    }

    public int calcPolynomial(int x){
        int result = 0;
        for(int i = 0; i < nTerms; i ++){
            result += terms[i].calcTerm(x);
        }
        return result;
    }
    public void printPolynomial(){
        for(int i = 0; i < nTerms; i ++){
            terms[i].printTerm();
            System.out.print(" + ");
        }
        System.out.println();
    }

    public void addTerm(int coef, int expo) {
        int index = findTerm(expo);
        if(index != -1){
            terms[index].setCoef(terms[index].getCoef() + coef);
        }else{
            int i = nTerms - 1;
            while(i >= 0 &&terms[i].getExpo() < expo){
                terms[i + 1] = terms[i];
                i --;
            }
            terms[i + 1] = new Term(coef, expo);
            nTerms ++;
        }
    }

    public int findTerm(int expo) {
        for(int i = 0; i < nTerms && terms[i].getExpo() >= expo; i++){
            if(terms[i].getExpo() == expo)
                return i;
        }
        return -1;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
}
