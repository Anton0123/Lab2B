package Lab2B.States;

import Lab2B.SIPMachine;
import Lab2B.SIPState;
import Lab2B.StateData;
import Lab2B.Enums.State;

public class Disconnecting extends SIPState {

	public Disconnecting(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedAck(StateData stateData) {
		sipMachine.setSIPState(State.WAITING);
	}


	
}