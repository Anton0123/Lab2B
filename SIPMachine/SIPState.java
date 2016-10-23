package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class SIPState{
	
	protected SIPMachine sipMachine;
	
	public SIPState(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}
	
	public void ReceivedTRO(StateData stateData) throws IOException {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedInvite(StateData stateData) throws IOException {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedBusy(StateData stateData) throws IOException {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedError(StateData stateData) {
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedBye(StateData stateData) throws IOException {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedAck(StateData stateData) throws IOException {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void SendTRO(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.TRO);
	}

	public void SendInvite(StateData stateData) throws IOException {
		//String invite = Message.INVITE + " " + stateData.get
		//sipMachine.sendMessage(stateData.getAddress(), Message.BYE);
	}

	public void SendBusy(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.BUSY);
	}

	public void SendError(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.ERROR);
	}

	public void sendBye(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.BYE);
	}

	public void SendAck(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.ACK);	
	}
	
}
