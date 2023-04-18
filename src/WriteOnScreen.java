import javax.swing.*;
import java.io.File;

public class WriteOnScreen implements Runnable {
    File inputFile;
    JTextArea inputTextArea;
    WriteOnScreen(){

    }
    @Override
    public void run() {
        //try{
            String temp = "";
            for(char yes : FileReaderClass.readFileToString(inputFile).toCharArray()){
                temp += yes;
                inputTextArea.setText(temp);
                //this.wait(100);
            };
       /* }catch(InterruptedException ex){
            ex.printStackTrace();
        }*/
    }

    public void setInput(File inputFile, JTextArea inputTextArea){
        this.inputFile = inputFile;
        this.inputTextArea = inputTextArea;
    }
}
