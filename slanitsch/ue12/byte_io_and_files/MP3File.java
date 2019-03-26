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

    public static byte[] copyArrays(byte[] input, int length) {
        byte[] output = new byte[length];
        for (int i = 0; i < length; i++) {
            output[i]=output[i];
        }
        return output;
    }

    @Override
    public String toString() {
        return (Titel + Album + Interpret + Jahr + Kommentar + Genre);
    }

    public void fillClass(Path file) throws IOException {
        try (
                InputStream in = Files.newInputStream(file);
        ) {
            byte[] buffer = new byte[125];
            int bytesRead;
            in.skip(Files.size(file) - 125);
            bytesRead = in.read(buffer, 0, buffer.length);
            byte[] title = copyArrays(buffer, 30);
            byte[] artist = copyArrays(buffer, 30);
            byte[] album = copyArrays(buffer, 30);
            byte[] year = copyArrays(buffer, 4);
            byte[] comment = copyArrays(buffer, 30);
            byte[] genre = copyArrays(buffer, 1);
            Titel = new String(title);
            Interpret = new String(artist);
            Album = new String(album);
            Jahr = new String(year);
            Kommentar = new String(comment);
            Genre = new String(genre);
        }
    }
}

