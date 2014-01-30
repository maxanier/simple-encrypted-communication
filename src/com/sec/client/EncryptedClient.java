package com.sec.client;

import com.sec.abi.Client;

public abstract class EncryptedClient extends Client {

	
	/**
	 * Creates a new EncryptedClient and establishes a encrypted connection.
	 * @param pIPAdresse
	 * @param pPortNr
	 */
	public EncryptedClient(String pIPAdresse, int pPortNr) {
		super(pIPAdresse, pPortNr);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Decrypts message and passes it to processEncryptedMessage()
	 */
	@Override
	public final void processMessage(String pMessage) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Encrypts the message and sends it to the server
	 */
	@Override
	public final void send(String pMessage){
		
	}
	
	/**
	 * Is called when a message is received
	 * @param pMessage
	 */
	public abstract void processEncryptedMessage(String pMessage);
	
	


}
