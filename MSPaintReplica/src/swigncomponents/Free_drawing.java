package swigncomponents;

import java.awt.*;
import java.util.ArrayList;

public class Free_drawing extends Shapes{
    ArrayList<Circle> circles=new ArrayList<>();

    public void add(Circle circle){
        circles.add(circle);
    }


    @Override
    public void draw(Graphics g) {
        for(Circle c:circles){
            c.draw(g);
        }

    }

    @Override
    public int size() {
        return 20;
    }
}
