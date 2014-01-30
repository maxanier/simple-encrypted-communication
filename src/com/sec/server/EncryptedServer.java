package com.sec.server;

import com.sec.abi.Server;

public abstract class EncryptedServer extends Server {

	public EncryptedServer(int pPortNr) {
		super(pPortNr);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Processes new connection and starts the encrypting process respectively the Diffie-Hellmanm-Key-exchange
	 */
	@Override
	public final void processNewConnection(String pClientIP, int pClientPort){
		
	}
	
	/**
	 * Processes new Message, which is either used to establish the encrypted connection or ,if already encrypted, decrypted and calls processEncryptedMessage() 
	 */
	@Override
	public final void processMessage(String pClientIP, int pClientPort, String pMessage){
		
	}
	
	/**
	 * Encrypts the message and sends it to the given client
	 */
	@Override
	public final void send(String pClientIP, int pClientPort, String pMessage){
		
	}
	
	/**
	 * Encrypts the message and sends it to all clients
	 * @param pMessage message
	 */
	@Override
	public final void sendToAll(String pMessage){
		
	}
	
	
	/**
	 * Closes connection and ends encryption
	 */
	@Override
	public final void processClosedConnection(String pClientIP, int pClientPort){
		
	}
  
	/**
	 * Is called if a new encrypted connection is established.
	 * @param pClientIp ClientIp
	 * @param pClientPort ClientPort
	 */
	public abstract void processNewEncryptedConntection(String pClientIp,int pClientPort);
	
	/**
	 * Is called if the server receives a new encrypted message.
	 * @param pClientIP ClientIp
	 * @param pClientPort ClientPort
	 * @param pMessage Decrypted Message
	 */
	public abstract void processEncryptedMessage(String pClientIP, int pClientPort, String pMessage);
	
	/**
	 * Is called if encrypted connection is closed.
	 * @param pClientIP ClientIp
	 * @param pClientPort ClientPort
	 */
	public abstract void processClosedEncryptedConnection(String pClientIP, int pClientPort);
	


}
