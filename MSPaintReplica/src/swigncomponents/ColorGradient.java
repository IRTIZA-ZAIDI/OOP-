package swigncomponents;

import uicomponents.ColorButton;
import uicomponents.GradientColorButton;
import uicomponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Locale;

public class ColorGradient {
    private int x, y, width, height;
    GradientColorButton[][] Gradient = new GradientColorButton[256][256];
    private ColorButton display_color;

     private Color current;
    private MyButton select;


    public ColorGradient(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;


        for (int row = 0; row < 256; row++)
        {
            float saturation = (float) (row) / 256;

            for (int col = 0; col < 256; col++) {
                float hue = (float) (col) / 256;
                Color color = Color.getHSBColor(hue, saturation, 1.f);
                Gradient[row][col] = new GradientColorButton(474 + col, 180 + row, 1, 1, color);
            }
        }
        display_color = new ColorButton(290, 200, 100, 100, Color.white);

    }


    public void Draw(Graphics g, ImageObserver observer) {
        int stroke = 2;
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x + stroke, y + stroke, width - 2 * stroke, height - 2 * stroke);

        g.setColor(Color.GRAY);
        g.fillRect(x + stroke, y + stroke, width - 2 * stroke, height / 15);
        g.setColor(Color.BLACK);
        g.drawString("COLOR GRADIENT", x + 10, y + 22);

        for (int row = 0; row < 256; row++) {
            for (int col = 0; col < 256; col++) {
                Gradient[row][col].paint(g, observer); // Print the color at each pixel
            }

        }

        g.setColor(Color.BLACK);
        g.fillRect(290, 200, 100, 100);
        display_color.paint(g, observer);

        g.setColor(Color.BLACK);
        g.fillRect(290, 350, 100, 32);
        g.setColor(Color.GRAY);
        g.fillRect(290 + stroke, 350 + stroke, 100 - 2 * stroke, 32 - 2 * stroke);
        g.setColor(Color.RED);
        g.drawString("RED:   " + display_color.getColor().getRed(), 295, 370);

        g.setColor(Color.BLACK);
        g.fillRect(290, 400, 100, 32);
        g.setColor(Color.GRAY);
        g.fillRect(290 + stroke, 400 + stroke, 100 - 2 * stroke, 32 - 2 * stroke);
        g.setColor(Color.BLUE);
        if (display_color != null)
            g.drawString("BLUE:   " + display_color.getColor().getBlue(), 295, 420);

        g.setColor(Color.BLACK);
        g.fillRect(290, 450, 100, 32);
        g.setColor(Color.GRAY);
        g.fillRect(290 + stroke, 450 + stroke, 100 - 2 * stroke, 32 - 2 * stroke);
        g.setColor(Color.GREEN);
        if (display_color != null)
            g.drawString("GREEN:  " + display_color.getColor().getGreen(), 295, 470);


    }

    public void IsClick(int x, int y) {

            for (int row = 0; row < 256; row++)
            {
                for (int col = 0; col < 256; col++)
                {
                    if (Gradient[row][col].IsClicked(x, y) == true)
                    {
                        display_color.setColor(Gradient[row][col].IsPressed(x,y));
                    }
            }
        }

    }

    public Color getColor(){
        return display_color.getColor();
    }
}


