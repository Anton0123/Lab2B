package Lab2B;

public class RingingIn extends SIPState {

	SIPMachine sipMachine;
	
	public RingingIn(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
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
	public void ReceivedError(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
		sipMachine.setSIPState(State.WAITING);
	}

	@Override
	public void ReceivedAck(StateData stateData) {
		// Setup UDP connection here? or call sipMachine.getSipState(State.INSESSION).InitCall(stateData); ?
		sipMachine.setSIPState(State.INSESSION);
	}

	
}