package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;

public class RingingIn extends SIPState {
	
	public RingingIn(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public SIPState ReceivedInvite(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.BUSY);
		return null;
	}

	@Override
	public SIPState ReceivedAck(StateData stateData) throws IOException {
		sipMachine.getAudioStreamUDP().startStreaming();
		return new InSession(sipMachine);
	}

	
}