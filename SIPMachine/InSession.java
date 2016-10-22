package Lab2B.SIPMachine;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class InSession extends SIPState {

	public InSession(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedBye(StateData stateData) {
		stateData.getOut().print(Message.ACK);
		sipMachine.getAudioStreamUDP().stopStreaming();
		sipMachine.setSIPState(State.WAITING);
	}

	@Override
	public void sendBye(StateData stateData) {
		stateData.getOut().print(Message.BYE);
		sipMachine.setSIPState(State.DISCONNECTING);
	}

	
}