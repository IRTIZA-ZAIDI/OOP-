package uicomponents;

import swigncomponents.Shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Stack;

public class LayerButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private String name;
    public boolean pressed;

    Image Depressed, Pressed, Current;
    MyToggle visibility;
    private Stack<Shapes> shapesStack = new Stack<>();
    private ArrayList<Shapes> redo_queue = new ArrayList<>();

    public boolean show_shapes;

    public boolean Show_visibility(){
        return visibility.pressed;
    }

    public LayerButton(int x, int y, int width, int height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        pressed = false;

        Pressed = new ImageIcon("Tick.png").getImage().getScaledInstance(20, 20, Image.SCALE_FAST);
        Depressed = new ImageIcon("Untick.png").getImage().getScaledInstance(20, 20, Image.SCALE_FAST);
        Current = Depressed;

        Image visiblity_on = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\visibility_on.png").getImage();
        Image visiblity_off = new ImageIcon("C:\\Users\\Irtiza\\Downloads\\src\\visibility_off.png").getImage();
        visibility = new MyToggle(this.x + width - 30, this.y + 4, 23, 23, visiblity_on, visiblity_off);

        show_shapes = true;


    }

    public void add(Shapes shapes) {
        System.out.println("added in arraylist");
        redo_queue.add(shapes);
    }

    public Shapes remove() {
        return redo_queue.remove(0);
    }

    public Stack<Shapes> stack_of_shapes() {
        return shapesStack;
    }

    public void push(Shapes shapes) {
        System.out.println("push in stack");
        shapesStack.push(shapes);
        System.out.println(shapesStack.size());
    }

    public Shapes pop() {
        System.out.println("removed from stack");
        System.out.println(shapesStack.size());
        return shapesStack.pop();
    }

    public boolean IsClicked(int x, int y) {
         visibility.IsClicked(x, y);
            if (visibility.IsPressed() == false) {
                show_shapes = true;
            } else  show_shapes=false;



        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {
            if (pressed == true) {
                pressed = false;
                Current = Depressed;
                return true;
            } else {
                pressed = true;
                Current = Pressed;
                return false;
            }
        } else
        {
            pressed = false;
            Current = Depressed;
            return false;
        }
    }


//                if (visibility.IsClicked(x, y) == true) {
//                    if (show_shapes == true) {
//                        show_shapes = false;
//                    }
//                } else show_shapes = true;


//                if (visibility.IsClicked(x, y) == true) {
//                    if (show_shapes == true) {
//                        show_shapes = false;
//                    } else show_shapes = true;
//                }
//                return true;
//            }






        public void paint (Graphics g, ImageObserver observer){
            g.setColor(Color.BLACK);
            g.fillRect(x, y, width, height);
            if (pressed == true) g.setColor(Color.BLUE);
            else g.setColor(Color.cyan);
            g.fillRect(x + 2, y + 2, width - 4, height - 4);

            Font font = new Font("Times New Roman", Font.PLAIN, 13);
            g.setFont(font);
            g.setColor(Color.BLACK);
            FontMetrics m = g.getFontMetrics();
            int s_width = m.stringWidth(name);
            int s_height = m.getAscent() - m.getDescent();
            g.drawString(name, x + width / 2 - s_width / 2, y + height / 2 + s_height / 2);

            g.drawImage(Current, x + 4, y + 6, observer);
            visibility.paint(g, observer);
        }

        public void setY (int y){
            this.y = y;
            this.visibility.setY(this.y+4);
        }
        public int getY () {
            return y;
        }
        public static void Exchange (LayerButton one, LayerButton two){
            int first_y = one.getY();
            one.setY(two.getY());
            two.setY(first_y);
        }
        public void setHeight ( int height){
            this.height = height;

        }

}





