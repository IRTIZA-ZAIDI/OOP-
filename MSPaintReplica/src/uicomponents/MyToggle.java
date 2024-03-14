package uicomponents;

import java.awt.*;

public class MyToggle extends MyButton {
    public MyToggle(int x, int y, int width, int height, Image i_depressed, Image i_pressed) {
        super(x, y, width, height, i_depressed, i_pressed);
    }

    @Override
    public boolean IsClicked(int x, int y) {
        if(x > this.x && x < this.x + width && y > this.y && y < this.y + height)
        {
            if(pressed==true) {
                this.current_image = image_depressed;
                pressed=false;
                return false;

            }
            else{
                this.current_image = image_pressed;
                pressed=true;
                return true;
            }
        }

        return false;
    }

    public int getY(){
        return y;

    }
    public void setY(int y){
        this.y=y;
    }
}
