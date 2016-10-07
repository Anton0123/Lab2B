package Lab2B;

import java.net.InetAddress;

public interface SIPState{
	
	void Ring(InetAddress inetAddress); 
	void Disconnect();
	
	// void HangUp(); etc...
	
}
