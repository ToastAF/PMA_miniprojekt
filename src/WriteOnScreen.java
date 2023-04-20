import javax.swing.*;
import java.io.File;

public class WriteOnScreen implements Runnable {
    private File inputFile;
    private JTextArea inputTextArea;
    private Integer writeDelay;
    WriteOnScreen(){}
    @Override
    public void run() {
        try{
            String temp = "";
            for(char yes : FileReaderClass.readFileToString(inputFile).toCharArray()){
                temp += yes;
                inputTextArea.setText(temp);
                Thread.sleep(writeDelay);
            }
            Main.textBoxLock = false;
            System.out.println("Lock unlocked!");
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
