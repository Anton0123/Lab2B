package Lab2B.SIPMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import Lab2B.SIPMachine.Enums.Message;

public class Waiting extends SIPState {
	
	public Waiting(SIPMachine newSIPMachine) {
		super(newSIPMachine);
		try {
			sipMachine.getStateData().getSocket().close();
		} catch (Exception e) {
		}
		sipMachine.setStateData(new StateData());
		System.out.println("Waiting");
	}

	@Override
	public SIPState ReceivedInvite() throws IOException {
		System.out.println("Incoming call from: "
				+ sipMachine.getStateData().getAddress().getHostAddress()
				+ "\nAnswer y/n?");
		BufferedReader br = GlobalSettings.INPUT;
		String tmp;
		synchronized (br) {
			if ((tmp = br.readLine()) != null) {
				if (!tmp.toLowerCase().trim().equals("y")) {
					sipMachine.sendMessage(Message.BUSY);
					System.out.println("Call declined.");
					return new Waiting(sipMachine);
				}
			}
		}
		AudioStreamUDP as = new AudioStreamUDP();
		StateData sd = sipMachine.getStateData();
		as.connectTo(sd.getAddress(), sd.getPort());
		if(GlobalSettings.DEBUG) System.out.println("Waiting,ReceivedInvite, as.connectTo - address:"+sd.getAddress()+" port:"+sd.getPort());
		sipMachine.setAudioStreamUDP(as);
		sipMachine.sendMessage(Message.TRO);
		return new RingingIn(sipMachine);
	}

	@Override
	public SIPState SendInvite() throws IOException {
		AudioStreamUDP as = new AudioStreamUDP();
		int voice_port = as.getLocalPort();
		String ip_from = InetAddress.getLocalHost().getHostAddress();
		String ip_to = sipMachine.getStateData().getAddress().getHostAddress();

		if(ip_from.equals(ip_to)) return new Waiting(sipMachine); // calling yourself
		
		sipMachine.setAudioStreamUDP(as);

		String invite = Message.INVITE + " " + ip_to + " " + ip_from + " "
				+ voice_port;

		sipMachine.getStateData().setSocket();
		sipMachine.sendMessage(invite);

		as.connectTo(InetAddress.getByName(ip_to), voice_port);
		try {
			as.setSoTimeout(15000);
			return new RingingOut(sipMachine);
		} catch (SocketException se) {
			System.out.println("No response...");
			sipMachine.setAudioStreamUDP(null);
			as.close();
			return new Waiting(sipMachine);
		}

	}

}