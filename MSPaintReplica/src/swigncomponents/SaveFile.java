package swigncomponents;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class SaveFile {
    private static int num=1;
    public SaveFile(){ }

    public void FileSave()   {
                try {
                    File file = new File("C:/Users/Irtiza/Downloads/src/Open/filename"+num+".txt");
                    System.out.println("file saved");
                    num++;
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter writer = new FileWriter(file);
                    writer.write("File saved,YAY!");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

