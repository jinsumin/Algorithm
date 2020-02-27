package section1;

public class DeadLinedEvent extends Event{

    public MyDate deadline;

    public DeadLinedEvent(String title, MyDate date){
        super(title);
        this.deadline = date;
    }

    public String toString(){
        return title + "," +  deadline.toString();
    }

    @Override
    public boolean isRelevant(MyDate date) {
        return deadline.compareTo(date) >= 0;
    }

    @Override
    public MyDate getRepresentativeDate() {
        return deadline;
    }
}
