
import java.awt.*;
import java.io.File;

public class DrawingCanvas extends Canvas {

    public void paint(Graphics g)
    {
        //file is inside the package , make adjustments in the data file
        Table T=new Table(new File("./src/Data.txt"));

        //adjust color accordingly before paintTitle
       // Constants.SetColor(Color.RED,Color.GREEN,Color.MAGENTA,Color.orange,Color.WHITE);
        T.paintTitle(g);

    }
}


