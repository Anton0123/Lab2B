package Lab2B;

public class Disconnecting implements SIPState {

	SIPMachine sipMachine;
	
	public Disconnecting(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void ReceivedTRO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedInvite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedBusy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedError() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedBye() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedAck() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendInvite() {
		// TODO Auto-generated method stub
		
	}


	
}