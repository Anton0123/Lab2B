package Lab2B;

import java.net.InetAddress;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Waiting implements SIPState {

	SIPMachine sipMachine;
	
	public Waiting(SIPMachine newSIPMachine){
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