import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderClass {

    public FileReaderClass(){

    }

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

    public static void readFileToConsole(){
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
