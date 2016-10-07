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
	
	public void receivedInvite(){
		sipState.ReceivedInvite();
	}
	
	public void receivedTRO(){
		sipState.ReceivedTRO();
	}
	
	public void receivedAck(){
		sipState.ReceivedAck();
	}

	public void receivedBusy(){
		sipState.ReceivedBusy();
	}
	
	public void receivedError(){
		sipState.ReceivedError();
	}
	

	
}
