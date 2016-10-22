package Lab2B.States;

import Lab2B.SIPMachine;
import Lab2B.SIPState;
import Lab2B.StateData;
import Lab2B.Enums.Message;
import Lab2B.Enums.State;

public class InSession extends SIPState {

	public InSession(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedBye(StateData stateData) {
		stateData.getOut().print(Message.ACK);
		sipMachine.setSIPState(State.WAITING);
	}

	@Override
	public void sendBye(StateData stateData) {
		stateData.getOut().print(Message.BYE);
		sipMachine.setSIPState(State.DISCONNECTING);
	}

	
}