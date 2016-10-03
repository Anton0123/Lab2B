package Lab2B;

import java.net.InetAddress;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SIPMachine {
	
	private SIPState waiting, ringing, inSession;

	private SIPState sipState;

	public SIPMachine(){
		waiting = new Waiting(this);
		//ringing = new Ringing(this);
		//inSession = new InSession(this);

		sipState = waiting;
	}

	public void setSIPState(SIPState newSIPState){
		sipState = newSIPState;
	}

	public void Ring(InetAddress toIp){
		sipState.Ring(toIp);
	}

	public void Ring(String toSIP){
		sipState.Ring(sipToIp(toSIP));
	}

	private static InetAddress sipToIp(String SIP){
		throw new NotImplementedException();
	}
	
}
