import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FileReaderClass{

    public FileReaderClass(){}
    public static String readFileToString(File inputFile){
        try {
            String temp = "";
            Scanner fileScanner = new Scanner(inputFile);

            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();

                temp += data + "\n";
            }
            fileScanner.close();
            return temp;
        }catch(FileNotFoundException e){
            System.out.println("ERROR!");
            e.printStackTrace();
            return "Error, no file to read!";
        }
    }
}
