package uicomponents;

import swigncomponents.ButtonListener;

import java.awt.*;

public class EditButton extends MyActive implements ButtonListener {
    public EditButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed) {
        super(x, y, width, height, i_depressed, i_pressed);
    }



    @Override
    public void click(int x, int y) {

    }
}