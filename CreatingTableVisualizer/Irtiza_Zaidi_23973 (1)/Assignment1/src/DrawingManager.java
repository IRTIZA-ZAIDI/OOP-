import javax.swing.JFrame;
import java.awt.*;


public class DrawingManager {
    public DrawingManager() {
    }
    public static void main(String[] args) {

        DrawingCanvas canvas=new DrawingCanvas();
        JFrame frame=new JFrame();
        frame.add(canvas);
        frame.setSize(Constants.width,Constants.height);
        frame.setVisible(true);
















    }
}