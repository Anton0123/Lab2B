package Lab2B;

import java.io.PrintWriter;
import java.net.InetAddress;

public interface SIPState{
	
	void Ring(InetAddress inetAddress, PrintWriter out); 
	void Disconnect();
	
	// void HangUp(); etc...
	
}
