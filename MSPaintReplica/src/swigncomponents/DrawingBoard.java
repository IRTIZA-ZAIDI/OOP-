package swigncomponents;

import uicomponents.LayerButton;
import uicomponents.ShapeButton;

import java.awt.*;
import java.util.ArrayList;

public class DrawingBoard implements PortionListener {
    private int x;
    private int y;
    private int width;
    private int height;
    private Shapes shape;
    private Free_drawing free_drawing;


    public DrawingBoard() {
        this.x = 0;
        this.y = 32;
        this.width = 830;
        this.height = 588;
    }

    @Override
    public void onClick(int x, int y) {
        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {
        }
    }

    public void paint(Graphics g) {

        for (LayerButton l : LayersToolbar.many_layers) {
            if (l.show_shapes==true) {
                for (Shapes s : l.stack_of_shapes()){
                    s.draw(g);
                }
            }
            if (shape != null) {
                shape.draw(g);
            }
        }
    }

    int x1;
    int y1;

    @Override
    public void onPress(int x, int y) {
        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {
          //  String current = ShapesToolbar.current_pressed();
            String current=null;
            for(ShapeButton s: ShapesToolbar.getShapes()){
                if(s.IsPressed()){
                    current=s.getShape_type();
                }
            }
            System.out.println(current);
            x1 = x;
            y1 = y;
            System.out.println(x1+" "+ y1);
            switch (current) {
                case "Circle":
                    shape = new Circle(0, new Point(x1, y1), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Rectangle":
                    shape = new Rectangle(new Point(x1,y1), new Point(x1, y1), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Right Triangle":
                    shape=new Right_Triangle(new Point(x1,y1), new Point(x1, y1),ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Pentagram":
                    shape=new Pentagram(new Point(x1,y1), new Point(x1, y1),ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Equilateral Triangle":
                    shape=new Regular_Triangle(new Point(x1,y1), new Point(x1, y1),ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Hexagon":
                    shape=new Hexagon(new Point(x1,y1), new Point(x1, y1),ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Free drawing":
                    free_drawing=new Free_drawing();
                    shape=free_drawing;
                    break;
                default: break;

            }

        }

    }

    int x2;
    int y2;

    @Override
    public void dragged(int x, int y) {
        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {
            String current=null;
            for(ShapeButton s: ShapesToolbar.getShapes()){
                if(s.IsPressed()){
                    current=s.getShape_type();
                }
            }
            int prev_x=x2;
            int prev_y=y2;
            x2 = x;
            y2 = y;
            switch (current) {
                case "Circle":
                    shape = new Circle((int) Math.sqrt((x2 - x1) * (x2 - x1) + (y1 - y2) * (y1 - y2)), new Point(x1, y1), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Rectangle":
                 //   shape = new Rectangle(y1 - y2, x1 - x2, new Point(x2, y2), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                   shape=new Rectangle(new Point(x1, y1), new Point(x2, y2),ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Right Triangle":
                    shape = new Right_Triangle(new Point(x1, y1), new Point(x2, y2), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Pentagram":
                    shape = new Pentagram(new Point(x1, y1), new Point(x2, y2), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Equilateral Triangle":
                    shape = new Regular_Triangle(new Point(x1, y1), new Point(x2, y2), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Hexagon":
                    shape = new Hexagon(new Point(x1, y1), new Point(x2, y2), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                    break;
                case "Free drawing":
                    Circle circle=new Circle(ColorToolbar.getCurrent_strokesize(),new Point(x2, y2),ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokesize());
                    free_drawing.add(circle);
                    break;
            }

        }
    }

    int x3;
    int y3;
    @Override
    public void onRelease(int x, int y) {

        if (Menubar.edit_pressed() == false && Menubar.file_pressed() == false && ColorToolbar.gradient_window_opened()==false && ColorToolbar.isShow_strokesize()==false) {
            if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {
                System.out.println(x3 + " " + y3);
                shape = null;
                // String current = ShapesToolbar.current_pressed();
                String current = null;
                for (ShapeButton s : ShapesToolbar.getShapes()) {
                    if (s.IsPressed()) {
                        current = s.getShape_type();
                    }
                }
                x3 = x;
                y3 = y;
                switch (current) {
                    case "Circle":
                        shape = new Circle((int) Math.sqrt((x3 - x1) * (x3 - x1) + (y1 - y3) * (y1 - y3)), new Point(x1, y1), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                        break;
                    case "Rectangle":
                        shape=new Rectangle(new Point(x1, y1), new Point(x3, y3),ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                        break;
                    case "Right Triangle":
                        shape = new Right_Triangle(new Point(x1, y1), new Point(x3, y3), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                        break;
                    case "Pentagram":
                        shape = new Pentagram(new Point(x1, y1), new Point(x3, y3), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                        break;
                    case "Equilateral Triangle":
                        shape = new Regular_Triangle(new Point(x1, y1), new Point(x3, y3), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                        break;
                    case "Hexagon":
                        shape = new Hexagon(new Point(x1, y1), new Point(x3, y3), ColorToolbar.getCurrent_fillcolor(),ColorToolbar.getCurrent_strokecolor(),ColorToolbar.getCurrent_strokesize());
                        break;
                    case "Free drawing":
                        shape = free_drawing;
                        free_drawing = null;
                        break;
                    default:
                        break;
                }
                for (LayerButton l : LayersToolbar.many_layers) {
                    if (l.pressed == true) {
                       l.push(shape);
                    }
                }
            }
            shape = null;
        }
    }
}
