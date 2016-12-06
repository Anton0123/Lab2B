package Lab2B.SIPMachine;

import java.io.IOException;
import Lab2B.SIPMachine.Enums.Message;

public class InSession extends SIPState {

	public InSession(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public SIPState ReceivedBye(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.ACK);
		sipMachine.getAudioStreamUDP().stopStreaming();
		return new Waiting(sipMachine);
	}

	@Override
	public SIPState SendBye(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.BYE);
		return new Disconnecting(sipMachine);
	}

	
}