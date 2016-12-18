package Lab2B.SIPMachine;

public class Disconnecting extends SIPState {

	public Disconnecting(SIPMachine newSIPMachine){
		super(newSIPMachine);
		System.out.println("Disconnecting");
	}

	@Override
	public SIPState ReceivedAck() {
		System.out.println("Disconnecting - ReceivedAck");
		sipMachine.getAudioStreamUDP().stopStreaming();
		return new Waiting(sipMachine);
	}


	
}