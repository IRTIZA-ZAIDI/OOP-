package swigncomponents;

import uicomponents.MyButton;

import java.awt.*;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class Board extends JPanel
        implements ActionListener , MouseInputListener{

    private final int B_WIDTH = 1080;
    private final int B_HEIGHT = 720;

    private final int DELAY = 10;
    private Timer timer;

    Image File_pressed,File_unpressed,Edit_pressed,Edit_unpressed;


    private Menubar topPortion;
    private ShapesToolbar bottomPortion;
    private ColorToolbar colorToolbar;
    private LayersToolbar layersToolbar;
    private DrawingBoard drawingBoard;

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            char x=e.getKeyChar();
            switch(x){
                case 's':
                 topPortion.save_pressed=true;
                    break;

                case 'o':
                    topPortion.file_pressed=true;
                    topPortion.show_openwindow=true;
                    break;

                case 'n':
                    topPortion.new_pressed=true;
                    System.out.println("New");
                    break;

                case 'u':
                    topPortion.undo_pressed=true;
                    System.out.println("undo");
                    break;
                case 'r':
                    topPortion.redo_pressed=true;
                    System.out.println("redo");
                    break;

            }





        }

        @Override
        public void keyPressed(KeyEvent e) {

        }
    }

    public Board() {

        initBoard();
    }

    private void InitializeAssets() {

        ImageIcon file_pressed = new ImageIcon("File_pressed.png");
        File_pressed = file_pressed.getImage();

        ImageIcon file_unpressed = new ImageIcon("File_unpressed.png");
        File_unpressed = file_unpressed.getImage();

        ImageIcon edit_pressed = new ImageIcon("Edit_pressed.png");
        Edit_pressed = edit_pressed.getImage();

        ImageIcon edit_unpressed = new ImageIcon("Edit_unpressed.png");
        Edit_unpressed = edit_unpressed.getImage();

    }

    private void initBoard() {

    	addMouseListener( this );
    	addMouseMotionListener( this );
    	addKeyListener(new TAdapter());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);

        InitializeAssets();

        topPortion=new Menubar(0,0,B_WIDTH,32,File_pressed,File_unpressed,Edit_pressed,Edit_unpressed);
        bottomPortion=new ShapesToolbar(0,620,200,100);
        colorToolbar=new ColorToolbar(202,616,900,100);
        layersToolbar=new LayersToolbar(830,32,250,688);
        drawingBoard=new DrawingBoard();


        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawingBoard.paint(g);
        topPortion.paint(g, this);
        bottomPortion.paint(g,this);
        colorToolbar.paint(g,this);
        layersToolbar.paint(g,this);
    }


    

	@Override
	public void mouseClicked(MouseEvent e) {
        topPortion.onClick(e.getX(), e.getY());
        bottomPortion.onClick(e.getX(), e.getY());
        colorToolbar.onClick(e.getX(),e.getY());
        layersToolbar.onClick(e.getX(),e.getY());
      //  drawingBoard.onClick(e.getX(),e.getY());
	}


	// MOUSE LISTENERS
	@Override
	public void mousePressed(MouseEvent e) {
        drawingBoard.onPress(e.getX(),e.getY());
//        topPortion.onPress(e.getX(), e.getY());
//        bottomPortion.onPress(e.getX(), e.getY());
//        colorToolbar.onPress(e.getX(),e.getY());
//        layersToolbar.onPress(e.getX(),e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
        drawingBoard.onRelease(e.getX(),e.getY());
        topPortion.onRelease(e.getX(), e.getY());
        bottomPortion.onRelease(e.getX(), e.getY());
        colorToolbar.onRelease(e.getX(),e.getY());
        layersToolbar.onRelease(e.getX(),e.getY());

    }

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
        drawingBoard.dragged(e.getX(),e.getY());

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	// refreshing
    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        repaint();
    }
}