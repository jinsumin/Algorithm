package section2;

public class OrthoLine {

    private MyPoint u;
    private MyPoint v;

    public OrthoLine(MyPoint p, MyPoint q){
        this.u = p;
        this.v = q;
        if(p.x > q.x || p.x == q.x && p.y > q.y){
            swap();
        }
    }

    private void swap() {
        MyPoint tmp = u;
        u = v;
        v = tmp;
    }

    public OrthoLine(int x1, int y1, int x2, int y2){
        this.u = new MyPoint(x1, y1);
        this.v = new MyPoint(x2, y2);
    }

    public boolean isVertical(){
        return this.u.x == this.v.x;
    }

    public boolean interSects(OrthoLine otherLine){
        if(isVertical() && !otherLine.isVertical()){
            return (otherLine.u.x < u.x && otherLine.v.x > u.x && otherLine.u.y > u.y && otherLine.u.y < v.y);
        }else if(!isVertical() && otherLine.isVertical()){
            return (otherLine.u.y < u.y && otherLine.v.y > u.y && otherLine.u.x > u.x && otherLine.u.x < v.x);
        }else {
            return false;
        }
    }
}
