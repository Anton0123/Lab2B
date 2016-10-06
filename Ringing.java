package Lab2B;

import java.net.InetAddress;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Ringing implements SIPState {

	SIPMachine sipMachine;
	
	public Ringing(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void Ring(InetAddress inetAddress) {
		sipMachine.setSIPState(this); // sipMachine.ringing instead? //
		throw new NotImplementedException();
	}
	
}