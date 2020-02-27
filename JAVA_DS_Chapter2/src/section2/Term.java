package section2;

public class Term {
    private int coef;    // 계수
    private int expo;     // 차수

    public Term(int c, int e){
        this.setCoef(c);
        this.setExpo(e);
    }

    public int calcTerm(int x){
        return (int) (getCoef() * Math.pow(x, getExpo()));
    }

    public void printTerm(){
        System.out.print(getCoef() + "x^" + getExpo());
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExpo() {
        return expo;
    }

    public void setExpo(int expo) {
        this.expo = expo;
    }
}

