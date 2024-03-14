package swigncomponents;

import java.awt.*;

public class Circle extends Shapes {
    private int size;
    private Point center;
    private Color color;
    private Color stroke_color;
    private int Stroke_size;


    public Circle(int size, Point center, Color color, Color stroke_color, int stroke_size) {
        this.size = size;
        this.center = center;
        this.color = color;
        this.stroke_color = stroke_color;
        Stroke_size = stroke_size;
    }

    void setSize(int iSize) {
        if (iSize > 1) {
            size = iSize;
        } else {
            size = 1;
        }
    }

    void setLocation(Point Pcenter) {
        center = Pcenter;
    }

    void setColor(Color Ccolor) {
        color = Ccolor;
    }

    /**
     * @return returns the size of the circle
     */
    int getSize() {
        return size;
    }

    Point getCenter() {
        return center;
    }

    Color getColor() {
        return color;
    }

    public Color getStroke_color() {
        return stroke_color;
    }

    public int getStroke_size() {
        return Stroke_size;
    }

    //DRAW CIRCLE
    public void draw(Graphics g) {
        Point center = getCenter();
        int sizeWithStroke = getSize();
        int sizeWithoutStroke = getSize() - 2 * getStroke_size();

        g.setColor(getStroke_color());
        g.fillOval(center.x - sizeWithStroke / 2, center.y - sizeWithStroke / 2, sizeWithStroke, sizeWithStroke);
        g.setColor(getColor());
        g.fillOval(center.x - sizeWithoutStroke / 2, center.y - sizeWithoutStroke / 2, sizeWithoutStroke, sizeWithoutStroke);

    }

    @Override
    public int size() {
        return getSize();
    }

    //TO STRING FORMAT TO WRITE IN FILE
    @Override
    public String toString() {
        return "Circle"+"\n"+"size :"+size+"\n"+"Point :"+center.x+","+center.y+"\n"+"Color :"+ color.getRGB();
    }
}
