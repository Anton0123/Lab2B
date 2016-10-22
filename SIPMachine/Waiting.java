package Lab2B.SIPMachine;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import Lab2B.SIPMachine.Enums.Message;
import Lab2B.SIPMachine.Enums.State;

public class Waiting extends SIPState {

	public Waiting(SIPMachine newSIPMachine){
		super(newSIPMachine);
	}

	@Override
	public void ReceivedInvite(StateData stateData) {
		PrintWriter out = stateData.getOut();
		out.println(Message.TRO);
		sipMachine.setSIPState(State.RINGINGIN);
	}
	
	@Override
	public void SendInvite(StateData stateData) throws IOException{
		AudioStreamUDP as = new AudioStreamUDP();
		int voice_port = as.getLocalPort();
		sipMachine.setAudioStreamUDP(as);
		String ip_from = InetAddress.getLocalHost().getHostAddress();
		String ip_to = stateData.getAddress().getHostAddress();
		
		String invite = Message.INVITE + " " + ip_to + " "+ ip_from + " " + voice_port;
		
		Socket s = new Socket(stateData.getAddress(), GlobalSettings.TCP_PORT);
		new PrintWriter(s.getOutputStream(), true).print(invite);
		s.close();
		
		as.connectTo(InetAddress.getByName(ip_to), voice_port);
		sipMachine.setSIPState(State.RINGINGOUT);
	}

	
}