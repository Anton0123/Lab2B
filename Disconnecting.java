package Lab2B;

import java.io.PrintWriter;
import java.net.InetAddress;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Disconnecting implements SIPState {

	SIPMachine sipMachine;
	
	public Disconnecting(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void Disconnect() {
		throw new NotImplementedException();
	}

	@Override
	public void Ring(InetAddress inetAddress, PrintWriter out) {
		// TODO Auto-generated method stub
		
	}
	
}