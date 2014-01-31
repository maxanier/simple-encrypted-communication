package com.sec.server;

import com.sec.abi.EnhancedServer;
import com.sec.util.*;
import java.util.ArrayList;
import java.math.BigInteger;


public abstract class EncryptedServer extends EnhancedServer {
	ArrayList<EConnection> eConnections;
	private final int primeLength = 5;

	public EncryptedServer(int pPortNr) {
		super(pPortNr);
		eConnections = new ArrayList<EConnection>();
	}
	
	/**
	 * Processes new connection and starts the encrypting process respectively the Diffie-Hellmanm-Key-exchange
	 */
	@Override
	public final void processNewConnection(String pClientIP, int pClientPort){
		GUI.log("New connection: " + pClientIP + ":" + pClientPort);
		BigInteger prime = Calc.prime(primeLength);
		eConnections.add(new EConnection(pClientIP, pClientPort, prime, Calc.primeRoot(prime)));
	}
	
	/**
	 * Processes new Message, which is either used to establish the encrypted connection or ,if already encrypted, decrypted and calls processEncryptedMessage() 
	 */
	@Override
	public final void processMessage(String pClientIP, int pClientPort, String pMessage){
		GUI.log("New msg: " + pMessage + "\nfrom: " + pClientIP + ":" + pClientPort);
	}
	
	/**
	 * Encrypts the message and sends it to the given client
	 */
	@Override
	public final void send(String pClientIP, int pClientPort, String pMessage){
		GUI.log("Encrypted and sent: " + pMessage + "\nto: " + pClientIP + ":" + pClientPort);
	}
	
	/**
	 * Encrypts the message and sends it to all clients
	 * @param pMessage message
	 */
	@Override
	public final void sendToAll(String pMessage){
		GUI.log("Encrypted and sent to all: " + pMessage);
	}
	
	
	/**
	 * Closes connection and ends encryption
	 */
	@Override
	public final void processClosedConnection(String pClientIP, int pClientPort){
		GUI.log("Connection closed: " + pClientIP + ":" + pClientPort);
	}
  
	/**
	 * Is called if a new encrypted connection is established.
	 * @param pClientIp ClientIp
	 * @param pClientPort ClientPort
	 */
	public abstract void processNewEncryptedConnection(String pClientIp,int pClientPort);
	
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
