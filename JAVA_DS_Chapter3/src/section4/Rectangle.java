package section4;

public class Rectangle extends Shape{

    public int width, height;

    public Rectangle(String name, int w, int h) {
        super(name);
        width = w;
        height = h;
    }

    @Override
    public double computeArea() {
        return (double)width * height;
    }

    @Override
    public double computePerimeter() {
        return 2.0 * (width + height);
    }

    public String toString(){
        return super.shapeName + ": width is " + width + ", height is " + height;
    }
}
