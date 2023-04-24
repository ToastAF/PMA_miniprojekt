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
    static public boolean textBoxLock = false;

    public static void main(String[] args) {


        Character[] charList = new Character[10];
        charList[0] = new Character("Horgenblorg",false, new File("Characters/OrcMan.png"), new File("Text files/dialogueText.txt"));
        charList[1] = new Character("OhNoMan", false, new File("Characters/Ohnoman-portrait2.png"), new File("Text files/characterText2.txt"));
        /*charList[2] = new Character("The Froggler", true);
        charList[3] = new Character("Serpen Tina", true);
        charList[4] = new Character(Ketchip", false, new File*/

        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        JFrame frame = new JFrame("Main Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,600);
        frame.setBackground(Color.CYAN);

        JPanel textPanel = new JPanel();
        JTextArea textBox = new JTextArea(100,50);
        JScrollPane scrollPane = new JScrollPane(textPanel);
        textBox.setEditable(false);
        textBox.setSize(100,100);


        //textBox.setText(FileReaderClass.readFileToString(new File("Text files/dialogueText.txt")));
        frame.getContentPane().add(BorderLayout.CENTER, textPanel);
        textPanel.add(textBox);


        JPanel picturePanel = new JPanel();
        JLabel characterLabel = new JLabel(new ImageIcon(charList[0].getPortraitFile().toString()));
        picturePanel.add(characterLabel);
        frame.getContentPane().add(BorderLayout.EAST, picturePanel);

        JPanel buttonPanel = new JPanel();
        JButton firstButton = new JButton("FROGIFY!", new ImageIcon("Characters/Wizard.gif"));
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textBoxLock == false){
                    textBoxLock = true;  //This locks the textArea so only one file can be written in it at a time!
                    System.out.println("Pressed button 1: locked");
                    startWriteThread(charList[0].getSpeakFile(), textBox, 50);
                }
            }});

        JButton secondButton = new JButton("Test Button 2");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textBoxLock == false){
                    textBoxLock = true;  //This locks the textArea so only one file can be written in it at a time!
                    System.out.println("Pressed button 2: locked");
                    startWriteThread(charList[1].getSpeakFile(), textBox, 50);
                    characterLabel.setIcon(new ImageIcon(charList[1].getPortraitFile().toString()));
                }
            }});

        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        buttonPanel.add(firstButton);
        buttonPanel.add(secondButton);

        frame.setVisible(true);

        System.out.println("Hello and welcome!");
    }
    public static void startWriteThread(File inputFile, JTextArea inputTextBox, Integer delayInput){
        WriteOnScreen screenWriter = new WriteOnScreen();
        Thread writeThread = new Thread(screenWriter);
        screenWriter.setInput(inputFile, inputTextBox, delayInput);
        writeThread.start();
    }
}