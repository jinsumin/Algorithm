package section6;

public class Term {
    public int coef;
    public int expo;

    public Term(int coef, int expo){
        this.coef = coef;
        this.expo = expo;
    }

    public int calc(int x){
        return coef * (int)Math.pow(x, expo);
    }

    public String toString(){
        return coef + "x^" + expo;
    }
}
