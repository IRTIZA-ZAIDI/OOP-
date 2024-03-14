package swigncomponents;

import uicomponents.Files_openButton;
import uicomponents.MyActive;
import uicomponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;

public class OpenWindow {
    private String []file_avaible;
    private int x, y, width, height;
    boolean ispressed=true;

    ArrayList<Files_openButton>files_button;

  Image close;
  MyButton Close;

  private int button_height;

    public OpenWindow(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        file_read();

        files_button=new ArrayList<>(file_avaible.length);

       if(((height-height/15)/file_avaible.length)>32){
           button_height=32;
       }
       else {
           button_height=(height-height/15)/file_avaible.length;
       }
        for(int i=0;i< file_avaible.length;i++){
            files_button.add(new Files_openButton(x+2,(y+height/12)+i*button_height,width-4,button_height,file_avaible[i]));

    }

        Image close=new ImageIcon("cross.png").getImage();
        Close= new MyActive(715, 92, 33, 33, close, close) ;
    }

    public void IsClick(int x, int y) {



        for(Files_openButton f:files_button){
            f.IsClicked(x,y);
        }
       if(Close.IsClicked(x,y)==true){
           ispressed=false;
        }
       else ispressed=true;

    }



    public void file_read(){
        String folderPath = "Open";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        file_avaible=new String[files.length];


        for (int i=0;i< files.length;i++) {
            if (files[i].isFile()) {
                file_avaible[i]=files[i].getName();
            }
        }

    }

    public void paint(Graphics g, ImageObserver observer){

        int stroke = 2;
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x + stroke, y + stroke, width - 2 * stroke, height - 2 * stroke);

        g.setColor(Color.GRAY);
        g.fillRect(x + stroke, y + stroke, width - 2 * stroke, height / 15);
        g.setColor(Color.BLACK);
        g.drawString("OPEN FILES",x+10,y+22);

            for(Files_openButton f:files_button){
                f.paint(g,observer);
            }
            Close.paint(g,observer);




    }
}
