import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Character {
    public String name;
    public Boolean isBad;

    public File speakFile;

    public Character(String name, Boolean badness, File inputFile){
        this.name = name;
        isBad = badness;
        speakFile = inputFile;
    }
}
