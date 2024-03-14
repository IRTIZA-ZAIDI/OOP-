import java.awt.*;

public class Constants {

    static final int width = 800;
    static final int height = 700;
    static final int strokesize=2;
    static int cell_height=height/17;
    static Color text_color=Color.white;
    static Color cell_color=Color.GRAY;
    static Color cell_stroke_color=Color.BLUE;
    static Color Title_color=Color.BLACK;
    static Color Title_stroke_color=Color.GRAY;


    /**
     *
     * @param Cell Enter cell color
     * @param cell_stroke Enter cell stroke color
     * @param Title Enter title color
     * @param Title_stroke Enter title stroke color
     * @param text Enter text color
     */
    public static void SetColor(Color Cell, Color cell_stroke, Color Title, Color Title_stroke, Color text){
        cell_color=Cell;
        cell_stroke_color=cell_stroke;
        Title_color=Title;
        Title_stroke_color=Title_stroke;
        text_color=text;
    }






}
