simple-encrypted-communication
==============================

A very simple Client-Server encypted communication system using the Diffie-Hellmann-key-exchange

Protokoll:

Client:						Server:
-verbindet					+START <p> <q> <A>

-START2 <B>					+OK
							-ERR: Encryption already established
							-ERR: Parameter wrong
							
-MSG <msg>					+MSG <msg>
//Encrypted Message		
Test