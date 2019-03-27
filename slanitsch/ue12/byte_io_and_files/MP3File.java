package slanitsch.ue12.byte_io_and_files;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MP3File {
    private String Titel;
    private String Interpret;
    private String Album;
    private String Jahr;
    private String Kommentar;
    private String Genre;


    public static void main(String[] args) throws IOException {
        MP3File Stefan = new MP3File(Paths.get("resources/goethe_osterspaziergang.mp3"));
        System.out.println(Stefan);
    }

    public MP3File(Path file) throws IOException {
        fillClass(file);
    }

    public static byte[] copyArrays(byte[] input, int length, int start) {
        byte[] output = new byte[length];
        for (int i = 0; i < length; i++) {
            output[i] = input[i + start];
        }
        return output;
    }

    public static String trim(String input) {
        String output = "";
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890ßäöü,.!?;QWERTZUIOPÜASDFGHJKLÖÄYXCVBNM#+";
        for (int i = 0; i < input.length(); i++) {
            char test = input.charAt(i);
            if (contains(test, chars)) {
                output += test;
            }

        }
        return output;
    }

    public static boolean contains(char input, String all) {
        for (int i = 0; i < all.length(); i++) {
            if (all.charAt(i) == input) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return ("Titel: " + trim(Titel) + " Album: " + trim(Album) + " Interpret: " + trim(Interpret) + " Jahr: " + trim(Jahr) + " Kommentar: " + trim(Kommentar) + " Genre: " + trim(Genre));
    }

    public void fillClass(Path file) throws IOException {
        try (
                InputStream in = Files.newInputStream(file);
        ) {
            byte[] buffer = new byte[125];
            int bytesRead;
            in.skip(Files.size(file) - 125);
            bytesRead = in.read(buffer, 0, buffer.length);
            byte[] title = copyArrays(buffer, 30, 0);
            byte[] artist = copyArrays(buffer, 30, 30);
            byte[] album = copyArrays(buffer, 30, 60);
            byte[] year = copyArrays(buffer, 4, 90);
            byte[] comment = copyArrays(buffer, 30, 94);
            byte[] genre = copyArrays(buffer, 1, 124);
            Titel = new String(title);
            Interpret = new String(artist);
            Album = new String(album);
            Jahr = new String(year);
            Kommentar = new String(comment);
            Genre = new String(genre);
        }
    }
}

