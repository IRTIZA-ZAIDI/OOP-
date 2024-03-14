package swigncomponents;

import uicomponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class ColorToolbar implements PortionListener {
    private int x;
    private int y;
    private int width;
    private int height;
    private ArrayList<ColorButton> color_buttons = new ArrayList<>();
    private ColorButton fill, stroke;
    private static boolean gradient_press;
    private ColorGradient cg;
    private MyButton Close, gradient, grid,stroke_size;
    private Image close;
    private MyButton select;
    private Image FillText, GradientText, GridText, StrokeText,Strokesize_text;
    private static boolean show_strokesize;
    private ArrayList<StrokeButton> stroke_sizes=new ArrayList<>();
    public static Color current_fillcolor;
    public static Color current_strokecolor;
    public static int current_strokesize;

    public ColorToolbar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        //adding pre build color buttons
        color_buttons.add(new ColorButton(x + 160, y + 10, 20, 20, Color.BLACK));
        color_buttons.add(new ColorButton(x + 160 + 30, y + 10, 20, 20, Color.GRAY));
        color_buttons.add(new ColorButton(x + 160 + 30 * 2, y + 10, 20, 20, Color.RED));
        color_buttons.add(new ColorButton(x + 160 + 30 * 3, y + 10, 20, 20, Color.ORANGE));
        color_buttons.add(new ColorButton(x + 160 + 30 * 4, y + 10, 20, 20, Color.YELLOW));
        color_buttons.add(new ColorButton(x + 160 + 30 * 5, y + 10, 20, 20, Color.GREEN));
        color_buttons.add(new ColorButton(x + 160, y + 10 + 30, 20, 20, Color.BLUE));
        color_buttons.add(new ColorButton(x + 160 + 30, y + 10 + 30, 20, 20, Color.CYAN));
        color_buttons.add(new ColorButton(x + 160 + 30 * 2, y + 10 + 30, 20, 20, Color.PINK));
        color_buttons.add(new ColorButton(x + 160 + 30 * 3, y + 10 + 30, 20, 20, Color.WHITE));
        color_buttons.add(new ColorButton(x + 160 + 30 * 4, y + 10 + 30, 20, 20, Color.LIGHT_GRAY));
        color_buttons.add(new ColorButton(x + 160 + 30 * 5, y + 10 + 30, 20, 20, Color.magenta));

        //buttons tht can be set using gradient
        color_buttons.add(new ColorButton(x + 160, y + 10 + 60, 20, 20, Color.WHITE));
        color_buttons.add(new ColorButton(x + 160 + 30, y + 10 + 60, 20, 20, Color.WHITE));
        color_buttons.add(new ColorButton(x + 160 + 30 * 2, y + 10 + 60, 20, 20, Color.WHITE));
        color_buttons.add(new ColorButton(x + 160 + 30 * 3, y + 10 + 60, 20, 20, Color.WHITE));
        color_buttons.add(new ColorButton(x + 160 + 30 * 4, y + 10 + 60, 20, 20, Color.WHITE));
        color_buttons.add(new ColorButton(x + 160 + 30 * 5, y + 10 + 60, 20, 20, Color.WHITE));

        //fill,stroke and gradient
        fill = new ColorButton(x + 10, y + 10, 60, 60, Color.WHITE);
        FillText = new ImageIcon("Fill_text.png").getImage().getScaledInstance(60 - 4, 20 - 4, Image.SCALE_FAST);

        stroke = new ColorButton(x + 80, y + 10, 60, 60, Color.WHITE);
        StrokeText = new ImageIcon("stroke_text.png").getImage().getScaledInstance(60 - 4, 20 - 4, Image.SCALE_FAST);

        Image grad = new ImageIcon("gradient.png").getImage();
        gradient = new MyActive(x + 350, y + 10, 60, 60, grad, grad);
        gradient_press = false;
        GradientText = new ImageIcon("gradient_text.png").getImage().getScaledInstance(60 - 4, 20 - 4, Image.SCALE_FAST);

        Image grid_off = new ImageIcon("grid_off.png").getImage();
        Image grid_2x2 = new ImageIcon("2x2.png").getImage();
        Image grid_4x4 = new ImageIcon("4x4.png").getImage();
        Image grid_8x8 = new ImageIcon("8x8.png").getImage();
        Image grid_16x16 = new ImageIcon("16x16.png").getImage();
        Image grid_32x32 = new ImageIcon("32x32.png").getImage();
        Image grid_64x64 = new ImageIcon("64x64.png").getImage();
        grid = new GridButton(x + 420, y + 10, 60, 60, grid_off, grid_2x2,grid_4x4,grid_8x8,grid_16x16,grid_32x32,grid_64x64);
        GridText = new ImageIcon("grid_text.png").getImage().getScaledInstance(60 - 4, 20 - 4, Image.SCALE_FAST);

        //stroke button
        Image stroke_pic= new ImageIcon("stroke_size.png").getImage();
        stroke_size = new MyActive(x + 490, y + 10, 100, 60, stroke_pic, stroke_pic);
        Strokesize_text=new ImageIcon("strokesize_text.png").getImage().getScaledInstance(100 - 4, 20 - 4, Image.SCALE_FAST);
        show_strokesize=false;
        //stroke variations
        Image one_unpressed = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\16.png").getImage();
        Image one_pressed = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\17.png").getImage();
        stroke_sizes.add(new StrokeButton(x+490,y+10-32,100,32,one_unpressed,one_pressed,10));

        Image two_unpressed = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\18.png").getImage();
        Image two_pressed = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\19.png").getImage();
        stroke_sizes.add(new StrokeButton(x+490,y+10-32*2,100,32,two_unpressed,two_pressed,8));

        Image three_unpressed = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\20.png").getImage();
        Image three_pressed = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\21.png").getImage();
        stroke_sizes.add(new StrokeButton(x+490,y+10-32*3,100,32,three_unpressed,three_pressed,6));

        Image four_unpressed = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\22.png").getImage();
        Image four_pressed = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\23.png").getImage();
        stroke_sizes.add(new StrokeButton(x+490,y+10-32*4,100,32,four_unpressed,four_pressed,4));

        //gradient window
        cg = new ColorGradient(250, 90, 500, 500);

        //setting close for gradient window
        close = new ImageIcon("cross.png").getImage();
        Close = new MyActive(715, 92, 33, 33, close, close);

        //select icon for gradient color
        Image Select = new ImageIcon("Select.png").getImage();
        select = new MyActive(530, 500, 150, 50, Select, Select);

        current_fillcolor=Color.white;
        current_strokecolor=Color.white;
        current_strokesize=0;

    }

    public static Color getCurrent_fillcolor(){
        return current_fillcolor;
    }
    public static Color getCurrent_strokecolor(){
        return current_strokecolor;
    }
    public static int getCurrent_strokesize(){
        return current_strokesize;
    }
    public static boolean gradient_window_opened(){
        return gradient_press;
    }
    public static boolean isShow_strokesize(){
        return show_strokesize;
    }


    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width + 4, height + 4);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x + 2, y + 2, width, height);
        g.setColor(Color.GRAY);
        g.fillRect(x + 150, y + 2, 190, height);

        for (ColorButton b : color_buttons) {
            b.paint(g, observer);
        }

        fill.paint(g, observer);
        g.setColor(Color.BLACK);
        g.fillRect(x + 10, y + 70, 60, 18);
        g.drawImage(FillText, x + 12, y + 70, observer);

        stroke.paint(g, observer);
        g.setColor(Color.BLACK);
        g.fillRect(x + 80, y + 70, 60, 18);
        g.drawImage(StrokeText, x + 82, y + 70, observer);

        g.setColor(Color.BLACK);
        gradient.paint(g, observer);
        g.fillRect(x + 350, y + 70, 60, 20);
        g.drawImage(GradientText, x + 352, y + 72, observer);

        grid.paint(g, observer);
        g.fillRect(x + 420, y + 70, 60, 20);
        g.drawImage(GridText, x + 422, y + 72, observer);

        stroke_size.paint(g,observer);
        g.fillRect(x + 490, y + 70, 100, 20);
        g.drawImage(Strokesize_text, x + 492, y + 72, observer);

        if(show_strokesize==true){
            for(MyButton b:stroke_sizes){
                b.paint(g,observer);
            }
        }


        if (gradient_press == true) {
            cg.Draw(g, observer);
            Close.paint(g, observer);
            g.setColor(Color.BLACK);
            g.fillRect(528, 498, 154, 54);
            select.paint(g, observer);
        }
    }

    @Override
    public void onClick(int x, int y) {

        //selecting fill or stroke
        if (x > this.x && x < this.x + 140 && y > this.y+10 && y < this.y+60) {
            fill.IsClicked(x, y);
            stroke.IsClicked(x, y);
        }

        //grid
        if(x > this.x+420 && x < this.x +480 && y > this.y+10 && y < this.y +60 ){
            grid.IsClicked(x,y);
        }

        //stroke size button
        if(x > this.x+490 && x < this.x +590 && y > this.y+10 && y < this.y +60 ){
            if(stroke_size.IsClicked(x,y)==true){
                show_strokesize=true;
            }
        }
        if(show_strokesize==true){
            for(StrokeButton b:stroke_sizes){
                if(b.IsClicked(x,y)==true){
                    current_strokesize=b.getStroke();
                    show_strokesize=false;
                    for(MyButton a:stroke_sizes){
                        if(a!=b){
                            a.SetPressed(false);
                        }
                    }
                }
            }
        }


        //if fill or stroke is pressed and another color button pressed transfer that color to fill or stroke
        if (x > this.x + 150 && x < this.x + 150 + 190 && y > this.y && y < this.y + 100) {
            for (ColorButton b : color_buttons) {
                b.IsClicked(x, y);
                if (b.IsClicked(x, y) == true) {
                    if (fill.pressed) {
                        fill.setColor(b.getColor());
                        current_fillcolor=b.getColor();
                    } else if (stroke.pressed) {
                        stroke.setColor(b.getColor());
                        current_strokecolor=b.getColor();
                    }
                }
            }
        }

        //clicking on gradient
        if (x > this.x + 350 && x < this.x + 350 + 60 + 140 && y > this.y + 10 && y < this.y + 10 + 60) {
            if (gradient.IsClicked(x, y) == true) {
                gradient_press = true;

            }
        }

        //if gradient button is pressed then display gradient window and close button
        if (gradient_press == true) {
            cg.IsClick(x, y);
            if (Close.IsClicked(x, y) == true) {

                gradient_press = false;
            }
            //send selected color to color button
            if (select.IsClicked(x, y) == true) {
                fillColor(cg.getColor());
                gradient_press = false;
            }
        }
        //can only be added to last 6 buttons

    }

    int count = 0;

    public void fillColor(Color color) {
        color_buttons.get(12 + count).setColor(color);
        count++;
        if (count == 6) count = 0;
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
