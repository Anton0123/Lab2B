package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;

public class SIPState{
	
	protected SIPMachine sipMachine;
	
	public SIPState(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}
	
	public SIPState ReceivedTRO(StateData stateData) throws IOException {
		SendError(stateData);
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedInvite(StateData stateData) throws IOException {
		SendError(stateData);
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedBusy(StateData stateData) throws IOException {
		SendError(stateData);
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedError(StateData stateData) {
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedBye(StateData stateData) throws IOException {
		SendError(stateData);
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedAck(StateData stateData) throws IOException {
		SendError(stateData);
		return new Waiting(sipMachine);
	}

	public SIPState SendTRO(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.TRO);
		return null;
	}

	public SIPState SendInvite(StateData stateData) throws IOException {
		//String invite = Message.INVITE + " " + stateData.get
		//sipMachine.sendMessage(stateData.getAddress(), Message.BYE);
		return null;
	}

	public SIPState SendBusy(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.BUSY);
		return null;
	}

	public SIPState SendError(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.ERROR);
		return null;
	}

	public SIPState SendBye(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.BYE);
		return new Waiting(sipMachine);
	}

	public SIPState SendAck(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.ACK);	
		return null;
	}
	
}
