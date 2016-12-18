package Lab2B.SIPMachine;

import java.io.IOException;

public class Disconnecting extends SIPState {

	public Disconnecting(SIPMachine newSIPMachine){
		super(newSIPMachine);
		System.out.println("Disconnecting");
	}

	@Override
	public SIPState ReceivedAck() {
		System.out.println("Disconnecting - ReceivedAck");
		sipMachine.getAudioStreamUDP().stopStreaming();
		try {
			sipMachine.getStateData().getSocket().close();
		} catch (IOException e) {
		}
			
		return new Waiting(sipMachine);
	}


	
}