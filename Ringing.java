package Lab2B;

import java.io.PrintWriter;
import java.net.InetAddress;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Ringing implements SIPState {

	SIPMachine sipMachine;
	
	public Ringing(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void Disconnect() {
		throw new NotImplementedException();
	}

	@Override
	public void Ring(InetAddress inetAddress, PrintWriter out) {
		out.print(Message.ACK);
	
	}
	
}