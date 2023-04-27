import javax.swing.*;

public class WriteOnScreenFromString implements Runnable {
    private String inputString;
    private JTextArea inputTextArea;
    private Integer writeDelay;
    @Override
    public void run() {
        try{
            String temp = "";
            for(char yes : inputString.toCharArray()){
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

    public void setInput(String inputString, JTextArea inputTextArea, Integer delay){
        this.inputString = inputString;
        this.inputTextArea = inputTextArea;
        writeDelay = delay;
    }
}
