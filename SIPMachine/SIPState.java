package Lab2B.SIPMachine;

import java.io.IOException;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class SIPState{
	
	protected SIPMachine sipMachine;
	
	public SIPState(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}
	
	public void ReceivedTRO(StateData stateData) {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedInvite(StateData stateData) {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedBusy(StateData stateData) {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedError(StateData stateData) {
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedBye(StateData stateData) {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void ReceivedAck(StateData stateData) {
		SendError(stateData);
		sipMachine.setSIPState(State.WAITING);
	}

	public void SendTRO(StateData stateData) {
		stateData.getOut().print(Message.TRO);
	}

	public void SendInvite(StateData stateData) throws IOException {
		stateData.getOut().print(Message.INVITE); // OBS FIXA //
	}

	public void SendBusy(StateData stateData) {
		stateData.getOut().print(Message.BUSY);
	}

	public void SendError(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	public void sendBye(StateData stateData) {
		stateData.getOut().print(Message.BYE);
	}

	public void SendAck(StateData stateData) {
		stateData.getOut().print(Message.ACK);		
	}
	
}
