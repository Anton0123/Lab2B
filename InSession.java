package Lab2B;


public class InSession extends SIPState {

	SIPMachine sipMachine;
	
	public InSession(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
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