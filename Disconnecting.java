package Lab2B;

import java.net.InetAddress;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Disconnecting implements SIPState {

	SIPMachine sipMachine;
	
	public Disconnecting(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void Ring(InetAddress inetAddress) {
		sipMachine.setSIPState(this); // sipMachine.ringing instead? //
		throw new NotImplementedException();
	}

	@Override
	public void Disconnect() {
		throw new NotImplementedException();
	}
	
}