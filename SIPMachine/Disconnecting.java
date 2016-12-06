package Lab2B.SIPMachine;

public class Disconnecting extends SIPState {

	public Disconnecting(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public SIPState ReceivedAck(StateData stateData) {
		sipMachine.getAudioStreamUDP().stopStreaming();
		return new Waiting(sipMachine);
	}


	
}