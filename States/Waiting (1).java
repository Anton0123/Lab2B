package Lab2B.States;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import Lab2B.GlobalSettings;
import Lab2B.SIPMachine;
import Lab2B.SIPState;
import Lab2B.StateData;
import Lab2B.Enums.Message;
import Lab2B.Enums.State;

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
		Socket s = new Socket(stateData.getAddress(), GlobalSettings.TCP_PORT);
		new PrintWriter(s.getOutputStream(), true).println(Message.INVITE);
		s.close(); 
		sipMachine.setSIPState(State.RINGINGOUT);
	}


	
}