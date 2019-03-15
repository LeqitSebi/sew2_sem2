package slanitsch.ue11.textio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class KillRemarks {

    public static void main(String[] args) throws IOException {
        KillComments("resources/eingabe.txt", "resources/ausgabe.txt");
    }


    public static void KillComments(String srcFile, String destFile) throws IOException {
        int i = 0;
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
                BufferedWriter out = Files.newBufferedWriter(Paths.get(destFile), Charset.forName("UTF-8"));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("/*")) {
                    if (line.contains("\"/*\"")) {
                    } else {
                        i++;
                    }
                }

                if(line.contains("//")) {
                    if (line.contains("\"//\"")) {
                        out.write(line + System.lineSeparator());
                    }
                }else{
                    if(i==0){
                        out.write(line + System.lineSeparator());
                    }
                }
                if (line.contains("*/")) {
                    if (line.contains("\"*/\"")) {
                    } else {
                        i--;
                    }
                }
            }
        }
    }
}
