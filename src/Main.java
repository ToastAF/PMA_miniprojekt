// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static public boolean textBoxLock = false;
    static public Integer charListCounter = 0;
    static public Integer writeDelay = 30;
    static public Boolean gameIsStarted = false;
    static JButton firstButton = new JButton("FROGIFY!", new ImageIcon("Characters/Wizard.gif"));
    static JButton secondButton = new JButton("Go to next person...", new ImageIcon("Characters/WizardWalk.gif"));
    static JButton startButton = new JButton("Start game!");

    static Character[] charList = new Character[10];

    //The main text box where we write most of the things
    static JTextArea textBox = new JTextArea(100,50);

    static JTextArea nameBox = new JTextArea("Oldor the Wizard",1,20);

    public static void main(String[] args) {
        // Character list
        charList[0] = new Character("Horgenblorg the Orc",false, new File("Characters/OrcMan.png"), new File("Text files/dialogueText.txt"));
        charList[1] = new Character("Smelvin O. Deur", false, new File("Characters/Ohnoman-portrait2.png"), new File("Text files/characterText2.txt"));
        charList[2] = new Character("The Froggler",true, new File("Characters/Frogman-portrait2.png"), new File("Text files/forgManText.txt"));
        charList[3] = new Character("Serpen Tina", true, new File("Characters/Snake Lady.png"), new File("Text files/snakeLadyText.txt"));
        charList[4] = new Character("Ketchip", false, new File("Characters/Tomatoguy-portrait.png"), new File("Text files/ketchip.txt"));
        charList[5] = new Character("Isabella", true, new File("Characters/Smiley-portrait.png"), new File("Text files/isabella.txt"));
        charList[6] = new Character("Sir Helmet", false, new File("Characters/HelmetDude.png"), new File("Text files/helmetText.txt"));
        charList[7] = new Character("Gobbo Gob the Goblin", true, new File("Characters/AngyGobkin.png"), new File("Text files/gobbo.txt"));
        charList[8] = new Character("John Business", false, new File("Characters/SmallGentleman.png"), new File("Text files/johnBusiness.txt"));
        charList[9] = new Character("Doug the dog", true, new File("Characters/bombastic side eye-portrait.png"), new File("Text files/dog.txt"));

        // The main frame
        JFrame frame = new JFrame("Wizard Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.setResizable(false);

        // Different panels
        JPanel textPanel = new JPanel();
        JPanel picturePanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        //Text boxes
        textBox.setEditable(false);
        textBox.setSize(100,100);
        textPanel.setBackground(new Color(86,136,199));
        nameBox.setEditable(false);

        JLabel characterLabel = new JLabel(new ImageIcon("Characters/WizardBig.png"));

        //Changing colors
        picturePanel.setBackground(new Color(86,136,199));
        buttonPanel.setBackground(new Color(154, 80, 32));

        //Aligning panels
        picturePanel.setLayout(new BoxLayout(picturePanel,BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.EAST, picturePanel);
        frame.getContentPane().add(BorderLayout.CENTER, textPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);


        firstButton.addActionListener(new ActionListener() {   //This is the button to FROGIFY people!
            @Override
            public void actionPerformed(ActionEvent e) {
                    charList[charListCounter].setIsFrogified();

                    if(charListCounter < 9){
                        charListCounter++;
                        startWriteThread(charList[charListCounter].getSpeakFile(), textBox, writeDelay);
                        characterLabel.setIcon(new ImageIcon(charList[charListCounter].getPortraitFile().toString()));
                        nameBox.setText(charList[charListCounter].getName());
                    }else{
                        startWriteThreadFromString(endGameText(), textBox, writeDelay);
                        characterLabel.setIcon(new ImageIcon("Characters/WizardBig.png"));
                        nameBox.setText("Oldor the Wizard");
                        firstButton.setVisible(false);
                        secondButton.setVisible(false);
                    }
            }});

        secondButton.addActionListener(new ActionListener() {   //This is the button for going to the next person!
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(charListCounter < 9){
                        charListCounter++;
                        startWriteThread(charList[charListCounter].getSpeakFile(), textBox, writeDelay);
                        characterLabel.setIcon(new ImageIcon(charList[charListCounter].getPortraitFile().toString()));
                        nameBox.setText(charList[charListCounter].getName());
                    }else{
                        startWriteThreadFromString(endGameText(), textBox, writeDelay);
                        characterLabel.setIcon(new ImageIcon("Characters/WizardBig.png"));
                        nameBox.setText("Oldor the Wizard");
                        firstButton.setVisible(false);
                        secondButton.setVisible(false);
                    }
            }});

        startButton.addActionListener(new ActionListener() {  //This is the button for starting the game
            @Override
            public void actionPerformed(ActionEvent e) {
                startWriteThread(charList[charListCounter].getSpeakFile(), textBox, writeDelay);
                characterLabel.setIcon(new ImageIcon(charList[charListCounter].getPortraitFile().toString()));
                nameBox.setText(charList[charListCounter].getName());
                startButton.setVisible(false);
                gameIsStarted = true;
            }
        });

        picturePanel.add(characterLabel);
        textPanel.add(textBox);
        picturePanel.add(nameBox);
        buttonPanel.add(firstButton);
        buttonPanel.add(secondButton);
        buttonPanel.add(startButton);

        firstButton.setVisible(false);
        secondButton.setVisible(false);
        startButton.setVisible(false);

        frame.setVisible(true);

        startWriteThread(new File("Text files/startText.txt"), textBox, writeDelay);

        System.out.println("Hello and welcome!");
    }

    static String endGameText(){
        Integer score = 0;
        String textForBox = "";

        //Check badness
        for(int i = 0; i < 10; i++){
            if(charList[i].getBadness() == true){
                if(charList[i].getIsFrogified() == true){
                    score++; }else{ score--; }}}

        //Check goodness
        for(int i = 0; i < 10; i++){
            if(charList[i].getBadness() == false){
                if(charList[i].getIsFrogified() == false){
                    score++; }else{ score--; }}}

        textForBox += "Game over... well done! \n Let's see how well you did.\n\n";
        textForBox += "Your score: " + score + "\n\n";

        if(score == 10){
            textForBox += "PERFECT SCORE!\n\n";
        }

        textForBox += "";

        for(int i = 0; i < 10; i++){
            if(charList[i].getBadness() == true){
                textForBox = textForBox + charList[i].getName() + " was bad to the bone! \n";
            }else{
                textForBox = textForBox + charList[i].getName() + "'s soul was pure! \n";
            }
        }
        return textForBox;
    }

    public static void startWriteThread(File inputFile, JTextArea inputTextBox, Integer delayInput){
        WriteOnScreen screenWriter = new WriteOnScreen();
        Thread writeThread = new Thread(screenWriter);
        screenWriter.setInput(inputFile, inputTextBox, delayInput);
        writeThread.start();
    }
    public static void startWriteThreadFromString(String inputString, JTextArea inputTextBox, Integer delayInput){
        WriteOnScreenFromString screenWriter = new WriteOnScreenFromString();
        Thread writeThread = new Thread(screenWriter);
        screenWriter.setInput(inputString, inputTextBox, delayInput);
        writeThread.start();
    }
}

