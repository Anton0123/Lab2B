package Lab2B;

import java.io.PrintWriter;
import java.net.InetAddress;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class InSession implements SIPState {

	SIPMachine sipMachine;
	
	public InSession(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void Ring(InetAddress inetAddress, PrintWriter out) {
		throw new NotImplementedException();
	}

	@Override
	public void Disconnect() {
		throw new NotImplementedException();
	}
	
}