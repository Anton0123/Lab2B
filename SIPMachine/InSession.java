package Lab2B.SIPMachine;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class InSession extends SIPState {

	public InSession(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedBye(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.ACK);
		sipMachine.getAudioStreamUDP().stopStreaming();
		sipMachine.setSIPState(State.WAITING);
	}

	@Override
	public void sendBye(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.BYE);
		sipMachine.setSIPState(State.DISCONNECTING);
	}

	
}