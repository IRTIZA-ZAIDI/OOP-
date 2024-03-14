package uicomponents;

import java.awt.*;

public class StrokeButton extends MyToggle {
    private int stroke;

    public StrokeButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed, int stroke) {
        super(x, y, width, height, i_depressed, i_pressed);
        this.stroke = stroke;
    }

    public int getStroke() {
        return stroke;
    }
}
