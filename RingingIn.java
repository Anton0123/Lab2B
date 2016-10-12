package Lab2B;

public class RingingIn implements SIPState {

	SIPMachine sipMachine;
	
	public RingingIn(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void ReceivedTRO(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
	}

	@Override
	public void ReceivedInvite(StateData stateData) {
		stateData.getOut().print(Message.BUSY);
	}

	@Override
	public void ReceivedBusy(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
		sipMachine.setSIPState(State.WAITING);
	}

	@Override
	public void ReceivedError(StateData stateData) {
		stateData.getOut().print(Message.ERROR);
		sipMachine.setSIPState(State.WAITING);
	}

	@Override
	public void ReceivedBye(StateData stateData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReceivedAck(StateData stateData) {
		// TODO Auto-generated method stub
		
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