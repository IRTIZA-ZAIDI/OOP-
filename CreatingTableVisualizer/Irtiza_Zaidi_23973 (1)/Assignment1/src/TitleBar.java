import java.awt.*;

public class TitleBar extends Cell{

    /**
     *
     * @param x x topleft postion of title bar
     * @param y y topleft position of title bar
     * @param width width of title bar
     * @param height height of title bar
     * @param cell_color color of title bar
     * @param stroke_color stroke color of title bar
     * @param stroke stroke size
     * @param text text of title
     */
    public TitleBar(int x, int y, int width, int height, Color cell_color, Color stroke_color, int stroke, String text) {
       super(x,y,width,height,cell_color,stroke_color,stroke,text);

    }

    //DRAWS TITLE BAR BY CALLING SUPER PAINT FUNCTION IN CELL AND ADDS A BUTTON
    public void paintTitle(Graphics g){
        super.paintHighlighted(g);

        // TO DRAW RED BUTTON ON RIGHT OF TITLE BAR
        g.setColor(stroke_color);
        g.fillRect(Constants.width-width/15 , height/10,8*height/10, 8*height/10);
        g.setColor(Color.RED);
        g.fillRect(Constants.width-width/15 + stroke, height/10+ stroke ,8*height/10- stroke*2, 8*height/10- stroke*2);


    }
}
