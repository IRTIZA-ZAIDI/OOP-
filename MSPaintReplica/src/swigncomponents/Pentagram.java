package swigncomponents;

import java.awt.*;

public class Pentagram extends Shapes {

    private Point first_click;
    private Point second_click;
    private Color color;
    private Color strokeColor;
    private  int strokeWidth;

    public Pentagram(Point first_click, Point second_click, Color color, Color strokeColor, int strokeWidth) {
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
        int radius = (int) (Math.sqrt(Math.pow(second_click.x - first_click.x, 2) + Math.pow(second_click.y - first_click.y, 2)) / 2);

        int[] xCoords = new int[10];
        int[] yCoords = new int[10];

        for (int i = 0; i < 10; i++) {
            double angleRad = 2 * Math.PI * i / 10 + Math.PI / 2;
            double x = centerX + radius * Math.cos(angleRad) * (i % 2 == 0 ? 1 : 0.5);
            double y = centerY + radius * Math.sin(angleRad) * (i % 2 == 0 ? 1 : 0.5);
            xCoords[i] = (int) x;
            yCoords[i] = (int) y;
        }

        Graphics2D g2d = (Graphics2D) g;

        // Draw background star
        g2d.setColor(color);
        g2d.fillPolygon(xCoords, yCoords, 10);

        // Draw star with smaller size due to stroke width
        g2d.setColor(strokeColor);
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.drawPolygon(xCoords, yCoords, 10);
    }



    @Override
    public int size() {
        int r = (int) Math.sqrt(Math.pow((first_click.x + second_click.x) / 2 - first_click.x, 2) + Math.pow((first_click.y +second_click.y) / 2 - first_click.y, 2));
        double size = 2 * r * Math.sin(Math.toRadians(54));
        return (int) size;
    }

}

