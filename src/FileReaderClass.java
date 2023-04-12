import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderClass {

    public FileReaderClass(){

    }

    public void readFile(){
        try{
            File myFile = new File("Text files/dialogueText.txt");
            Scanner fileScanner = new Scanner(myFile);
            while(fileScanner.hasNextLine()){
                String data = fileScanner.nextLine();
                System.out.println(data);
            }
            fileScanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("ERROR!");
            e.printStackTrace();
        }
    }
}
