package slanitsch.ue12.byte_io_and_files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TestByteIO {

    public static void main(String[] args) throws IOException {
//        copyFile("resources/gnu_pingu.jpg", "resources/mein_bild.jpg");
//        invertFile("resources/Was_stellt_das_verschluesselte_Bild_dar.gif", "resources/mein_bild_test.jpg");
//        encryptFile("resources/mein_bild.jpg", "resources/mein_bild_test.jpg", 12);
    }

    public static void copyFile(String srcFile, String destFile) throws IOException {
        try (
                InputStream in = Files.newInputStream(Paths.get(srcFile));
                OutputStream out = Files.newOutputStream(Paths.get(destFile));
        ) {
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = in.read(buffer, 0, buffer.length)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void invertFile(String srcFile, String destFile) throws IOException {
        try (
                InputStream in = Files.newInputStream(Paths.get(srcFile));
                OutputStream out = Files.newOutputStream(Paths.get(destFile));
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

    public static void encryptFile(String srcFile, String destFile, int key) throws IOException {
        try (
                InputStream in = Files.newInputStream(Paths.get(srcFile));
                OutputStream out = Files.newOutputStream(Paths.get(destFile));
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

    public static void decryptFile(String srcFile, String destFile, int key) throws IOException {
        encryptFile(srcFile, destFile, key);
    }
}
