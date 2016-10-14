package Lab2B;

import java.io.IOException;

public class SIPState{
	
	public void ReceivedTRO(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	public void ReceivedInvite(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	public void ReceivedBusy(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	public void ReceivedError(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	public void ReceivedBye(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	public void ReceivedAck(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	public void SendTRO(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	public void SendInvite(StateData stateData) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void SendBusy(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	public void SendError(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	public void sendBye(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	public void SendAck(StateData stateData) {
		// TODO Auto-generated method stub
		
	}
	
}
