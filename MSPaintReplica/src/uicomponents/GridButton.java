package uicomponents;

import java.awt.*;

public class GridButton extends MyButton{
    private int clicks;
    private Image i_pressed2;
    private Image i_pressed3;
    private Image i_pressed4;
    private Image i_pressed5;
    private Image i_pressed6;


    public GridButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed1,Image i_pressed2,Image i_pressed3,Image i_pressed4,Image i_pressed5,Image i_pressed6) {
        super(x, y, width, height, i_depressed, i_pressed1);
        clicks=0;
        this.i_pressed2=i_pressed2;
        this.i_pressed3=i_pressed3;
        this.i_pressed4=i_pressed4;
        this.i_pressed5=i_pressed5;
        this.i_pressed6=i_pressed6;
    }

    public boolean IsClicked(int x, int y)
    {
        if(x > this.x && x < this.x + width && y > this.y && y < this.y + height)
        {
            pressed = true;
            clicks++;
           if(clicks==1) this.current_image = image_pressed;
           else if(clicks==2) this.current_image = i_pressed2;
           else if(clicks==3) this.current_image = i_pressed3;
           else if(clicks==4) this.current_image = i_pressed4;
           else if(clicks==5) this.current_image = i_pressed5;
           else if(clicks==6) this.current_image = i_pressed6;
           else{
               clicks=0;
               this.current_image =image_depressed;
           }
            return true;
        }
       // this.current_image =image_depressed;
        pressed=false;
        return false;
    }
}
