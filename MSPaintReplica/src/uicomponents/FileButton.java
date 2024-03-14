package uicomponents;

import swigncomponents.ButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class FileButton extends MyActive implements ButtonListener {
  //  Image File_open,File_save,File_new;


    public FileButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed) {
        super(x, y, width, height, i_depressed, i_pressed);

//        ImageIcon file_open = new ImageIcon("OPEN.png");
//        File_open=file_open.getImage(0,32,);
//
//        ImageIcon file_save = new ImageIcon("SAVE.png");
//        File_save=file_save.getImage();
//
//        ImageIcon file_new= new ImageIcon("NEW.png");
//        File_new=file_new.getImage();

    }



    @Override
    public void click(int x, int y) {

    }

}
