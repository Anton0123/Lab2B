package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class RingingOut extends SIPState {

	public RingingOut(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedTRO(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.ACK);
		sipMachine.getAudioStreamUDP().startStreaming();
		sipMachine.setSIPState(State.INSESSION);
	}


	
}