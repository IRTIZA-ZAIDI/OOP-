package swigncomponents;

import uicomponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class ShapesToolbar implements PortionListener{
        private int x;
        private int y;
        private int width;
        private int height;
        private ShapeButton Rtriangle,Etriangle,Rectangle,Circle,Hexagon,Pentagon,Free_pen,Cancel;
        private Image Rtriangle_pressed,Etriangle_pressed,Rectangle_pressed,Circle_pressed,Hexagon_pressed,Pentagon_pressed;
        private Image Rtriangle_unpressed,Etriangle_unpressed,Rectangle_unpressed,Circle_unpressed,Hexagon_unpressed,Pentagon_unpressed;
        private static String current;

    static ArrayList<ShapeButton> shapes = new ArrayList<>();



    public ShapesToolbar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        Rtriangle_unpressed = new ImageIcon("Rtriangle_unpressed.png").getImage();
        Rtriangle_pressed = new ImageIcon("Rtriangle_pressed.png").getImage();
        Rtriangle=new ShapeButton(2,618,50,50,Rtriangle_unpressed,Rtriangle_pressed,"Right Triangle");
        shapes.add(Rtriangle);

        Etriangle_unpressed = new ImageIcon("Etriangle_unpressed.png").getImage();
        Etriangle_pressed = new ImageIcon("Etriangle_pressed.png").getImage();
        Etriangle=new ShapeButton(52,618,50,50,Etriangle_unpressed,Etriangle_pressed,"Equilateral Triangle");
        shapes.add(Etriangle);

        Rectangle_unpressed = new ImageIcon("Rectangle_unpressed.png").getImage();
        Rectangle_pressed = new ImageIcon("Rectangle_pressed.png").getImage();
        Rectangle=new ShapeButton(102,618,50,50,Rectangle_unpressed,Rectangle_pressed,"Rectangle");
        shapes.add(Rectangle);

        Circle_unpressed = new ImageIcon("Circle_unpressed.png").getImage();
        Circle_pressed = new ImageIcon("Circle_pressed.png").getImage();
        Circle=new ShapeButton(2,668,50,50,Circle_unpressed,Circle_pressed,"Circle");
        shapes.add(Circle);

        Hexagon_unpressed = new ImageIcon("Hexagon_unpressed.png").getImage();
        Hexagon_pressed = new ImageIcon("Hexagon_pressed.png").getImage();
        Hexagon=new ShapeButton(52,668,50,50,Hexagon_unpressed,Hexagon_pressed,"Hexagon");
        shapes.add(Hexagon);

        Pentagon_unpressed = new ImageIcon("Pentagram_unpressed.png").getImage();
        Pentagon_pressed = new ImageIcon("Pentagram_pressed.png").getImage();
        Pentagon=new ShapeButton(102,668,50,50,Pentagon_unpressed,Pentagon_pressed,"Pentagram");
        shapes.add(Pentagon);

        Image cancel=new ImageIcon("shape_cross.png").getImage();
        Cancel=new ShapeButton(152,668,50,50,cancel,cancel,"cancel");
        shapes.add(Cancel);

        Image free_pen_pressed=new ImageIcon("pen_press.png").getImage();
        Image free_pen_unpressed=new ImageIcon("pen_unpress.png").getImage();
        Free_pen=new ShapeButton(152,618,50,50,free_pen_unpressed,free_pen_pressed,"Free drawing");
        shapes.add(Free_pen);

        current="";
    }
    public void paint(Graphics g, ImageObserver observer) {
       g.setColor(Color.BLACK);
       g.fillRect(x,y-4,202,104);

        for (MyButton b : shapes)
        {
            b.paint(g, observer);
        }
    }

    public static ArrayList<ShapeButton> getShapes() {
        return shapes;
    }

    public static String current_pressed(){
        return current;
    }

    @Override
    public void onClick(int x, int y) {
        if (x > this.x && x < this.x + 202 && y > this.y && y < this.y + 616) {
            int count=0;
            for (ShapeButton s : shapes) {
                if (s.IsClicked(x, y) == true) {
                    current=s.getShape_type();
                    for (MyButton a : shapes) {
                        if (a != s) {
                            a.SetPressed(false);
                        }

                    }
                }
            }

        }
    }

    @Override
    public void onPress(int x, int y) {

    }

    @Override
    public void onRelease(int x, int y) {

    }

    @Override
    public void dragged(int x, int y) {

    }

}
