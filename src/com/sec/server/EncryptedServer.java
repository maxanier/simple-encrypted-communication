package com.sec.server;

import com.sec.abi.Server;

public abstract class EncryptedServer extends Server {

	public EncryptedServer(int pPortNr) {
		super(pPortNr);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public final void processNewConnection(String pClientIP, int pClientPort){
		
	}
	
	@Override
	public final void processMessage(String pClientIP, int pClientPort, String pMessage){
		
	}
	
	@Override
	public final void send(String pClientIP, int pClientPort, String pMessage){
		
	}
	
	@Override
	public final void sendToAll(String pMessage){
		
	}
	
	@Override
	public final void processClosedConnection(String pClientIP, int pClientPort){
		
	}
  
	
	public abstract void processNewEncryptedConntection(String pClientIp,int pClientPort);
	public abstract void processEncryptedMessage(String pClientIP, int pClientPort, String pMessage);
	public abstract void processClosedEncryptedConnection(String pClientIP, int pClientPort);
	


}
