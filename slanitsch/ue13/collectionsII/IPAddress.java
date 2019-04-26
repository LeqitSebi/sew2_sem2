package slanitsch.ue13.collectionsII;

public class IPAddress {
    private int Ip;

    public IPAddress(int Ip) {
        setIp(Ip);
    }

    public IPAddress() {
        setIp("172.0.0.1");
    }

    public IPAddress(int o3, int o2, int o1, int o0) {
        setIp(o3, o2, o1, o0);
    }

    public IPAddress(int[] Ip) {
        setIp(Ip);
    }

    public IPAddress(String Ip) {
        setIp(Ip);
    }

    public void setIp(int Ip) {
        this.Ip = Ip;
    }

    public void setIp(int o3, int o2, int o1, int o0) {

        if (o0 < 0 || o0 > 255 || o1 < 0 || o1 > 255 || o2 < 0 || o2 > 255 || o3 < 0 || o3 > 255) {
            throw new IllegalArgumentException();
        } else {

            this.Ip = (o3 << 24) + (o2 << 16) + (o1 << 8) + o0;
        }
    }

    public void setIp(int[] Ip) {
        setIp(Ip[0], Ip[1], Ip[2], Ip[3]);
    }

    public void setIp(String Ip) {
        String[] StringIp = Ip.split("\\.");

        setIp(Integer.parseInt(StringIp[0]), Integer.parseInt(StringIp[1]), Integer.parseInt(StringIp[2]), Integer.parseInt(StringIp[3]));
    }

    public int getAsInt(){
        return Ip;
    }

    public int getOctet(int num) {
        if (num < 0 || num > 3) {
            throw new IllegalArgumentException();
        } else {
            if (num == 0) {
                return Ip >>> 24 & 0xff;
            }
            if (num == 1){
                return Ip >>> 16 & 0xff;
            }
            if (num == 2){
                return Ip >>> 8 & 0xff;
            }
        }
        return Ip & 0xff;
    }

    public int[] getAsArray(){

        int[] IpAddress = new int[4];
        IpAddress[0] = Ip >>> 24 & 0xff;
        IpAddress[1] = Ip >>> 16 & 0xff;
        IpAddress[2] = Ip >>> 8 & 0xff;
        IpAddress[3] = Ip & 0xff;

        return IpAddress;
    }

    @Override
    public String toString(){

        int [] getIp = getAsArray();
        String output = " ";

        for (int i = 0; i < 4; i++) {
            output += getIp[i] + ".";

        }
        return output.substring(0,output.length()-1);
    }
}