package slanitsch.ue13.collectionsII;

import java.util.*;

/**
 * Klasse zum testen
 */
public class TestSet {
    /**
     * Hauptmethode zum Aufrufen anderer
     * @param sIP
     */
    private static void testSet(Set<IPAddress> sIP) {
        sIP.add(new IPAddress("10.0.0.1"));
        sIP.add(new IPAddress("10.0.0.2"));
        sIP.add(new IPAddress("10.0.0.1"));
        System.out.println("sIP.size() = " + sIP.size());
        for (IPAddress ip : sIP) {
            System.out.println("ip = " + ip);
        }
    }

    /**
     * Fügt ein Ganzes Subnet in ein Set hinzu und gibt aus wie lange es dauerte
     * @param subnet
     * @return
     */
    private static long testFullSubnet(Subnet subnet) {
        long timeAtStart = System.currentTimeMillis();
        int ipInt = subnet.getNet().getIP();
        Set<IPAddress> ipSet = new HashSet<>();
        for (int i = 0; i < ~subnet.getMask().getIP(); i++) {
            ipSet.add(new IPAddress(ipInt));
            ipInt++;
        }
        return System.currentTimeMillis() - timeAtStart;
    }

    /**
     * Gibt den Gateway eines Subnetzes in einer Map zurück
     * @param subnet
     * @return
     */
    private static Map NextHop(Subnet subnet) {
        Map<IPAddress, Subnet> subnetMap = new HashMap<>();
        subnetMap.put(new IPAddress(subnet.getNet().getIP() & subnet.getMask().getIP()), subnet);
        return subnetMap;
    }

    /**
     * Fügt 5 Gateway-Addressen in eine Map hinzu
     * @param nextHop
     */
    private static void testNextHop(Map<Subnet, IPAddress> nextHop) {
        nextHop.put(new Subnet(new IPAddress("10.0.0.0"), 8), new IPAddress("10.255.255.254"));
        nextHop.put(new Subnet(new IPAddress("10.0.0.0"), 16), new IPAddress("10.0.255.254"));
        nextHop.put(new Subnet(new IPAddress("10.0.0.0"), 24), new IPAddress("10.0.0.254"));
        nextHop.put(new Subnet(new IPAddress("192.168.0.0"), 16), new IPAddress("192.168.255.254"));
        nextHop.put(new Subnet(new IPAddress("192.168.0.0"), 24), new IPAddress("192.168.0.254"));
        System.out.println(nextHop);
    }

    /**
     * Hauptmethode zum Aufrufen anderer
     * @param args
     */
    public static void main(String[] args) {
        Set<IPAddress> setIP = new HashSet<>();
        Set<IPAddress> treeIP = new TreeSet<>();
        testSet(setIP);
        testSet(treeIP);
        System.out.println();

        TreeSet<IPAddress> IPTree = new TreeSet<>();
        testSet(IPTree);
        System.out.println();

        System.out.println(testFullSubnet(new Subnet(new IPAddress("10.0.0.0"), 24)) + "ms");
        System.out.println(testFullSubnet(new Subnet(new IPAddress("10.0.0.0"), 16)) + "ms");
        System.out.println(testFullSubnet(new Subnet(new IPAddress("10.0.0.0"), 8)) + "ms");
        System.out.println("HashSet ist schneller \n");

        System.out.println(NextHop(new Subnet(new IPAddress("10.0.0.0"), 24)));
        Map<Subnet, IPAddress> treeMap = new HashMap<>();//TreeMap funktioniert nicht
        testNextHop(treeMap);
        System.out.println(treeMap.get("10.255.255.254"));
        System.out.println(treeMap.get("10.255.255.253"));
        System.out.println();

        HashMap<Subnet, IPAddress> nextWithHash = new HashMap<>();
        testNextHop(nextWithHash); // In meinem Fall brauchte man nichts extriges
    }
}

/**
 * Klasse für Comperators
 */
class MySubnetComparator implements Comparator<Subnet> {
    /**
     * Cpmpare-Methode
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Subnet o1, Subnet o2) {
        int ret = 0;
        if (o1.getNet().getIP() < o2.getNet().getIP()) {
            ret = 1;
        } else if (o1.getNet().getIP() > o2.getNet().getIP()) {
            ret = -1;
        }
        return ret;
    }

    TreeMap<Subnet, IPAddress> next = new TreeMap<>(new MySubnetComparator());
}