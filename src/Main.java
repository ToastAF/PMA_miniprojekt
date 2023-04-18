// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        //textBox.setText(FileReaderClass.readFileToString(new File("Text files/dialogueText.txt")));
        frame.getContentPane().add(BorderLayout.CENTER, textPanel);
        textPanel.add(textBox);


        JPanel picturePanel = new JPanel();
        JLabel character = new JLabel(new ImageIcon("Characters/Frogman-portrait2.png"));
        picturePanel.add(character);
        frame.getContentPane().add(BorderLayout.EAST, picturePanel);

        JPanel buttonPanel = new JPanel();
        JButton firstButton = new JButton("FROGIFY!", new ImageIcon("Characters/Ohnoman-littol.png"));
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stinky haha poop");
                WriteOnScreen screenWriter = new WriteOnScreen();
                screenWriter.setInput(new File("Text files/dialogueText.txt"), textBox);
                Thread writeThread = new Thread(screenWriter);
                writeThread.run();
            }
        });

        JButton secondButton = new JButton("Test Button 2");
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        buttonPanel.add(firstButton);
        buttonPanel.add(secondButton);

        frame.setVisible(true);

        System.out.println("Hello and welcome!");
    }
    public static void countTime(float time){

    }
}