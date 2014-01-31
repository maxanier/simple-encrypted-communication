package com.sec.server;

public class SECServer extends EncryptedServer {

	public SECServer() {
		super(6000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processNewEncryptedConnection(String pClientIp, int pClientPort) {
		GUI.log("New ec: " + pClientIp + ":" + pClientPort);
	}

	@Override
	public void processEncryptedMessage(String pClientIP, int pClientPort,
			String pMessage) {
		GUI.log("New msg: " + pMessage + "\nfrom: " + pClientIP + ":" + pClientPort);
	}

	@Override
	public void processClosedEncryptedConnection(String pClientIP,
			int pClientPort) {
		GUI.log("Closed ec: " + pClientIP + ":" + pClientPort);
	}

}
