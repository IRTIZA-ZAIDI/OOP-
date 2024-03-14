package swigncomponents;

import java.awt.*;

public class Regular_Triangle extends Shapes {

    private Point first_click;
    private Point second_click;
    private Color color;
    private Color strokeColor;
    private  int strokeWidth;

    public Regular_Triangle(Point first_click, Point second_click, Color color, Color strokeColor, int strokeWidth) {
        this.first_click = first_click;
        this.second_click = second_click;
        this.color = color;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    @Override
    public void draw(Graphics g) {
        int centerX = (first_click.x + second_click.x) / 2;
        int centerY = (first_click.y + second_click.y) / 2;
        int sideLength = (int) (Math.sqrt(Math.pow(second_click.x - first_click.x, 2) + Math.pow(second_click.y - first_click.y, 2)));

        int[] xCoords = new int[3];
        int[] yCoords = new int[3];

        xCoords[0] = centerX;
        yCoords[0] = centerY - (int) (Math.sqrt(3) * sideLength / 3);
        xCoords[1] = centerX - sideLength / 2;
        yCoords[1] = centerY + (int) (Math.sqrt(3) * sideLength / 6);
        xCoords[2] = centerX + sideLength / 2;
        yCoords[2] = centerY + (int) (Math.sqrt(3) * sideLength / 6);

        Graphics2D g2d = (Graphics2D) g;

        // Draw background triangle
        g2d.setColor(color);
        g2d.fillPolygon(xCoords, yCoords, 3);

        // Draw triangle with smaller size due to stroke width
        g2d.setColor(strokeColor);
        g2d.setStroke(new BasicStroke(strokeWidth ));
        g2d.drawPolygon(xCoords, yCoords, 3);
    }


    @Override
    public int size() {
        return Math.abs((first_click.x- second_click.x)* (first_click.y- second_click.y))/2;
    }
}

