package Lab2B;

import java.net.InetAddress;

public class Waiting implements SIPState {

	SIPMachine sipMachine;
	
	public Waiting(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void Ring(InetAddress inetAddress) {
		// TODO Auto-generated method stub
		
	}
	
}