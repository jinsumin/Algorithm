package section2;

public class OrthoPolygon {

    private int n;  //   꼭지점의 개수
    private MyPoint[] vertices;

    public OrthoPolygon(int k){
        n = 0;
        vertices = new MyPoint[k];
    }

    public void addVertex(int x, int y){
        vertices[n++] = new MyPoint(x, y);
    }

    public int maxX(){
        int max = vertices[0].x;
        for(int i = 0; i < n; i ++){
            if(vertices[i].x > max){
                max = vertices[i].x;
            }
        }
        return max;
    }

    public boolean contains(MyPoint p){
        OrthoLine arrow = new OrthoLine(p, new MyPoint(maxX() + 1, p.y));
        int count = 0;
        for(int i = 0; i < n; i ++){
            OrthoLine edge = new OrthoLine(vertices[i], vertices[(i + 1) % n]);
            if(arrow.interSects(edge)){
                count ++;
            }
        }
        return (count % 2 == 1);
    }
}
