package com.sec.server;

public class SECServer extends EncryptedServer {

	public SECServer() {
		super(6000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processNewEncryptedConntection(String pClientIp, int pClientPort) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processEncryptedMessage(String pClientIP, int pClientPort,
			String pMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processClosedEncryptedConnection(String pClientIP,
			int pClientPort) {
		// TODO Auto-generated method stub
		
	}

}
