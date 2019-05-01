package slanitsch.ue13.collectionsII;

import java.util.*;
import java.util.Map.Entry;

public class MapDemo {

    @SuppressWarnings("all")
    public static void main(String[] args) {

        /* To test use HashMap, LinkedHashMap or TreeMap */
    	Map<String, String> map = new HashMap();          // keine sichtbare Ordnung
//    	Map<String, String> map = new LinkedHashMap<>();  // merkt sich die Reihenfolge, in der die Elemente in die Map gegeben werden
//      Map<String, String> map = new TreeMap<>(); // benützt das normale "compareTo"
//      Map<String, String> map = new TreeMap<>((a,b) -> b.compareToIgnoreCase(a)); // Reverse-Sortiert

        map.put("Anna",   "A");
        map.put("Carmen", "C");
        map.put("Boris",  "B");


        System.out.println("map.size():                 "     + map.size());                 // 3
        System.out.println("map.toString():             "     + map.toString());             // {Carmen=C, Boris=B, Anna=A}

        System.out.println("map.containsKey(\"B\"):       "   + map.containsKey("B"));       // true
        System.out.println("map.containsValue(\"Boris\"): "   + map.containsValue("Boris")); // true

        System.out.println("map.get(\"Anna\"):            "   + map.get("Anna"));            // A
        System.out.println("map.remove(\"Anna\"):         "   + map.remove("Anna"));    // A
        System.out.println("map.put(\"Carmen\", \"CX\"):    " + map.put("Carmen", "CX"));    // C - replaced with CX
        System.out.println("map.toString():             "     + map.toString());             // {Carmen=CX, Boris=B}

        System.out.println("map.isEmpty():              "     + map.isEmpty());              // false

        System.out.println("map.keySet():               " + map.keySet());                   // [Carmen, Boris]
        System.out.println("map.values():               " + map.values());                   // [CX, B]
        System.out.println();

        System.out.print("for (String key: map.keySet()): ");
        for (String key: map.keySet()) {
            System.out.print("(" + key + ": " + map.get(key) + ") "); 			            // (Carmen: CX) (Boris: B)
        }
        System.out.println();

        System.out.print("for (Entry<String, String> entry: map.entrySet()): ");
        for (Entry<String, String> entry: map.entrySet()) {
            String key   = entry.getKey();
            String value = entry.getValue();
            System.out.print("(" + key + ": " + value + ") "); 			                   // (Carmen: CX) (Boris: B)
        }
        System.out.println();



        Map<String, String> map2 = new HashMap<>();
        map2.put("Otto", "O");
        map2.put("Roman", "R");

        map.putAll(map2);

        System.out.println("map.toString() nach putAll: " + map.toString());

        map.clear();
        System.out.println("map.isEmpty()  nach clear:  " + map.isEmpty());       // true
    }
}

