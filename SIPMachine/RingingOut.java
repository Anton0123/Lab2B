package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;

public class RingingOut extends SIPState {

	public RingingOut(SIPMachine newSIPMachine){
		super(newSIPMachine);
		System.out.print("RingingOut");
	}

	@Override
	public SIPState ReceivedTRO() throws IOException {
		System.out.println("RingingOut - ReceivedTRO");
		sipMachine.sendMessage(Message.ACK);
		sipMachine.getAudioStreamUDP().startStreaming();
		return new InSession(sipMachine);
	}
	
	@Override
	public SIPState ReceivedBusy() throws IOException{
		System.out.println("Call declined.");
		return new Waiting(sipMachine);
	}


	
}