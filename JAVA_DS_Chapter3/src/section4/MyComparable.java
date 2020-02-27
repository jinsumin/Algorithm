package section4;

/*
추상메서드로만 구성된 추상클래스는 인터페이스와 본질적으로 동일하지만
완전히 동일하지 않다. 그 차이는 다중상속에서 있다
자바에서는 다중 상속을 허용하지 않는다 하지만 하나의 클래스가 여러개의
인터페이스를 implement 하는 것은 가능하다
*/

public interface MyComparable {
    int compareTo(Object o);
}
