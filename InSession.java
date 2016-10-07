package Lab2B;

import java.net.InetAddress;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class InSession implements SIPState {

	SIPMachine sipMachine;
	
	public InSession(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void Ring(InetAddress inetAddress) {
		throw new NotImplementedException();
	}

	@Override
	public void Disconnect() {
		throw new NotImplementedException();
	}
	
}