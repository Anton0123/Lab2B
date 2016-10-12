package Lab2B;

import java.io.PrintWriter;

public class Waiting implements SIPState {

	SIPMachine sipMachine;
	
	public Waiting(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void ReceivedTRO(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	@Override
	public void ReceivedInvite(StateData stateData) {
		PrintWriter out = stateData.getOut();
		out.print(Message.TRO);
		sipMachine.setSIPState(State.RINGINGIN);
	}

	@Override
	public void ReceivedBusy(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	@Override
	public void ReceivedError(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	@Override
	public void ReceivedBye(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	@Override
	public void ReceivedAck(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	@Override
	public void SendTRO(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendInvite(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendBusy(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendError(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendBye(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SendAck(StateData stateData) {
		// TODO Auto-generated method stub
		
	}


	
}