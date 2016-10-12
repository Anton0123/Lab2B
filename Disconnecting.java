package Lab2B;

public class Disconnecting implements SIPState {

	SIPMachine sipMachine;
	
	public Disconnecting(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void ReceivedTRO(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedInvite(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedBusy(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedError(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedBye(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedAck(StateData stateData) {
		sipMachine.setSIPState(State.WAITING);
	}

	@Override
	public void SendTRO(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendInvite(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendBusy(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendError(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendBye(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendAck(StateData stateData) {
		// TODO Auto-generated method stub
		
	}


	
}