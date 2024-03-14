package uicomponents;

import swigncomponents.ButtonListener;

import java.awt.*;

public class RtriangleButton extends MyToggle implements ButtonListener {
    public RtriangleButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed) {
        super(x, y, width, height, i_depressed, i_pressed);
    }



    @Override
    public void click(int x, int y) {

    }
}
