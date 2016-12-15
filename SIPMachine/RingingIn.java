package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;

public class RingingIn extends SIPState {
	
	public RingingIn(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public SIPState ReceivedInvite() throws IOException {
		System.out.println("RingingIn - ReceivedInvite");
		sipMachine.sendMessage(Message.BUSY);
		return null;
	}

	@Override
	public SIPState ReceivedAck() throws IOException {
		System.out.println("RingingIn - ReceivedAck");
		sipMachine.getAudioStreamUDP().startStreaming();
		return new InSession(sipMachine);
	}

	
}