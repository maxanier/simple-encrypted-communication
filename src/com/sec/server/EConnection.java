package com.sec.server;

import java.math.BigInteger;

public class EConnection {
	private String ip;
	private int port;
	private BigInteger p, g;
	public EConnection(String pIP, int pPort, BigInteger pP, BigInteger pG) {
		ip = pIP;
		port = pPort;
		p = pP;
		g = pG;
	}
	public String getIP() {
		return ip;
	}
	public int getPort() {
		return port;
	}
	public BigInteger getP() {
		return p;
	}
	public BigInteger getG() {
		return g;
	}
}
