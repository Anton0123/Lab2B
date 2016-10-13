package Lab2B;

public class Disconnecting extends SIPState {

	SIPMachine sipMachine;
	
	public Disconnecting(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void ReceivedAck(StateData stateData) {
		sipMachine.setSIPState(State.WAITING);
	}


	
}