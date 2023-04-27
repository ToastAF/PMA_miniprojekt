import javax.swing.*;
import java.io.File;

public class WriteOnScreen implements Runnable {
    private File inputFile;
    private JTextArea inputTextArea;
    private Integer writeDelay;
    @Override
    public void run() {
        try{
            Main.firstButton.setVisible(false);
            Main.secondButton.setVisible(false);

            String temp = "";
            for(char yes : FileReaderClass.readFileToString(inputFile).toCharArray()){
                temp += yes;
                inputTextArea.setText(temp);
                Thread.sleep(writeDelay);
            }
            Main.textBoxLock = false;
            System.out.println("Lock unlocked!");

            if(Main.gameIsStarted == true){
                Main.firstButton.setVisible(true);
                Main.secondButton.setVisible(true);
            }
            else{
                Main.startButton.setVisible(true);
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
            System.out.println("Thread ded");
        }
    }

    public void setInput(File inputFile, JTextArea inputTextArea, Integer delay){
        this.inputFile = inputFile;
        this.inputTextArea = inputTextArea;
        writeDelay = delay;
    }
}
