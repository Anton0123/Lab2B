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
	public void ReceivedInvite(StateData stateData) throws IOException {
		sipMachine.sendMessage(stateData.getAddress(), Message.TRO);
		if(GlobalSettings.DEBUG)
			System.out.println("Debug> sending message: "+Message.TRO);
		AudioStreamUDP as = new AudioStreamUDP();
		sipMachine.setAudioStreamUDP(as);
		as.connectTo(stateData.getAddress(), stateData.getPort());
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
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.print(invite);
		out.flush();
		s.close();
		
		as.connectTo(InetAddress.getByName(ip_to), voice_port);
		sipMachine.setSIPState(State.RINGINGOUT);
	}

	
}