package slanitsch.ue13.collectionsI;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Statistik {
    private Set vorname;
    private List geburtstage;

    public static void main(String[] args) throws IOException {
        Statistik s1 = new Statistik(Paths.get("resources/vornamen.txt"), Paths.get("resources/geburtstage.txt"));
        System.out.println(s1.countPupilsWithDoubleBirthdays());

    }

    public static List readLines(Path srcFile) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(srcFile, Charset.forName("UTF-8"));
        ) {
            List<String> out = new LinkedList<>();
            String line;


            while ((line = in.readLine()) != null) {
                line = (line.split(" "))[0];
                out.add(line);
            }
            return out;
        }
    }

    public Statistik(Path setFile, Path listFile) throws IOException {
        setStatistik(setFile, listFile);
    }

    public void setStatistik(Path toSetFile, Path toListFile) throws IOException {
        this.geburtstage = readLines(toListFile);
        this.vorname = new HashSet<>(readLines(toSetFile));
    }

    public boolean hashFirstName(String Firstname) {

        for (Object name : vorname) {
            if (Firstname.equals(name)) {
                return true;
            }
        }
        return false;
    }

    String[] toStringArray(List<String> list) {
        String[] ret = new String[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }

    public int countPupilsWithDoubleBirthdays() {
        int duplicates = 0;

        for (int i = 0; i < geburtstage.size() - 1; i++) {

            for (int j = i + 1; j < geburtstage.size(); j++) {
                if (geburtstage.get(i).equals(geburtstage.get(j))) {
                    duplicates++;
                }
            }
        }
        return duplicates;
    }

}