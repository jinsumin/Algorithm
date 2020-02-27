package section2;

public class MyRectangle {
    public MyPoint leftUpper;
    public int width;
    public int height;

    public MyRectangle(int x, int y, int w, int h){
        leftUpper = new MyPoint(x, y);
        this.width = w;
        this.height = h;
    }

    public MyRectangle(MyPoint point, int w, int h){
        leftUpper = point;
        this.width = w;
        this.height = h;
    }

    public int calcArea(){
        return this.width * this.height;
    }

    public String toString(){
        return "(" + leftUpper.x + ", " + leftUpper.y + ") " + width + " " + height;
    }
}
