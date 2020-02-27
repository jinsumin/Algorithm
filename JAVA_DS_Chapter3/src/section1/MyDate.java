package section1;

public class MyDate {

    public int year;
    public int month;
    public int day;

    public MyDate(int y, int m, int d){
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public int compareTo(MyDate other){
        if(year < other.year || year == other.year && month < other.month
                || year == other.year && month == other.month && day < other.day)
            return -1;
        else if(year > other.year || year == other.year && month > other.month
                || year == other.year && month == other.month && day > other.day)
            return 1;
        else
            return 0;
    }

    public String toString(){
        return this.year + "/" + this.month + "/" + this.day;
    }
}
