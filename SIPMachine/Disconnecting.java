package Lab2B.SIPMachine;

import Lab2B.SIPMachine.Enums.State;

public class Disconnecting extends SIPState {

	public Disconnecting(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedAck(StateData stateData) {
		sipMachine.getAudioStreamUDP().stopStreaming();
		sipMachine.setSIPState(State.WAITING);
	}


	
}