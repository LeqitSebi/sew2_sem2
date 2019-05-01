package slanitsch.ue11.textio;

import java.io.IOException;

//final für die abgabe am 27.2.2019


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DiverseMethoden {
    public static void main(String[] args) throws IOException {
        //convertFileToLowerCase("resources/eingabe.txt", "resources/ausgabe.txt");
        //System.out.println(compareFiles("resources/eingabe.txt", "resources/ausgabe.txt"));
        //encryptFile("resources/eingabe.txt", "resources/ausgabe.txt");
        //decryptFile("resources/ausgabe.txt", "resources/eingabe.txt");
        countChar("resources/eingabe.txt", "resources/statisticString.txt");
    }


    public static void convertFileToUpperCase(String srcFile, String destFile) throws IOException {
        try (
                    BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
                BufferedWriter out = Files.newBufferedWriter(Paths.get(destFile), Charset.forName("UTF-8"));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line.toUpperCase() + System.lineSeparator());
            }
        }
    }

    public static void convertFileToLowerCase(String srcFile, String destFile) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
                BufferedWriter out = Files.newBufferedWriter(Paths.get(destFile), Charset.forName("UTF-8"));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line.toLowerCase() + System.lineSeparator());
            }
        }
    }

    public static boolean compareFiles(String srcFile1, String srcFile2) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile1), Charset.forName("UTF-8"));
                BufferedReader in2 = Files.newBufferedReader(Paths.get(srcFile2), Charset.forName("UTF-8"));
        ) {

            String line;
            String lineToComp;
            while ((line = in.readLine()) != null) {
                lineToComp = in2.readLine();
                if (!line.equals(lineToComp)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void encryptFile(String srcFile, String destFile) throws IOException {
        String secretKey = "august";
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
                BufferedWriter out = Files.newBufferedWriter(Paths.get(destFile), Charset.forName("UTF-8"));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                String output = CryptoCode.encrypt(line, secretKey);
                out.write(output + System.lineSeparator());
            }

        }
    }

    public static void decryptFile(String srcFile, String destFile) throws IOException {
        String secretKey = "august";
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
                BufferedWriter out = Files.newBufferedWriter(Paths.get(destFile), Charset.forName("UTF-8"));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                String output = CryptoCode.decrypt(line, secretKey);
                out.write(output + System.lineSeparator());
            }

        }
    }

    public static void countChar(String srcFile, String statisticFile) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
                BufferedWriter out = Files.newBufferedWriter(Paths.get(statisticFile), Charset.forName("UTF-8"));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                int count[] = new int[256];
                int len = line.length();
                for (int i = 0; i < len; i++)
                    count[line.charAt(i)]++;
                char ch[] = new char[line.length()];
                for (int i = 0; i < len; i++) {
                    ch[i] = line.charAt(i);
                    int find = 0;
                    for (int j = 0; j <= i; j++) {

                        if (line.charAt(i) == ch[j])
                            find++;
                    }
                    if (find == 1)
                        out.write(line.charAt(i) + ";" + count[line.charAt(i)] + System.lineSeparator());
                }

            }
        }
    }




}
