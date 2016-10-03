package Lab2B;

public class SIPMachine {
	
	private SIPState waiting, ringing, inSession;

	private SIPState sipState;

	public SIPMachine(){
		waiting = new Waiting(this);
		ringing = new Ringing(this);
		inSession = new InSession(this);

		sipState = waiting:
	}

	public void setSIPState(SIPState newSIPState){
		sipState = newSIPState;
	}

	public void Ring(InetAddr toIp){
		sipState.Ring(toIp);
	}

	public void Ring(String toSIP){
		sipState.Ring(sipToIp(toSIP));
	}

	private static InetAddr sipToIp(String SIP){

	}
	
}
