package slanitsch.ue12.byte_io_and_files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestByteIO {

    public static void main(String[] args) throws IOException {
        invertFile("resources/Was_stellt_das_verschluesselte_Bild_dar.gif", "resources/neue_darstellung.gif");
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
                    if(buffer[i]==0){
                        buffer[i]=1;
                    }else{
                        buffer[i]=0;
                    }
                }
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
