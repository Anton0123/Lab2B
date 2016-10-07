package Lab2B;

public class SIPMachine {
	
	private SIPState waiting, ringing, inSession, disconnecting;
	private SIPState sipState;

	public SIPMachine(){
		waiting = new Waiting(this);
		ringing = new Ringing(this);
		inSession = new InSession(this);
		disconnecting = new Disconnecting(this);
		
		sipState = waiting;
	}

	public void setSIPState(SIPState newSIPState){
		sipState = newSIPState;
	}


	
}
