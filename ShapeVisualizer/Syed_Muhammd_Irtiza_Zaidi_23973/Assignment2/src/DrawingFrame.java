import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class DrawingFrame extends JFrame implements ActionListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Program");

        frame.setDefaultCloseOperation(3);
        DrawingPanel panel = new DrawingPanel();

        frame.add(panel);

        //IF FRAME IS CLOSED GO TO PANEL FUNCTION TO FILE
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               panel.Tofile(new File("src/data"));
            }
        });




            frame.pack();
            frame.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
