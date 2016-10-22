package Lab2B.SIPMachine;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class RingingIn extends SIPState {
	
	public RingingIn(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedInvite(StateData stateData) {
		stateData.getOut().print(Message.BUSY);
	}

	@Override
	public void ReceivedBusy(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
		sipMachine.setSIPState(State.WAITING);
	}

	@Override
	public void ReceivedAck(StateData stateData) {
		// Setup UDP connection here? or call sipMachine.getSipState(State.INSESSION).InitCall(stateData); ?
		sipMachine.setSIPState(State.INSESSION);
	}

	
}