package swigncomponents;

import uicomponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class LayersToolbar implements PortionListener{
    private int x;
    private int y;
    private int width;
    private int height;

    private ArrayList<MyButton> command=new ArrayList<>();
    protected static ArrayList<LayerButton> many_layers=new ArrayList<>();
    protected static LayerButton selected;

    private Image Add_pressed,Remove_pressed,Up_pressed,Down_pressed;
    private Image Add_unpressed,Remove_unpressed,Up_unpressed,Down_unpressed;
    private Image layer_head;
    private MyButton Add,Remove,Up,Down;
    private int layer_num=1;
    private String S="Layer : ";
    private int l_height=32;
    private int l_width=250;

    public LayersToolbar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        Add_pressed = new ImageIcon("Add_pressed.png").getImage();
        Add_unpressed = new ImageIcon("Add_unpressed.png").getImage();
       Add=new MyActive(840,678,50,32,Add_unpressed,Add_pressed);
        command.add(Add);

        Remove_pressed = new ImageIcon("Remove_pressed.png").getImage();
        Remove_unpressed = new ImageIcon("Remove_unpressed.png").getImage();
        Remove=new MyActive(900,678,50,32,Remove_unpressed,Remove_pressed);
        command.add(Remove);

        Up_pressed = new ImageIcon("Up_pressed.png").getImage();
        Up_unpressed = new ImageIcon("Up_unpressed.png").getImage();
        Up=new MyActive(960,678,50,32,Up_unpressed,Up_pressed);
        command.add(Up);

        Down_pressed = new ImageIcon("Down_pressed.png").getImage();
        Down_unpressed = new ImageIcon("Down_unpressed.png").getImage();
        Down=new MyActive(1020,678,50,32,Down_unpressed,Down_pressed);
        command.add(Down);

        layer_head=new ImageIcon("LAYERS (1).png").getImage().getScaledInstance(250,32,Image.SCALE_FAST);


        many_layers.add(new LayerButton(830,64,l_width,l_height,S+layer_num));
        selected=null;

    }
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x+2,y+2,width-4,height-4);

        g.setColor(Color.BLACK);
        g.fillRect(830,668,250,100);
        g.setColor(Color.GRAY);
        g.fillRect(832,670,256,96);

        g.drawImage(layer_head,x,y,observer);
        for (MyButton b : command)
        {
            b.paint(g, observer);
        }

        if(Add.IsPressed()){
            if(many_layers.toArray().length<19)
            {
                layer_num++;
                many_layers.add(new LayerButton(830,32+l_height*(many_layers.toArray().length+1                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ),l_width,l_height,S+layer_num));
                Add.SetPressed(false);
            }
           else {
            g.setColor(Color.BLACK);
            g.fillRect(x,y-32,width,32);
            g.setColor(Color.RED);
            g.fillRect(x+2,y-30,width-4,32-4);
            g.setColor(Color.BLACK);
            g.drawString("Layers limit reached",x+5,y-14);
                }
        }

        if(Remove.IsPressed()){
            for(int i=0;i<many_layers.toArray().length;i++)
            {
                if(many_layers.get(i).pressed==true){
                    many_layers.remove(many_layers.get(i));
                }
            }
            New_position();
            Remove.SetPressed(false);
        }
        if(Up.IsPressed()){
            for(int i=1;i<many_layers.toArray().length;i++)
            {
               if(many_layers.get(i).pressed==true && i!=many_layers.toArray().length){
                   LayerButton l1=many_layers.get(i);
                   LayerButton l2=many_layers.get(i-1);
                   many_layers.set(i,l2);
                   many_layers.set(i-1,l1);
                   LayerButton.Exchange(l1,l2);
               }
            }

            Up.SetPressed(false);
        }

        if(Down.IsPressed())
        {
            for(int i=many_layers.toArray().length-1;i>=0;i--)
            {
                if((many_layers.get(i).pressed==true) && (i<many_layers.toArray().length-1)){
                    LayerButton l1=many_layers.get(i);
                    LayerButton l2=many_layers.get(i+1);
                    many_layers.set(i,l2);
                    many_layers.set(i+1,l1);
                    LayerButton.Exchange(l1,l2);
                }
            }
            Down.SetPressed(false);
        }


        for(LayerButton l:many_layers)
        {
            l.paint(g,observer);
        }


    }

    public void New_position()
    {
        int starty=64;
        int i=0;
       for(LayerButton s:many_layers){
               many_layers.get(i).setY(starty + (i*l_height));
               i++;
       }
    }

    @Override
    public void onClick(int x, int y) {
        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height)
        {
            for (MyButton s : command)
            {
                s.IsClicked(x, y);
            }
        }

        if(x > this.x && x < this.x + width && y > this.y && y < 720-50)
        for (LayerButton s : many_layers)
        {
            if(s.IsClicked(x, y)==true) {
                selected=s;
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
