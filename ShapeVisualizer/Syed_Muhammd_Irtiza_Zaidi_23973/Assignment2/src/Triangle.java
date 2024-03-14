import java.awt.*;


public class Triangle extends Shape {

    private Point p1;
    private Point p2;
    private Point p3;
    private Color color;

    public Triangle(Point p1, Point p2, Point p3, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = color;
    }

    //DRAWS TRIANGLE
    @Override
    public void draw(Graphics g) {
       g.setColor(color);

       g.fillPolygon(new int[]{p1.x,p2.x,p3.x},new int[]{p1.y,p2.y,p3.y},3);

    }

    //TO STRING FORMAT TO WRITE IN FILE
    @Override
    public String toString() {
        return "Triangle"+"\n"+
                "Point1 :"+p1.x+","+p1.y+"\n"+
                "Point2 :"+p2.x+","+p2.y+"\n"+
                "Point3 :"+p3.x+","+p3.y+"\n"+
                 "Color :"+ color.getRGB();
    }
}
