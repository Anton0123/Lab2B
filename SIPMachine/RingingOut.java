package Lab2B.SIPMachine;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class RingingOut extends SIPState {

	public RingingOut(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedTRO(StateData stateData) {
		stateData.getOut().print(Message.ACK);
		sipMachine.getAudioStreamUDP().startStreaming();
		sipMachine.setSIPState(State.INSESSION);
	}

	@Override
	public void ReceivedBusy(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
		sipMachine.setSIPState(State.WAITING);
	}

	
}