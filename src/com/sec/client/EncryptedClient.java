package com.sec.client;


import com.sec.abi.EnhancedClient;
import com.sec.server.GUI;
import com.sec.util.Protokoll;

public abstract class EncryptedClient extends EnhancedClient {
	
	private boolean encrypted=false;

	private int key;
	
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
				return;
			}
			
			try {
				int p=Integer.parseInt(values[0]);
				int q=Integer.parseInt(values[1]);
				int a=Integer.parseInt(values[2]);
				
				if(!calculateKey(p,q,a)){
					GUI.log("Failed to calculate key");
					super.send(Protokoll.ENCRYPTION_FAILED);
				}
				
			} catch (NumberFormatException e) {
				GUI.log("Could not parse START parameter");
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
	
	private boolean calculateKey(int p,int q,int a){
		
	}

}
