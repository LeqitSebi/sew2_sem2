package slanitsch.ue13.collectionsII;

import slanitsch.ue13.collectionsII.IPAddress;

public class Subnet {

	/**
	 * network address
	 */
	private IPAddress net;
	/**
	 * network mask
	 */
	private IPAddress mask;

	/**
	 * create netmask from network ip and number of bits
	 * @param net     network address
	 * @param cidr    number of bits
	 */
	public Subnet(IPAddress net, int cidr) {
		createMask(net, cidr);
	}

	private void createMask(IPAddress net, int cidr) {
		this.net = net;
		this.mask = IPAddress.createNetmask(cidr);
		// System.out.format("n %08x\n", this.net.getIP() & 0xffffffffl);
		// System.out.format("m %08x\n", this.mask.getIP());
		// System.out.format(" %08x\n", (this.net.getIP() & mask.getIP()));
		
		if ((this.net.getIP() & mask.getIP()) != this.net.getIP()) {
			throw new IllegalArgumentException("bad network");
		}
	}

	/**
	 * create netmask from ip (four number) and number of bits
	 * @param a3
	 * @param a2
	 * @param a1
	 * @param a0
	 * @param cidr
	 */
	public Subnet(int a3, int a2, int a1, int a0, int cidr) {
		this(new IPAddress(a3, a2, a1, a0), cidr);
	}
	
	public Subnet(String mask) {
		String[] parts = mask.split("/");
		if (parts.length != 2) {
			throw new IllegalArgumentException("ill formed subnet");
		}
		IPAddress ip = new IPAddress(parts[0]);
		int cidr = Integer.parseInt(parts[1]);
		createMask(ip, cidr);
	}

	public IPAddress getNet() {
		return net;
	}

	public IPAddress getMask() {
		return mask;
	}

	public IPAddress getBroadcast() {
		return new IPAddress( net.getIP() + ~mask.getIP() );
	}

	/**
	 * is IP in this network
	 * @param ip 
	 * @return
	 */
	public boolean contains(IPAddress ip) {
		// System.out.format("i %08x\n", ip.getIP());
		// System.out.format("m %08x\n", mask.getIP());
		// System.out.format("i&m %08x\n", ip.getIP() & mask.getIP());
		// System.out.format("n %08x\n", net.getIP());

		return (ip.getIP() & mask.getIP()) == net.getIP();
	}

	@Override
	public String toString() {
		return "Subnet [net=" + net + ", mask=" + mask + "]";
	}
}
