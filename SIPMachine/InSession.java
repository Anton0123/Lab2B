package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;

public class InSession extends SIPState {

	public InSession(SIPMachine newSIPMachine) {
		super(newSIPMachine);
	}

	@Override
	public SIPState ReceivedBye() throws IOException {
		System.out.println("InSession - ReceivedBye");
		sipMachine.sendMessage(Message.ACK);
		sipMachine.getAudioStreamUDP().stopStreaming();
		sipMachine.getStateData().getSocket().close();
		return new Waiting(sipMachine);
	}

	@Override
	public SIPState SendBye() throws IOException {
		System.out.println("InSession - SendBye");
		sipMachine.sendMessage(Message.BYE);
		System.out.println(sipMachine.getStateData().getAddress() + " - Send to this IP");
		return new Disconnecting(sipMachine);
	}

}