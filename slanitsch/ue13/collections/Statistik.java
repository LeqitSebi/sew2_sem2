package slanitsch.ue13.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class Statistik {
    private Collection Vornamen;
    private Collection Geburtstage;

    public static void main(String[] args) throws IOException {
        Statistik s1 = new Statistik("resources/vornamen.txt", "resources/geburtstage.txt");
        System.out.println(s1.hasFirstName("Nudelholz"));
    }


    public static Collection readLines(String srcFile) throws IOException {
        List<String> c = new LinkedList<>();
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                c.add(line);
            }
        }
        return c;
    }
    
    public Statistik(String srcFile_Namen, String srcFile_Bdays) throws IOException {
        this.Vornamen = readLines(srcFile_Namen);
        this.Geburtstage = readLines(srcFile_Bdays);
    }

    public boolean hasFirstName(String firstName){
        for (Object name:Vornamen) {
            if(firstName.equals(name)){
                return true;
            }
        }
        return false;
    }


}
