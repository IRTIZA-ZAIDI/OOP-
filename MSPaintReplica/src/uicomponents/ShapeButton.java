package uicomponents;

import swigncomponents.ButtonListener;

import java.awt.*;

public class ShapeButton extends MyToggle implements ButtonListener {
    private String shape_type;
    public ShapeButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed,String shape_type) {
        super(x, y, width, height, i_depressed, i_pressed);
        this.shape_type=shape_type;
    }

    public String getShape_type(){
        return shape_type;
    }

    @Override
    public void click(int x, int y) {

    }
}
