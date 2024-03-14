package swigncomponents;

import java.awt.*;

public class Rectangle extends Shapes{
    private  Point startPoint;
    private  Point endPoint;
    private  Color fillColor;
    private Color strokeColor;
    private  int strokeWidth;

    public Rectangle(Point startPoint, Point endPoint, Color fillColor, Color strokeColor, int strokeWidth) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }


    @Override
    public void draw(Graphics g) {
        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);

        // Calculate the top-left corner of the rectangle
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);

        // Draw the rectangle
        g.setColor(strokeColor);
        g.fillRect(x, y, width, height);
        g.setColor(fillColor);
        g.fillRect(x + strokeWidth, y + strokeWidth, width - 2 * strokeWidth, height - 2 * strokeWidth);
    }

    @Override
    public int size() {
        return 0;
    }
}
