package Lab2B;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

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
	
	@Override
	public void SendInvite(StateData stateData) throws IOException{
		System.out.print("Sending invite");
		Socket s = new Socket(stateData.getAddress(),5060);
		new PrintWriter(s.getOutputStream(), true).println(Message.INVITE);
		sipMachine.setSIPState(State.RINGINGOUT);
	}


	
}