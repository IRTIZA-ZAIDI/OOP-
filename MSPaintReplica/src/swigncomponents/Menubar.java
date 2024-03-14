package swigncomponents;

import uicomponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;

public class Menubar implements PortionListener {
    private int x;
    private int y;
    private int width;
    private int height;

    private ArrayList<MyButton> buttons = new ArrayList<>();
    private ArrayList<MyButton> file_buttons = new ArrayList<>();
    private ArrayList<MyButton> edit_buttons = new ArrayList<>();

    private static boolean showDropdown_file = false;
    private static boolean  showDropdown_edit = false;

    private Image File_open,File_save,File_new,Edit_undo,Edit_redo;
   private MyButton file, edit;

    private MyButton file_Open,file_Save,edit_redo,file_New,edit_undo;
    private MyButton Close;
    private SaveFile saveFile;

    private OpenWindow window;
    boolean show_openwindow=false;
    boolean file_pressed=false;
    boolean undo_pressed=false,redo_pressed=false;
    boolean save_pressed=false;
    boolean new_pressed=false;





    public Menubar(int x, int y , int width, int height, Image file_pres,Image file_unpres, Image edit_pres,Image edit_unpres) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        file = new FileButton(0, 0, 64, 32, file_pres, file_unpres);
        edit = new EditButton(64, 0, 64, 32,  edit_pres,edit_unpres);

        ImageIcon file_open = new ImageIcon("OPEN.png");
        File_open=file_open.getImage();
        file_Open=new MyActive(0,32,150,32,File_open,File_open);

        ImageIcon file_save = new ImageIcon("SAVE.png");
        File_save=file_save.getImage();
        file_Save=new MyActive(0,32+32,150,32,File_save,File_save);

        ImageIcon file_new= new ImageIcon("NEW.png");
        File_new=file_new.getImage();
        file_New=new MyActive(0,32+32+32,150,32,File_new,File_new);

        Edit_redo = new ImageIcon("REDO.png").getImage();
        edit_redo=new MyActive(64,32,150,32,Edit_redo,Edit_redo);

        Edit_undo = new ImageIcon("UNDO.png").getImage();
        edit_undo=new MyActive(64,32+32,150,32,Edit_undo,Edit_undo);

        //adding file and edit
        buttons.add(file);
        buttons.add(edit);

        //adding new,open and save to arraylist
        file_buttons.add(file_New);
        file_buttons.add(file_Open);
        file_buttons.add(file_Save);

        //adding redo and undo to arraylist
        edit_buttons.add(edit_redo);
        edit_buttons.add(edit_undo);

        //setting close button for open window
        Image close=new ImageIcon("cross.png").getImage();
        Close= new MyActive(715, 92, 33, 33, close, close) ;

        //open window for file_open
        window=new OpenWindow(250,90,500,500);

        //file saved in open document inside src
        saveFile=new SaveFile();
    }



    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, width, height);

        for (MyButton b : buttons)
        {
                b.paint(g, observer);
        }

        if(showDropdown_file)
        {
            for (MyButton a : file_buttons)
            {
                a.paint(g, observer);
            }
        }
        if(showDropdown_edit)
        {
            for (MyButton a : edit_buttons)
            {
                a.paint(g, observer);
            }
        }

        if(show_openwindow)
        {
            window.paint(g,observer);
        }
        if(save_pressed)
        {
            new SaveFile().FileSave();
            save_pressed=false;
        }
    }

    @Override
    public void onClick(int x, int y) {
        for (MyButton b : buttons)
        {
            b.IsClicked(x, y);

        }
            if (file.IsClicked(x, y))
            {
                file_pressed = true;
                showDropdown_file = true;
                showDropdown_edit=false;
            }
            else {
                showDropdown_file = false;
            }

            if (edit.IsClicked(x, y)) {
                showDropdown_edit = true;
                file_pressed = false;
                }

            //undo
        if(showDropdown_edit) {
            if (edit_undo.IsClicked(x, y) == true) {
                for (LayerButton l : LayersToolbar.many_layers) {
                    if (l.pressed == true) {
                        l.add(l.pop());
                    }
                }
                showDropdown_edit = false;
            }
        }

        //redo
        if(showDropdown_edit==true) {
            if (edit_redo.IsClicked(x, y) == true) {
                for (LayerButton l : LayersToolbar.many_layers) {
                    if (l.pressed == true) {
                       l.push(l.remove());
                    }
                }
                showDropdown_edit = false;
            }
        }

            if (file_pressed)
            {
                if (file_Open.IsClicked(x, y))
                {
                    show_openwindow = true;
                }
                if (show_openwindow == true)
                {
                    window.IsClick(x, y);
                    if (window.ispressed == false)
                    {
                        show_openwindow = false;
                    }

                }
                if(file_Save.IsClicked(x,y))
                {
                 save_pressed=true;
                }
            }
    }

    public static boolean edit_pressed(){
        return showDropdown_edit;
    }

    public static boolean file_pressed(){
        return showDropdown_file;
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

