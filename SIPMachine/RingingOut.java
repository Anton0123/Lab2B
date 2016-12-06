package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;

public class RingingOut extends SIPState {

	public RingingOut(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public SIPState ReceivedTRO(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.ACK);
		sipMachine.getAudioStreamUDP().startStreaming();
		return new InSession(sipMachine);
	}


	
}