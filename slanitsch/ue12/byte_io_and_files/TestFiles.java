package slanitsch.ue12.byte_io_and_files;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFiles {

    public static void main(String[] args) throws IOException {
        createFilesAndDirectories(Paths.get("resources/structure.txt"));
    }

    public static String removeSpacesAndDots(String input) {
        input = input.replace(" ", "");
        input = input.replace(":", "");
        return input;
    }

    public static void createFilesAndDirectories(Path file) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(file, Charset.forName("UTF-8"));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.charAt(line.length() - 1) == ':' && !(line.charAt(0) == '#')) {
                    Files.createDirectory(Paths.get("resources/TestFiles/" + removeSpacesAndDots(line)));
                }
                if (line.charAt(line.length() - 1) != ':' && line.charAt(0) != '#') {
                    Files.createFile(Paths.get("resources/TestFiles/" + removeSpacesAndDots(line)));
                }
            }
        }
    }

}
