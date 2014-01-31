package com.sec.client;


import java.math.BigInteger;

import com.sec.abi.EnhancedClient;
import com.sec.server.GUI;
import com.sec.util.Calc;
import com.sec.util.Protokoll;

public abstract class EncryptedClient extends EnhancedClient {
	
	private boolean encrypted=false;

	private BigInteger key;
	
	/**
	 * Creates a new EncryptedClient and establishes a encrypted connection.
	 * @param pIPAdresse
	 * @param pPortNr
	 */
	public EncryptedClient(String pIPAdresse, int pPortNr) {
		super(pIPAdresse, pPortNr);
		
		
	}	

	/**
	 * Decrypts message and passes it to processEncryptedMessage()
	 */
	@Override
	public final void processMessage(String pMessage) {
		GUI.log("Received Message: "+pMessage);
		
		if(pMessage.startsWith(Protokoll.SERVER_START)){
			String parameter=pMessage.substring(Protokoll.SERVER_START.length()+1);
			String[] values =parameter.split(" ");
			if(values.length!=3){
				GUI.log("START command doesn´t contain all parameters");
				super.send(Protokoll.ENCRYPTION_FAILED);
				return;
			}
			
			try {
				
				BigInteger p=new BigInteger(values[0]);
				BigInteger q=new BigInteger(values[1]);
				BigInteger A=new BigInteger(values[2]);
				
				if(!calculateKey(p,q,A)){
					GUI.log("Failed to calculate key");
					super.send(Protokoll.ENCRYPTION_FAILED);
					return;
				}
				GUI.log("Encryption created");
				
			} catch (NumberFormatException e) {
				GUI.log("Could not parse START parameter");
				super.send(Protokoll.ENCRYPTION_FAILED);
				return;
			}
			
		}
		else if(pMessage.startsWith(Protokoll.MESSAGE)){
			String decrypted=decrypt(pMessage.substring(Protokoll.MESSAGE.length()+1));
			processEncryptedMessage(decrypted);
		}
		else{
			GUI.log("Message doesn´t match protokoll");
		}
		GUI.log("Finished processing message");
	}
	
	/**
	 * Encrypts the message and sends it to the server
	 */
	@Override
	public final void send(String pMessage){
		String encrypted=encrypt(pMessage);
		if(encrypted==null){
			GUI.log("Encryption is not established yet");
		}
		super.send(Protokoll.MESSAGE+" "+encrypted);
	}
	
	
	
	/**
	 * Is called when a message is received
	 * @param pMessage
	 */
	public abstract void processEncryptedMessage(String pMessage);
	
	
	private String decrypt(String msg){
		if(!encrypted){
			GUI.log("Encryption isn´t established yet");
			return null;
		}
		
		String decrypted = null;
		
		
		return decrypted;
	}
	
	private String encrypt(String msg){
		if(!encrypted){
			GUI.log("Encryption isn´t established yet");
			return null;
		}
		
		String encrypted=null;
		
		return encrypted;
		
	}
	
	private boolean calculateKey(BigInteger p,BigInteger q,BigInteger A){
		BigInteger B;
		try {
			BigInteger b=Calc.random(p, 2);
			B = q.pow(b.intValue());
					
			key=(A.pow(b.intValue())).mod(p);
		} catch (Exception e) {
			GUI.log("Failed to calculate Key: "+e.getMessage());
			return false;
		}
		super.send(Protokoll.CLIENT_START+" "+B);
		GUI.log("Calculated key: "+key);
		return true;
		
	}

}
