// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        JFrame frame = new JFrame("Main Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        JPanel textPanel = new JPanel();
        JTextArea textBox = new JTextArea(8, 16);
        textBox.setEditable(false);
        textBox.setText(FileReaderClass.readFileToString(new File("Text files/dialogueText.txt")));
        frame.getContentPane().add(BorderLayout.CENTER, textPanel);
        textPanel.add(textBox);

        JPanel buttonPanel = new JPanel();
        JButton firstButton = new JButton("Test Button");
        JButton secondButton = new JButton("Test Button 2");
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        buttonPanel.add(firstButton);
        buttonPanel.add(secondButton);

        frame.setVisible(true);

        System.out.println("Hello and welcome!");

        scanInt();

        scanText();
    }

    public static void scanText(){
        try{
            Scanner myScanner2 = new Scanner(System.in);
            System.out.println("What is your name?");
            String input2 = myScanner2.nextLine();
            System.out.println("Oh! Hello " + input2);
        }
        catch(Exception e){
            System.out.println("Unknown error occured!");
            scanText();
        }
    }

    public static void scanInt(){
        try{
            Scanner myScanner = new Scanner(System.in);

            System.out.print("Enter a number: ");
            Integer input = myScanner.nextInt();
            System.out.println("The result: " + (input*3));
        }
        catch(Exception e) {
            System.out.println("That is not a nunmber >:(");
            scanInt(); //Metoden kalder sig selv, når der kommer en exception, så man skal skrive det rigtige >:)
        }
    }
}