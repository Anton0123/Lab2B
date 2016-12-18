package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;

public class InSession extends SIPState {

	public InSession(SIPMachine newSIPMachine) {
		super(newSIPMachine);
		System.out.println("InSession");
	}

	@Override
	public SIPState ReceivedBye() throws IOException {
		sipMachine.sendMessage(Message.ACK);
		sipMachine.getAudioStreamUDP().stopStreaming();
		sipMachine.getStateData().getSocket().close();
		return new Waiting(sipMachine);
	}

	@Override
	public SIPState SendBye() throws IOException {
		sipMachine.sendMessage(Message.BYE);
		System.out.println(sipMachine.getStateData().getAddress() + " - Send to this IP");
		return new Disconnecting(sipMachine);
	}

}