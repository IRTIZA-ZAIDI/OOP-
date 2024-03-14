package swigncomponents;

import java.awt.*;

public class Right_Triangle extends Shapes {

    private Point first_click;
    private Point second_click;
    private Color color;
    private Color strokeColor;
    private  int strokeWidth;

    public Right_Triangle(Point first_click, Point second_click, Color color, Color strokeColor, int strokeWidth) {
        this.first_click = first_click;
        this.second_click = second_click;
        this.color = color;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    @Override
    public void draw(Graphics g) {
//        int x1 = (int) first_click.getX();
//        int y1 = (int) first_click.getY();
//        int x2 = (int) second_click.getX();
//        int y2 = (int) second_click.getY();
//
//        g.setColor(color);
//        int[] xCoords = { x1, x1, x2 };
//        int[] yCoords = { y1, y2, y2 };
//
//        // draw the filled triangle
//        g.fillPolygon(xCoords, yCoords, 3);

        int x1 = first_click.x;
        int y1 = first_click.y;
        int x2 = second_click.x;
        int y2 = second_click.y;

        int base = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);

        int x3, y3;

        if (x1 < x2 && y1 < y2) {
            x3 = x1;
            y3 = y2;
        } else if (x1 < x2 && y1 > y2) {
            x3 = x2;
            y3 = y1;
        } else if (x1 > x2 && y1 < y2) {
            x3 = x2;
            y3 = y1;
        } else {
            x3 = x1;
            y3 = y2;
        }

        int[] xCoords = { x1, x2, x3 };
        int[] yCoords = { y1, y2, y3 };

        Graphics2D g2d = (Graphics2D) g;

        // Draw background triangle
        g2d.setColor(color);
        g2d.fillPolygon(xCoords, yCoords, 3);

        // Draw triangle with smaller size due to stroke width
        g2d.setColor(strokeColor);
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.drawPolygon(xCoords, yCoords, 3);

    }


    @Override
    public int size() {
        return Math.abs((first_click.x- second_click.x)* (first_click.y- second_click.y))/2;
    }

}

