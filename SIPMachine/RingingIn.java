package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class RingingIn extends SIPState {
	
	public RingingIn(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedInvite(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.BUSY);
	}

	@Override
	public void ReceivedAck(StateData stateData) throws IOException {
		sipMachine.getAudioStreamUDP().startStreaming();
		sipMachine.setSIPState(State.INSESSION);
	}

	
}