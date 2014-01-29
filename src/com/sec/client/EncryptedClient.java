package com.sec.client;

import com.sec.abi.Client;

public abstract class EncryptedClient extends Client {

	public EncryptedClient(String pIPAdresse, int pPortNr) {
		super(pIPAdresse, pPortNr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void processMessage(String pMessage) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public final void send(String pMessage){
		
	}
	
	public abstract void processEncryptedMessage(String pMessage);
	
	
	//Vemutlich überflüssig
	public void sendEncrypted(String pMessage){
		
	}

}
