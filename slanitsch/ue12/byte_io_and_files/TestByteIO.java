package slanitsch.ue12.byte_io_and_files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class TestByteIO {

    public static void main(String[] args) throws IOException {
//        copyFile(Paths.get("resources/gnu_pingu.jpg"), Paths.get("resources/mein_bild.jpg"));
//        invertFile(Paths.get("resources/Was_stellt_das_verschluesselte_Bild_dar.gif"), Paths.get("resources/mein_bild_test.jpg"));
//        encryptFile(Paths.get("resources/gnu_pingu.jpg"), Paths.get("resources/mein_bild.jpg"), 12);
//        decryptFile(Paths.get("resources/mein_bild.jpg"), Paths.get("resources/mein_bild_test.jpg"), 12);
//        FileSplit(Paths.get("resources/gnu_pingu.jpg"), 15000);
        FileUnsplit(Paths.get("resources/gnu_pingu.jpg"));

    }

    public static void copyFile(Path srcFile, Path destFile) throws IOException {
        try (
                InputStream in = Files.newInputStream(srcFile);
                OutputStream out = Files.newOutputStream(destFile);
        ) {
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = in.read(buffer, 0, buffer.length)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void invertFile(Path srcFile, Path destFile) throws IOException {
        try (
                InputStream in = Files.newInputStream(srcFile);
                OutputStream out = Files.newOutputStream(destFile);
        ) {
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = in.read(buffer, 0, buffer.length)) > 0) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) ~buffer[i];
                }
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void encryptFile(Path srcFile, Path destFile, int key) throws IOException {
        try (
                InputStream in = Files.newInputStream(srcFile);
                OutputStream out = Files.newOutputStream(destFile);
        ) {
            Random rnd = new Random(key);
            byte[] rndBytes = new byte[2048];
            rnd.nextBytes(rndBytes);
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = in.read(buffer, 0, buffer.length)) > 0) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] ^= rndBytes[i];
                }
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void decryptFile(Path srcFile, Path destFile, int key) throws IOException {
        encryptFile(srcFile, destFile, key);
    }

    public static void FileSplit(Path file, long maxBytes) throws IOException {
        InputStream in = Files.newInputStream(file);
        float helper = (float) Files.size(file) / maxBytes;
        byte[] buffer = new byte[(int) maxBytes];
        int bytesRead;
        double filecount = Math.ceil(helper);
        int i = 0;
        while ((bytesRead = in.read(buffer, 0, buffer.length)) > 0) {
            OutputStream out = Files.newOutputStream(Paths.get(file.toString() + "0000000" + i));
            out.write(buffer, 0, bytesRead);
            i++;
        }
    }

    public static void FileUnsplit(Path file) throws IOException {
        OutputStream out = Files.newOutputStream(Paths.get("resources/Unsplitted.jpg"));
        byte[] buffer = new byte[2048];
        int bytesRead;
        for (int i = 0; true; i++) {
            if (Files.exists(Paths.get(file.toString() + "0000000" + i))) {
                InputStream in = Files.newInputStream(Paths.get(file.toString() + "0000000" + i));
                while ((bytesRead = in.read(buffer, 0, buffer.length)) > 0) {
                    out.write(buffer, 0, bytesRead);
                }
            } else {
                break;
            }
        }
    }
}


