import java.awt.*;

public class Circle extends Shape {
    private int size;
    private Point center;
    private Color color;

    /**
     * This is the Circle constructor
     *
     * @param iSize    defines the size
     * @param location defines the location
     * @param C        defines the color
     */
    Circle(int iSize, Point location, Color C) {
        setSize(iSize);
        setLocation(location);
        setColor(C);
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

//DRAW CIRCLE
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getCenter().x - getSize() / 2, getCenter().y - getSize() / 2, getSize(), getSize());
    }

    //TO STRING FORMAT TO WRITE IN FILE
    @Override
    public String toString() {
        return "Circle"+"\n"+"size :"+size+"\n"+"Point :"+center.x+","+center.y+"\n"+"Color :"+ color.getRGB();
    }
}


