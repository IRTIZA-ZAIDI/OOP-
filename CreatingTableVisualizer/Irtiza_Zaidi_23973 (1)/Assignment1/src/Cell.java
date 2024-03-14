import java.awt.*;

public class Cell {
    protected Point topleft ;
    protected int width;
    protected int height;
    protected int stroke;
    protected Color cell_color;
    protected Color stroke_color;
    private String text;
    private Font font;
    private int fontSize;
    private int fontStyle;

    /**
     *
     * @param x cell x topleft value
     * @param y cell y topleft value
     * @param width cell width
     * @param height cell height
     * @param cell_color cell color
     * @param stroke_color stroke color
     * @param stroke stroke size
     * @param text text inside cell
     */
    public Cell(int x, int y, int width, int height, Color cell_color, Color stroke_color, int stroke, String text){
        this.topleft=new Point(x,y);
        this.width=width;
        this.height=height;
        this.cell_color=cell_color;
        this.stroke_color=stroke_color;
        this.stroke=stroke;
        this.text=text;

    }

//PAINTS CELL
    public void Paint(Graphics g){
        //drawing cell
        g.setColor(stroke_color);
        g.fillRect(topleft.x , topleft.y , width, height);
        g.setColor(cell_color);
        g.fillRect(topleft.x + stroke , topleft.y + stroke, width - stroke*2, height - stroke*2);

      //adjusting font size,font color and position of text
       g.setColor(Constants.text_color);
       this.fontSize=40;

    font=new Font("Times New Roman",fontStyle,fontSize);
         FontMetrics metrics = g.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
       int textHeight = metrics.getAscent() - metrics.getDescent();

      if((textWidth>width)||(textHeight>height)) {
          while ((textWidth>4*width/5)||(textHeight>4*height/5)) {
              fontSize=fontSize-20;
              font=new Font("Times New Roman",fontStyle,fontSize);
              metrics = g.getFontMetrics(font);
              textWidth = metrics.stringWidth(text);
              textHeight = metrics.getAscent() - metrics.getDescent();
          }
      }

        font=new Font("Times New Roman",fontStyle,fontSize);
        g.setFont(font);


       g.drawString(this.text,topleft.x+2*stroke, topleft.y+4*height/5+2*stroke);

    }

    //ONLY BRIGHTS THE COLOR OF THE FIRST ROW
    public void PaintNormal(Graphics g){
        //drawing cell
        g.setColor(stroke_color);
        g.fillRect(topleft.x , topleft.y , width, height);
        g.setColor(cell_color.brighter());
        g.fillRect(topleft.x + stroke , topleft.y + stroke, width - stroke*2, height - stroke*2);

        //adjusting font size,font color and position of text
        g.setColor(Constants.text_color);
        this.fontSize=40;


        font=new Font("Times New Roman",fontStyle,fontSize);
        FontMetrics metrics = g.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getAscent() - metrics.getDescent();

        if((textWidth>width)||(textHeight>height)) {
            while ((textWidth>4*width/5)||(textHeight>4*height/5)) {
                fontSize=fontSize-20;
                font=new Font("Times New Roman",fontStyle,fontSize);
                metrics = g.getFontMetrics(font);
                textWidth = metrics.stringWidth(text);
                textHeight = metrics.getAscent() - metrics.getDescent();
            }
        }

        font=new Font("Times New Roman",fontStyle,fontSize);
        g.setFont(font);


        g.drawString(this.text,topleft.x+2*stroke, topleft.y+4*height/5+2*stroke);

    }


   //ONLY BOLDS THE FONT OF THE TEXT(USED FOR TITLEBAR)
    public void paintHighlighted(Graphics g) {
        //drawing cell
        g.setColor(stroke_color);
        g.fillRect(topleft.x , topleft.y , width, height);
        g.setColor(cell_color);
        g.fillRect(topleft.x + stroke , topleft.y + stroke, width - stroke*2, height - stroke*2);

        //adjusting font size,font color and position of text
        g.setColor(Constants.text_color);
        this.fontSize=40;



        font=new Font("Times New Roman",fontStyle,fontSize);
        FontMetrics metrics = g.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getAscent() - metrics.getDescent();

        if((textWidth>width)||(textHeight>height)) {
            while ((textWidth>4*width/5)||(textHeight>4*height/5)) {
                fontSize=fontSize-20;
                font=new Font("Times New Roman",fontStyle,fontSize);
                metrics = g.getFontMetrics(font);
                textWidth = metrics.stringWidth(text);
                textHeight = metrics.getAscent() - metrics.getDescent();
            }
        }

        font=new Font("Times New Roman",fontStyle,fontSize);
        g.setFont(font);


        g.drawString(this.text,topleft.x+2*stroke, topleft.y+4*height/5+2*stroke);

    }






}
