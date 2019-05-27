package slanitsch.ue13.collectionsIII;


//@author Sebstian Slanitsch


import java.util.*;

public class LongCounter<K> extends HashMap<K, Long> {
    /**
     * Standard-Vergleichsoperator für Keys, die Comparable implementieren,
     * wird z.B. für {@link #mostCommon(int)} verwendet
     */
    private Comparator keyComparator = Comparator.comparing(a -> ((Comparable) a));

    /**
     * Vergleichsoperator für Value- und Key-Paare,
     * so dass zuerst nach der Value und dann nach dem Key gereiht wird.<br>
     * Der Key-Comparator kann mittels {@link #LongCounter(Comparator)} gesetzt werden.
     * wird z.B. für {@link #mostCommon(int)} verwendet
     */
    private final Comparator<Entry<K, Long>> entryComparator = (a, b) -> {
        int d = Long.compare(a.getValue(), b.getValue());
        if (d != 0) {
            return d;
        }

        return keyComparator.compare(b.getKey(), a.getKey());
    };

    /**
     * Der keyComperator wird zum Sortieren für {@link #mostCommon(int)}} und
     * {@link #lessCommon(int)} vewendet.
     *
     * @param keyComparator zum Sortieren der Keys
     */
    private LongCounter(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
    }

    /**
     * Erzeugt einen <tt>LongCounter</tt> mit der Standardkapazität und dem Standard-Loadfaktor<br>
     */
    LongCounter() {
    }

    /**
     * Erzeugt eine LongCounter aus einer beliebigen Map die Long-Values hat
     * @param m die Map mit den schon gezählten Werden
     */
    public LongCounter(Map<? extends K, Long> m) {
        super(m);
    }

    /**
     * Erzeugt einen LongCounter aus dem Objekt-Array
     *
     * @param k das Array mit den zu zählenden Elementen
     */
    public LongCounter(K...k) { for(K key : k) put(key); }

    /**
     * Erzeugt einen LongCounter aus der Collection
     *
     * @param k das Array mit den zu zählenden Elementen
     */
    public LongCounter(Collection<K> k) { for(K key : k) put(key); }

    /**
     * Erzeugt einen LongCounter aus einem String und zählt alle Zeichen in dem String.
     *
     * @param s die zu zählenden Zeichen
     *
     * @return der LongCounter, der alle Zeichen gezählt hat
     */
    static LongCounter<Character> fromString(CharSequence s) {
        LongCounter<Character> counter = new LongCounter<>();
        for (int i = 0; i < s.length(); i++) counter.put(s.charAt(i));

        return counter;
    }

    /**
     * Erhöht den Counter um "value" für den Key.
     *
     * @param key     der Key, dessen value verändert wird
     * @param value   der Wert, um den der Counter verändert werden soll
     *
     * @return der neue Wert des Counters
     */
    public Long put(K key, Long value) {
        super.computeIfAbsent(key, k -> (long) 0);
        return super.put(key, super.get(key) + value);
    }

    /**
     * Erhöht den Counter um "value" für den Key.
     *
     * @param key     der Key, dessen value verändert wird
     * @param value   der Wert, um den der Counter verändert werden soll
     *
     * @return der neue Wert des Counters
     */
    Long put(K key, long value) { return put(key, (Long) value); }

    /**
     * Erhöht den Counter um Eins für den Key.
     *
     * @param key     der Key, dessen value verändert wird
     *
     * @return der neue Wert des Counters
     */
    Long put(K key) { return put(key, 1); }

    /**
     * Erhöht (addiert) die Werte aus der Map "m" zum LongCounter.
     *
     * @param m die Map mit den zu addierenden Werten
     */
    public void putAll(Map<? extends K, ? extends Long> m) {
        for(Entry<? extends K, ? extends Long> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Vermindert (subtrahiert) die Werte aus der Map "m" zum LongCounter.
     *
     * @param m die Map mit den zu subtrahierenden Werten
     */
    void subtractAll(Map<? extends K, ? extends Long> m) {
        for(Entry<? extends K, ? extends Long> entry : m.entrySet()) {
            put(entry.getKey(), -entry.getValue());
        }
    }

    /**
     * Liefert (max.) die "n"-häufigsten Werte, sortiert nach Häufigkeit und danach nach den Keys.
     *
     * @param n die Anzahl der Werte
     * @return die Liste mit den Key/Counter-Paaren
     */
    List<Entry<K, Long>> mostCommon(int n) {
        List<Entry<K, Long>> entrys = new ArrayList<>(entrySet());
        entrys.sort(entryComparator.reversed());

        return entrys.subList(0, Math.min(n, size()));
    }

    /**
     * Liefert (max.) die "n"-seltensten Werte, sortiert nach Häufigkeit und danach nach den Keys.
     *
     * @param n die Anzahl der Werte
     * @return die Liste mit den Key/Counter-Paaren
     */
    List<Entry<K, Long>> lessCommon(int n) {
        List<Entry<K, Long>> entrys = new ArrayList<>(entrySet());
        entrys.sort(entryComparator);

        return entrys.subList(0, Math.min(n, size()));
    }

    /**
     * Löscht alle Einträge aus der Map, deren Counter == 0 ist.
     */
    void clearZeros() { entrySet().removeIf(kLongEntry -> kLongEntry.getValue() == 0); }
}