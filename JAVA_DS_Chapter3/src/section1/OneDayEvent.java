package section1;

/*다형성 Polymorphism
수퍼클래스 타입의 변수가 서브클래스 타입의 객체를 참조할 수 있다*/

/*
scheduler program / to do app
*/

/*
4종류의 이벤트
일회성 이벤트 : 생일, 식사약속, 회의 등
기간이 지정된 이벤트 : 시험기간, 축제기간 등
데드라인이 있는 이벤트 : 시작일은 없고 마감이리 있는 일, 제출 기한 과제 등
주기적 이벤트 : 수업시간과 같이 매주 월, 목 등
*/

public class OneDayEvent extends Event{
    private MyDate date;
    public OneDayEvent(String title, MyDate date){
        super(title);
        this.date = new MyDate(date.year, date.day, date.day);
    }

    public String toString(){
        return super.title  + ", " + this.date.toString();
    }

    @Override
    public boolean isRelevant(MyDate date) {
        if(this.date.compareTo(date) == 0)
            return true;
        return false;
    }

    @Override
    public MyDate getRepresentativeDate() {
        return date;
    }
}
