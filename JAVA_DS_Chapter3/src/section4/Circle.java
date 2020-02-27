package section4;

public class Circle extends Shape{
    int radius;

    public Circle(String name, int r) {
        super(name);
        radius = r;
    }

    @Override
    public double computeArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double computePerimeter() {
        return 2.0 * Math.PI * radius;
    }

    public String toString(){
        return super.shapeName + ": radius is " + radius;
    }
}
