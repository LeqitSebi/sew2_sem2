package slanitsch.ue13.collectionsIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Cocktailbar {

    public static void main(String[] args) throws IOException {
        printList("resources/CocktailMix_short.txt");
        printList("resources/CocktailMix.txt");
    }

    private static void printList(String inputFile) throws IOException {
        try (
                BufferedReader input = Files.newBufferedReader(
                        Paths.get(inputFile),
                        Charset.forName("UTF-8")
                )

        ) {
            String line;
            Map<String, Collection<String>> cocktails = new TreeMap<>();
            Collection<String> zutaten = new TreeSet<>();

            while ((line = input.readLine()) != null) {
                if (line.isEmpty() || line.startsWith("#")) continue;
                if (line.contains(":")) {
                    String[] part = line.split(":");
                    String[] drinks = part[1].split(",");

                    for (String drink : drinks) {
                        cocktails.computeIfAbsent(drink, k -> new TreeSet<>(Collections.singleton(part[0])));
                        Collection<String> value = cocktails.get(drink);
                        value.add(part[0]);
                    }
                } else {
                    String[] temp = line.replace(", ", ",").split(",");
                    zutaten.addAll(Arrays.asList(temp));
                }

            }
            int counter = 0;

            StringBuilder output = new StringBuilder("Verfügbare Drinks: \n");
            ArrayList<String> drinks = new ArrayList<>(cocktails.keySet());

            for (Collection<String> collection : cocktails.values()) {
                if (doesContain(collection, zutaten)) output.append(drinks.get(counter)).append("\n");
                counter++;
            }
            System.out.println(output);
        }
    }

    private static boolean doesContain(Collection<String> drinks, Collection<String> ingriedients) {
        if (drinks.size() > ingriedients.size()) return false;
        for (String string : drinks) {
            if (!ingriedients.contains(string)) {
                return false;
            }
        }
        return true;
    }
}
