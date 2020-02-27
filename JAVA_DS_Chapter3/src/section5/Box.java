package section5;

/*
제네릭 프로그래밍은 데이터 형식에 의존하지 않고 하나의 값이
여러 다른 데이터 타입들을 가질 수 있는 기술에 중점을 두어
재사용성을 높일 수 있는 프로그래밍 방식을 말한다
*/

public class Box<T> {
    private T t;
    public void set(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }
}
