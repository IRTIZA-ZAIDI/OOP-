package uicomponents;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Files_openButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private String name;
    public boolean pressed;

    public Files_openButton(int x, int y, int width, int height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        pressed=false;
    }

    public boolean IsClicked(int x, int y)
    {
        if(x > this.x && x < this.x + width && y > this.y && y < this.y + height)
        {
            pressed = true;
            return true;
        }
        pressed=false;
        return false;
    }

    public void paint(Graphics g, ImageObserver observer) {
       if(pressed){
           g.setColor(Color.BLUE);
       }else g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);
        g.setColor(Color.cyan);
        g.fillRect(x+2,y+2,width-4,height-4);

        Font font=new Font("Arial",Font.PLAIN,13);
        g.setFont(font);
        g.setColor(Color.BLACK);
        FontMetrics m=g.getFontMetrics();
        int s_width=m.stringWidth(name);
        int s_height=m.getAscent()-m.getDescent();
        g.drawString(name,x+width/2-s_width/2,y+height/2+s_height/2);
    }
}
