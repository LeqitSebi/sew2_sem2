package slanitsch.ue13.collectionsII;

/**
 * Diese Klasse dient dazu, Subnetze anlegen zu können (IP Adressen mit Subnetzen)
 */
public class Subnet {
    private IPAddress addr;
    private IPAddress mask;

    public final IPAddress LOCALHOST = new IPAddress("192.168.10.0");
    public final IPAddress MODEM = new IPAddress("10.0.0.138");

    /**
     * Dieser Konstruktor dient dazu, ein Subnnet mit einem Netzwerk als String anzulegen
     * @param network als String
     */
    public Subnet(String network){
        setMask(network);
    }

    /**
     * Dieser Konstruktor dient dazu, ein Subnet mit einer Ip Adresse als IPAddress und einem Präfix als int anzulegen
     * @param Ip als IPAddress
     * @param suffix als int
     */
    public Subnet(IPAddress Ip, int suffix){
        setMask(Ip,suffix);
    }

    /**
     * Dieser Konstruktor dient dazu ein Subnet mit einer Ip Adresse als IPAddress und einer Maske als IPAddress anzulegen
     * @param Ip als IPAddress
     * @param Mask als IPAddress
     */
    public Subnet(IPAddress Ip, IPAddress Mask){
        setMask(Ip,Mask);
    }

    /**
     * Dieser Konstrukter dient dazu ein Subnet mit einer Ip Adresse als String und einer Maske als als String anzulegen
     * @param Ip als String
     * @param Mask als String
     */
    public Subnet(String Ip, String Mask){
        setMask(Ip,Mask);
    }

    /**
     * Dieser Setter dient dazu das Programm für den String-Konstrukter zu schreiben und ihn im Konstruktor einzusetzen
     * @param network
     */
    public void setMask(String network) {
        String[] split = network.split("/");

        this.addr = new IPAddress(split[0]);

        if (split[1].length() > 2) {
            this.mask = new IPAddress(split[1]);
        } else {

            this.mask = new IPAddress(getNetmask(split[1]));
        }
    }

    /**
     * Dieser Setter dient dazu das Programm für den IP&int-Konstruktor zu schreiben und ihn im Konstruktor einzusetzen
     * @param Ip als IPAddress
     * @param suffix als int
     */
    public void setMask(IPAddress Ip, int suffix) {
        this.addr = Ip;
        this.mask = new IPAddress(suffix);
    }

    /**
     * Dieser Setter dient dazu das Programm für den IP&IP-Konstruktor zu schreiben und ihn im Konstruktor einzusetzen
     * @param Ip als IPAddress
     * @param Mask als IPAddress
     */
    public void setMask(IPAddress Ip, IPAddress Mask) {
        this.addr = Ip;
        this.mask = Mask;
    }

    /**
     * Dieser Setter dient dazu das Programm für den String&String-Konstruktor zu schreiben und ihn im Konstruktor einzusetzen
     * @param Ip als String
     * @param Mask als String
     */
    public void setMask(String Ip, String Mask) {
        this.addr = new IPAddress(Ip);

        if (Mask.length() > 2) {
            this.mask = new IPAddress(Mask);
        } else {

            this.mask = new IPAddress(getNetmask(Mask));
        }
    }

    /**
     * Diese Methode liefert die vollständige Netzmaske vom eingegebenen Präfix zurück
     * @param Mask als String
     * @return Netzmaske als int
     */
    public int getNetmask(String Mask){
        int suffix = Integer.parseInt(Mask);

        for (int i = 0; i < 32; i++) {
            suffix = suffix << 1;

            if (i < Integer.parseInt(Mask)){
                suffix = suffix | 1;
            }
        }
        return suffix;
    }

    /**
     * Diese Methode liefert die Netzmaske eines Subnets zurück
     * @return mask
     */
    public IPAddress getNetmask(){
        return mask;
    }

    /**
     * Diese Methode liefert die vollständige Netzmaske vom eingegebenen Netzwerk zurück
     * @param network als String
     * @return Netzmaske als int
     */
    public int getNetmaskFromNetwork(String network) {
        int präfix = getSuffixFromNetwork(network);

        for (int i = 0; i < 32; i++) {
            präfix = präfix << 1;

            if (i < getSuffixFromNetwork(network)) {
                präfix = präfix | 1;
            }
        }
        return präfix;
    }

    /**
     * Diese Methode liefert den Präfix vom eingegebenen Netzwerk zurück
     * @param network als String
     * @return präfix als int
     */
    public static int getSuffixFromNetwork(String network) {
        String[] split = network.split("/");
        int suffix = Integer.parseInt(split[1]);

        return suffix;
    }

    /**
     * Liefert den Präfix eines Subnets zurück
     * @return Präfix als int
     */
    public int getSuffix(){
        return Integer.bitCount(mask.getAsInt());
    }

    /**
     * Liefert die Netzadresse eines Subnets zurück
     * @return Netzadresse als IPAddress
     */
    public IPAddress getNetAddress(){
        return new IPAddress(addr.getAsInt() & mask.getAsInt());
    }

    /**
     * Diese Methode liefert ein Subnet als String zurück
     * @return Subnet als String
     */
    @Override
    public String toString(){
        return addr + "/" + getSuffix();
    }

    /**
     * Diese Methode liefert die Anzahl der möglichen Hosts eines Subnets zurück
     * @return Hostanzahl als int
     */
    public int getNumberOfHosts(){
        return - mask.getAsInt() - 2;
    }

    /**
     * Diese Methode liefert die Broadcastadresse eines Subnets zurück
     * @return Broadcastadresse als IPAddress
     */
    public IPAddress getBroadcastAddress(){
        return new IPAddress(getNetAddress().getAsInt() + getNumberOfHosts() + 1);
    }

    /**
     * Diese Methode liefet die erstmögliche Ip Adresse eines Subnets zurück
     * @return Erste Ip als IPAddress
     */
    public IPAddress getFirstIp(){
        return new IPAddress(getNetAddress().getAsInt() + 1);
    }

    /**
     * Diese Methode liefet die letztmögliche Ip Adresse eines Subnets zurück
     * @return Letzte Ip als IPAddress
     */
    public IPAddress getLastIp(){
        return new IPAddress(getBroadcastAddress().getAsInt() - 1);
    }

}