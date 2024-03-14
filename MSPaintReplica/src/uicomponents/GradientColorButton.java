package uicomponents;

import swigncomponents.ButtonListener;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GradientColorButton {
    public int x;
    public int y;
    private int width;
    private int height;
    private Color color;
    private Image image;
    public boolean pressed=false;
    private ButtonListener listener;

    public GradientColorButton(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public boolean IsClicked(int x, int y) {
        if (x >= this.x && x < this.x + width && y >= this.y && y < this.y + height) {
            pressed = true;
            return true;
        }
        else
        {
            pressed = false;
            return false;
        }
    }

    public Color IsPressed(int x, int y) {
        if (x >= this.x && x < this.x + width && y >= this.y && y < this.y + height) {
            pressed = true;
            return color;
        }
        else
        {
            pressed = false;
            return null;
        }
    }



    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color=color;
    }

    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(color);
        g.fillRect(x,y,width,height);

    }

}
