import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Character {
    private String name;
    private Boolean isBad;
    private Boolean isFrogified;
    private File portrait;
    private File speakFile;

    public Character(String name, Boolean badness, File inputFile){
        this.name = name;
        isBad = badness;
        isFrogified = false;
        speakFile = inputFile;
    }

    public String getName(){ return name; }
    public Boolean getBadness(){ return isBad; }
    public Boolean getIsFrogified(){ return isFrogified; }
    public File getSpeakFile(){ return speakFile; }
}
