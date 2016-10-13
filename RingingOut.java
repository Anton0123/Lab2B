package Lab2B;

public class RingingOut extends SIPState {

	SIPMachine sipMachine;
	
	public RingingOut(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void ReceivedTRO(StateData stateData) {
		stateData.getOut().print(Message.ACK);
		sipMachine.setSIPState(State.INSESSION);
	}

	@Override
	public void ReceivedBusy(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
		sipMachine.setSIPState(State.WAITING);
	}

	
}