// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");


        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        Integer input = myScanner.nextInt();
        System.out.println("The result: " + (input*3));

        /*System.out.println("What is your name?");
        String input2 = myScanner.nextLine();
        System.out.println("Oh! Hello " + input2);*/

        FileReaderClass readOnce = new FileReaderClass();
        readOnce.readFile();
    }
}