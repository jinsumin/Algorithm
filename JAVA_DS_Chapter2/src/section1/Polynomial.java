package section1;

public class Polynomial {
    private char name;       // 다항식의 이름 f g h 등
    public Term[] terms;     // 다항식을 구성하는 항들
    public int nTerms = 0;           // 다항식을 구성하는 항의 개수

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
}
