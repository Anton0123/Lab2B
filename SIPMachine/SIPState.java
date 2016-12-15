package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;

public class SIPState{
	
	protected SIPMachine sipMachine;
	
	public SIPState(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}
	
	public SIPState ReceivedTRO() throws IOException {
		SendError();
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedInvite() throws IOException {
		SendError();
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedBusy() throws IOException {
		SendError();
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedError() {
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedBye() throws IOException {
		SendError();
		return new Waiting(sipMachine);
	}

	public SIPState ReceivedAck() throws IOException {
		SendError();
		return new Waiting(sipMachine);
	}

	public SIPState SendTRO() throws IOException {
		sipMachine.sendMessage(Message.TRO);
		return null;
	}

	public SIPState SendInvite() throws IOException {
		//String invite = Message.INVITE + " " + stateData.get
		//sipMachine.sendMessage(stateData.getAddress(), Message.BYE);
		return null;
	}

	public SIPState SendBusy() throws IOException {
		sipMachine.sendMessage(Message.BUSY);
		return null;
	}

	public SIPState SendError() throws IOException {
		sipMachine.sendMessage(Message.ERROR);
		return null;
	}

	public SIPState SendBye() throws IOException {
		sipMachine.sendMessage( Message.BYE);
		return new Waiting(sipMachine);
	}

	public SIPState SendAck() throws IOException {
		sipMachine.sendMessage(Message.ACK);	
		return null;
	}
	
}
