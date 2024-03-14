import java.awt.*;

public class Rectangle extends Shape {
    private int height;
    private int width;
    private Point topleft;
    private Color color;

    /**
     *
     * @param height ENTER HEIGHT OF RECTANGLE
     * @param width
     * @param topleft
     * @param color
     */
    public Rectangle(int height, int width, Point topleft, Color color) {
        this.height = height;
        this.width = width;
        this.topleft = topleft;
        this.color = color;

    }

    void setSize(int iheight, int iwidth) {
        if (height > 1 && width > 1) {
            height = iheight;
            width = iwidth;

        } else {
            height = 1;
            width = 1;
        }
    }

    void setLocation(Point topleft) {
        this.topleft = topleft;
    }

    void setColor(Color Color) {
        color = Color;
    }

    int getSize() {
        return height * width;
    }

    Point getCenter() {
        return new Point(topleft.x + width / 2, topleft.y + height / 2);
    }

    Color getColor() {
        return color;
    }

//DRAW RECTANGLE
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(topleft.x, topleft.y, width, height);
    }

    //TO STRING FORMAT TO WRITE IN FILE
    @Override
    public String toString() {
        return "Rectangle"+"\n"+"height :"+height+"\n"+"width :"+width+"\n"+"Point :"+topleft.x+","+topleft.y+"\n"+"Color :"+ color.getRGB();
    }

}
