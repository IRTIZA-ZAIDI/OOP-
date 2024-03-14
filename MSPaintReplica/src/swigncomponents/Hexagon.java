package swigncomponents;

import java.awt.*;

public class Hexagon extends Shapes{
    private Point first_click;
    private Point second_click;
    private Color color;
    private Color strokeColor;
    private  int strokeWidth;

    public Hexagon(Point first_click, Point second_click, Color color, Color strokeColor, int strokeWidth) {
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
        int sideLength = (int) (Math.sqrt(Math.pow(second_click.x - first_click.x, 2) + Math.pow(second_click.y - first_click.y, 2)) / 2);

        int[] xCoords = new int[6];
        int[] yCoords = new int[6];

        for (int i = 0; i < 6; i++) {
            xCoords[i] = (int) (centerX + sideLength * Math.cos(2 * Math.PI * i / 6));
            yCoords[i] = (int) (centerY + sideLength * Math.sin(2 * Math.PI * i / 6));
        }

        Graphics2D g2d = (Graphics2D) g;

        // Draw background hexagon
        g2d.setColor(color);
        g2d.fillPolygon(xCoords, yCoords, 6);

        // Draw hexagon with smaller size due to stroke width
        g2d.setColor(strokeColor);
        g2d.setStroke(new BasicStroke(strokeWidth ));
        g2d.drawPolygon(xCoords, yCoords, 6);
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override
    public int size() {
        int sideLength = (int) (Math.sqrt(Math.pow(second_click.x - first_click.x, 2) + Math.pow(second_click.y - first_click.y, 2)) / 2);
        int size = (int) (3 * Math.sqrt(3) * (sideLength ^ 2) / 2);
        return size;
    }
}
