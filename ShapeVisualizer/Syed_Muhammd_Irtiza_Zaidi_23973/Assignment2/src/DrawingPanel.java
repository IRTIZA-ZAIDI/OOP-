import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // PROPERTIES
    private final int DEFAULT_WIDTH = 600;
    private final int DEFAULT_HEIGHT = 600;

    private int x1, y1, x2, y2,x0,y0,x3,y3;
    private int x, y;
    private Graphics g;
    private Circle circle;
    private Rectangle rectangle;
    private Triangle triangle;
    private Random random = new Random();
    private Stack shape_stack=new Stack();
    private Queue shape_queue=new Queue();
    Color C;
    String shape="";
    private char Choice;
    private int count=0;
    Point p1;
    Point p2;
    Point p3;

    // CONSTRUCTOR
    public DrawingPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        setFocusable(true);
    }

    // METHOD
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    //DRAWING FUNCTION WHICH PRINTS THE STACK AND DISPLAYS WHICH SHAPE IS BEING DRAWN
    private void setUpDrawingGraphics() {
        g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,3000,3000);

        g.setColor(Color.GRAY);
        g.fillRect(0,550,500,50);
        g.setColor(Color.BLACK);
        if(shape.compareTo("wrong")==0){
            g.drawString("Press 1,2,3 or r to load all previous shapes",10,575);
        }
        else{
            g.drawString("Current shape : "+shape,10,575);
        }

        if(shape_stack.head != null){
            Node current = shape_stack.head;
            while(current!=null){
                current.shape.draw(g);
                current=current.next;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        x3 = e.getX();
        y3 = e.getY();
    }

   //FOR WHEN EVER MOUSE IS PRESSED FOR ANY SHAPE AND ADDS TO STACK IF PRESSED 3 TIMES FOR TRIANGLE
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if (SwingUtilities.isLeftMouseButton(e)) {

            //resets queue after new shape is drawn
            if(shape_queue.tail!=null) {
                shape_queue=new Queue();
            }

            C = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            x1 = e.getX();
            y1 = e.getY();

            switch (Choice) {
                case '1':
                    circle = new Circle(0, new Point(x1, y1), C);
                     circle.draw(g);
                    break;

                case '2':
                    rectangle = new Rectangle(0, 0, new Point(x1, y1), C);
                    rectangle.draw(g);
                    break;

                case '3':
                    //counting presses for triangle
                    count++;
                    if (count == 1) {
                      p1=new Point(x1,y1);
                    }
                    if (count == 2) {
                       p2=new Point(x1,y1);
                    }
                    if (count == 3) {
                        p3=new Point(x1,y1);
                        triangle = new Triangle(p1,p2,p3,C);
                        shape_stack.push(triangle);
                        count = 0;
                        break;
                    }
                default:
                    break;
            }
            setUpDrawingGraphics();
        }


        else if(SwingUtilities.isRightMouseButton(e))
        {
            if(shape_stack.isEmpty()==false){
                Shape current=shape_stack.pop();
                shape_queue.Enqueue(current);
            }
            System.out.println("right pressed");
        }


        else if(SwingUtilities.isMiddleMouseButton(e))
        {
            if(shape_queue.isEmpty()==false){
                Shape current=shape_queue.Dequeu();
                shape_stack.push(current);
            }
            System.out.println("middle pressed");
        }
        setUpDrawingGraphics();

    }

    //FOR MOUSE RELEASED(ONLY ADD TO STACK WHEN MOUSE IS RELEASED FOR CIRCLE AND RECTANGLE)
    @Override
    public void mouseReleased(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
           // shape_stack.push(shapes);
            switch (Choice){
                case '1':
                    shape_stack.push(circle);
                    break;
                case '2':
                    shape_stack.push(rectangle);
                    break;
                default:
                    break;
            }
            setUpDrawingGraphics();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //TO DISPLAY HOW THE SIZE OF CIRCLE AND RECTANGLE VARIES WHEN MOUSE IS DRAGGED
    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        switch (Choice) {
            case '1':
                //draws the dragged circle
                setUpDrawingGraphics();
                circle = new Circle((int) Math.sqrt((x1 - x) * (x1 - x) + (y - y1) * (y - y1)) , new Point(x1, y1), C);
                circle.draw(g);
                break;

            case '2':
                //draws the dragged rectangle
                setUpDrawingGraphics();
                rectangle= new Rectangle(y - y1, x - x1, new Point(x1, y1), C);
                rectangle.draw(g);
                break;
        }

    }

    //DRAWS THE LINES WHEN MAKING TRIANGLES
    @Override
    public void mouseMoved(MouseEvent e) {
        x0=e.getX();
        y0=e.getY();

        switch(Choice){
            case '3' :
                setUpDrawingGraphics();
         if(count==1) {
             g.setColor(Color.BLACK);
             g.drawLine(p1.x,p1.y, x0, y0);
         }
         if(count==2){
             g.setColor(Color.BLACK);
             g.drawLine(p1.x,p1.y,p2.x,p2.y);
             g.setColor(Color.BLACK);
             g.drawLine(p2.x, p2.y,x0, y0);
             }
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
         //TODO Auto-generated method stub
        System.out.println("key pressed");
        if(e.getKeyChar()=='1'){
            Choice='1';
           shape="Circle";
        }
        else if(e.getKeyChar()=='2'){
            Choice='2';
            shape="Rectangle";
        }
        else if(e.getKeyChar()=='3'){
            Choice='3';
            shape="Triangle";
        }
        else if(e.getKeyChar()=='r')
        {
            Fromfile();
            shape="Shapes loaded";
        }
       else {
           shape="wrong";
        }

       System.out.println(Choice);
       setUpDrawingGraphics();
   }


   //READS THE OLD DATA FROM FILE DATA IN THE PACKAGE
   public void Fromfile(){
       try {
           File data = new File("src/data");
           Scanner scanner = new Scanner(data);
           if(data.exists()==false){
               System.out.println("Wrong path");
           }
           if(scanner.hasNext()==false){
               System.out.println("No data to read");
           }
           while (scanner.hasNextLine()) {

               //reads the type of shape
                String shape_type="";
                shape_type=scanner.nextLine().trim();


              //reads circle data
               if(shape_type.compareTo("Circle")==0){

                   String [] s=scanner.nextLine().split(":");
                   int size=Integer.parseInt(s[1].trim());

                   String [] p=scanner.nextLine().split(":");
                   String [] ps=p[1].split(",");
                   int x=Integer.parseInt(ps[0].trim());
                   int y=Integer.parseInt(ps[1].trim());

                   String [] c=scanner.nextLine().split(":");
                   int color=Integer.parseInt(c[1].trim());

                   circle=new Circle(size,new Point(x,y),new Color(color));
                   shape_stack.push(circle);

               }
              //reads rectangle data
               if(shape_type.compareTo("Rectangle")==0) {

                   String[] h = scanner.nextLine().split(":");
                   int height = Integer.parseInt(h[1].trim());

                   String[] w = scanner.nextLine().split(":");
                   int width = Integer.parseInt(w[1].trim());

                   String[] p = scanner.nextLine().split(":");
                   String[] ps = p[1].split(",");
                   int x = Integer.parseInt(ps[0].trim());
                   int y = Integer.parseInt(ps[1].trim());

                   String[] c = scanner.nextLine().split(":");
                   int color = Integer.parseInt(c[1].trim());

                   rectangle = new Rectangle(height, width, new Point(x, y), new Color(color));
                   shape_stack.push(rectangle);
               }

               //reads triangle data
               if(shape_type.compareTo("Triangle")==0){

                   String[] p1 = scanner.nextLine().split(":");
                   String[] ps1 = p1[1].split(",");
                   int x1 = Integer.parseInt(ps1[0].trim());
                   int y1 = Integer.parseInt(ps1[1].trim());

                   String[] p2 = scanner.nextLine().split(":");
                   String[] ps2 = p2[1].split(",");
                   int x2 = Integer.parseInt(ps2[0].trim());
                   int y2 = Integer.parseInt(ps2[1].trim());

                   String[] p3 = scanner.nextLine().split(":");
                   String[] ps3 = p3[1].split(",");
                   int x3 = Integer.parseInt(ps3[0].trim());
                   int y3 = Integer.parseInt(ps3[1].trim());

                   String[] c = scanner.nextLine().split(":");
                   int color = Integer.parseInt(c[1].trim());

                   triangle=new Triangle(new Point(x1,y1),new Point(x2,y2),new Point(x3,y3),new Color(color));
                   shape_stack.push(triangle);
               }
           }
           scanner.close();
           setUpDrawingGraphics();
       } catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }

   }

//SAVES THE DATA OF JFRAME IN FILE DATA IN PACKAGE
   public void Tofile(File file){
      try {
          PrintWriter printwriter=new PrintWriter("src/data");
          Node current=shape_stack.head;
          if(current==null) System.out.println("No shapes drawn");
          while(current!=null){
              printwriter.println(current.shape.toString());
              current=current.next;

          }
          printwriter.close();
      } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
}

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
