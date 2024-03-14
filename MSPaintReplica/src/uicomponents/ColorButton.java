package uicomponents;

import swigncomponents.ButtonListener;

import java.awt.*;
import java.awt.image.ImageObserver;

public class ColorButton  {
    public int x;
    public int y;
    private int width;
    private int height;
    private Color color;
    private Image image;
   public boolean pressed=false;
    private ButtonListener listener;

    public ColorButton(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public ColorButton(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image.getScaledInstance(width-4,height-4,Image.SCALE_FAST);
    }

    public boolean IsClicked(int x, int y) {
        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {
            pressed = true;
            return true;
        }
        else
        {
            pressed = false;
            return false;
        }
    }

    public Color IsClick(int x, int y) {
        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {

            return color;
        }
        return null;
    }


    public ButtonListener getListener() {
        return listener;
    }

//    public void paint(Graphics g) {
//        if (pressed=true){
//            g.setColor(Color.BLUE);
//        }
//        else{
//            g.setColor(Color.white);
//        }
//        g.drawRect(x,y,width,height);
//        g.setColor(color);
//        g.drawRect(x-2,y-2,width-4,height-4);
//
//
//    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color=color;
    }

    public void paint(Graphics g, ImageObserver observer) {
       if (pressed==true){
           g.setColor(Color.BLUE);
       }
       else g.setColor(Color.BLACK);

        g.fillRect(x,y,width,height);
        g.setColor(color);
       g.fillRect(x+2,y+2,width-4,height-4);
    }
    public void paintimage(Graphics g, ImageObserver observer) {

        g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);

        g.drawImage(image, x+2, y+2, observer);
    }

}
