package slanitsch.ue11.textio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Schuelerstatistic {
    public static void main(String[] args) throws IOException {
        statistic("resources/ue_TextIO_Schuelerliste_UTF-8.csv", "resources/ue_TextIO_Schuelerliste_ISO-8859-1.csv");

    }


    public static void statistic(String srcFile, String destFile) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
                BufferedWriter out = Files.newBufferedWriter(Paths.get(destFile), Charset.forName("ISO-8859-1"));
        ) {
            out.write("Mechatronik: " + countIT(srcFile) + " Schüler" + System.lineSeparator());
            out.write("Informatik: " + countME(srcFile) + " Schüler" + System.lineSeparator());
            out.write("Anzahl der Klassen: " + CountClasses(srcFile) + System.lineSeparator());
            out.write("Durchschnittliche Klassengröße: " + AverageClasses(srcFile) + System.lineSeparator());
            out.write("Geburtstage pro Monat: " + Arrays.toString(CountMonths(srcFile)) + System.lineSeparator());
        }
    }

    public static int countIT(String srcFile) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
        ) {
            String line;
            int counterIT = 0;
            while ((line = in.readLine()) != null) {
                line = line.substring(line.length() - 2);
                if (line.equals("IT")) {
                    counterIT++;
                }
            }

            return counterIT;
        }
    }


    public static int countME(String srcFile) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(srcFile), Charset.forName("UTF-8"));
        ) {
            String line;
            int counterME = 0;
            while ((line = in.readLine()) != null) {
                line = line.substring(line.length() - 2);
                if (line.equals("ME")) {
                    counterME++;
                }
            }

            return counterME;
        }
    }


    public static int CountClasses(String srcFile1) throws IOException {
        int total = 0;
        try (
                BufferedReader in = Files.newBufferedReader(
                        Paths.get(srcFile1), // die zu lesende Datei
                        Charset.forName("UTF-8") // ihr Zeichensatz
                );
        ) {
            String line;
            String k = "";

            while ((line = in.readLine()) != null) {
                String[] classes = line.split(";");
                if (!k.contains(classes[2])) {
                    total++;
                    k += classes[2];
                }
            }
        }
        return total;
    }

    public static int AverageClasses(String srcFile1) throws IOException {
        int classes = 0; // anzahl der Klassen
        int students = 0; // anzahl der Schüler
        int finish = 0;
        try (
                BufferedReader in = Files.newBufferedReader(
                        Paths.get(srcFile1), // die zu lesende Datei
                        Charset.forName("UTF-8") // ihr Zeichensatz
                );
        ) {
            String line;
            String k = "";

            while ((line = in.readLine()) != null) {
                String[] klassen = line.split(";");
                if (!k.contains(klassen[2])) {
                    classes++;
                    k += klassen[2];
                }
                students++;
            }
            finish = students / classes;
        }
        return finish;
    }

    public static int[] CountMonths(String srcFile1) throws IOException {

        int[] summary = new int[12];

        try (
                BufferedReader in = Files.newBufferedReader(
                        Paths.get(srcFile1), // die zu lesende Datei
                        Charset.forName("UTF-8") // ihr Zeichensatz
                );

        ) {
            String line;

            while ((line = in.readLine()) != null) {

                String[] all = line.split(";");
                String[] date = all[3].split("\\.");
                String month = date[1];

                switch (month) {
                    case "01":
                        summary[0]++;
                        continue;
                    case "02":
                        summary[1]++;
                        continue;
                    case "03":
                        summary[2]++;
                        continue;
                    case "04":
                        summary[3]++;
                        continue;
                    case "05":
                        summary[4]++;
                        continue;
                    case "06":
                        summary[5]++;
                        continue;
                    case "07":
                        summary[6]++;
                        continue;
                    case "08":
                        summary[7]++;
                        continue;
                    case "09":
                        summary[8]++;
                        continue;
                    case "10":
                        summary[9]++;
                        continue;
                    case "11":
                        summary[10]++;
                        continue;
                    case "12":
                        summary[11]++;
                        continue;

                }
            }
        }

        return summary;
    }

}
