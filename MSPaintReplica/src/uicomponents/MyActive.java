package uicomponents;

import java.awt.*;

public class MyActive extends MyButton{
    public MyActive(int x, int y, int width, int height, Image i_depressed, Image i_pressed) {
        super(x, y, width, height, i_depressed, i_pressed);
    }

    public boolean IsClicked(int x, int y)
    {
        if(x > this.x && x < this.x + width && y > this.y && y < this.y + height)
        {
            pressed = true;
            this.current_image = image_pressed;
            return true;
        }
        this.current_image =image_depressed;
        pressed=false;
        return false;
    }
}
