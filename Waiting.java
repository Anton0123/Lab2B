package Lab2B;

import java.io.PrintWriter;

public class Waiting extends SIPState {

	SIPMachine sipMachine;
	
	public Waiting(SIPMachine newSIPMachine){
		sipMachine = newSIPMachine;
	}

	@Override
	public void ReceivedInvite(StateData stateData) {
		PrintWriter out = stateData.getOut();
		out.print(Message.TRO);
		sipMachine.setSIPState(State.RINGINGIN);
	}


	
}