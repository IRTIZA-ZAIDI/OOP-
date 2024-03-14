import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Table {

    private TitleBar title;
    private Cell[] cell;
    private int row;
    private int column;
    private String[][] matrix;
    private String titletext="Data Table";

    /**
     *
     * @param file file path to draw table
     */
    public Table(File file) {
        try {
            Scanner sc = new Scanner(file);

            //IF THE FILE IS EMPTY AND CONTAINS NO LINE , THEN MAKE DEFAULT TABLE
            if (!sc.hasNext()) {
                this.row = 15;
                this.column = 5;
                this.matrix = new String[row][column];
                for (int i = 0; i < this.row; i++)
                    for (int j = 0; j < this.column; j++) {
                        if (i == 0) {
                            matrix[i][j] = "Data";
                        } else {
                            this.matrix[i][j] = "default";
                        }
                    }
            }

            // IF THE FILE HAS VALUE READ AND STORE THE VALUES
            else {
                row = 1;
                titletext = sc.nextLine();
                String column_heading = sc.nextLine();
                String[] columns = column_heading.split(" ");
                this.column = columns.length;
                while (sc.hasNext()) {
                    sc.nextLine();
                    row++;
                }
                Scanner sc2 = new Scanner(file);
                matrix = new String[row][column];
                sc2.nextLine();
                for (int i = 0; i < this.row; i++) {
                    for (int j = 0; j < this.column; j++) {

                        String S = sc2.next();
                        if (S.equals("*")) S = "default";
                        matrix[i][j] = S;
                        if(!sc2.hasNext()){
                            System.out.println("uneven rows and columns");
                            break;
                        }
                        if(!sc2.hasNext()){
                            System.out.println("uneven rows and columns");
                            break;
                        }
                    }
                }
                    sc.close();
                    sc2.close();

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

//PRINT THE WHOLE TABLE CONTAINING THE VALUES FROM FILE
    public void paintTitle(Graphics g) {
        title = new TitleBar(0, 0, Constants.width, Constants.height / 17, Constants.Title_color, Constants.Title_stroke_color, Constants.strokesize, titletext);
        title.paintTitle(g);

        this.cell = new Cell[row * column];
        int x = 0, y = 0;
        Color p;
        int cell_width = Constants.width / this.column;
        int cell_height = Constants.height / this.row;


        for (int i = 0; i < row; i++) {
            x = 0;
            for (int j = 0; j < column; j++) {
                cell[i + j] = new Cell(0 + x, Constants.cell_height + y - Constants.strokesize, cell_width, cell_height,Constants.cell_color, Constants.cell_stroke_color, Constants.strokesize, matrix[i][j]);
                if(i==0){
                    cell[i + j].PaintNormal(g);
                }
                else{
                    cell[i + j].Paint(g);
                }
                x = x + cell_width;
            }
            y = y + cell_height;

        }
    }
}










