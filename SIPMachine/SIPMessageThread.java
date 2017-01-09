
package Lab2B.SIPMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Lab2B.SIPMachine.Enums.Message;

public class SIPMessageThread implements Runnable{

	private SIPMachine sipMachine;
	private Socket client;
	
	public SIPMessageThread(SIPMachine newSipMachine, Socket newClient){
		sipMachine = newSipMachine;
		client = newClient;
	}
	
	@Override
	public void run() {
		System.out.println("Client connected.");
		String input;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			while ((input = in.readLine()) != null) {
				System.out.println("Received: " + input);
				String[] tmp = input.split(" ");
	
				if (tmp.length == 4 && Message.valueOf(tmp[0]).equals(Message.INVITE)) {
					// INVITE ip_to ip_from voice_port
					try {
						InetAddress ip_from = InetAddress.getByName(tmp[2]);
						int voice_port = Integer.parseInt(tmp[3]);
						sipMachine.setStateData(new StateData(ip_from));
						sipMachine.getStateData().setPort(voice_port);
						sipMachine.getStateData().setSocket();
						sipMachine.receivedInvite();
					} catch (NumberFormatException nfe) {
						// invalid PORT
						return;
					} catch (UnknownHostException uhe) {
						// invalid IP
						return;
					}
				}
				sipMachine.getStateData().setAddress(client.getInetAddress());
				System.out.println(sipMachine.getStateData().getAddress());
	
				if(Message.valueOf(tmp[0]).equals(Message.TRO)){
					try{
						int port = Integer.parseInt(tmp[1]);
						sipMachine.getStateData().setPort(port);
						sipMachine.receivedTRO();
					}catch(NumberFormatException nfe){
						// invalid port
						return;
					}
				}
				
				try {
					switch (Message.valueOf(tmp[0])) {
					case BUSY:	sipMachine.receivedBusy();break;
					case ERROR: sipMachine.receivedError(); break;
					case ACK: 	sipMachine.receivedAck(); break;
					case BYE:	sipMachine.receivedBye(); break;
					default: break;
					}
				} catch (Exception e) {
					if(GlobalSettings.DEBUG) System.out.println("Debug> Invalid message (SIPProtocolThread)");
				}
			}
		}catch(Exception e){
			System.out.println("Client disconnected.");
			sipMachine.getAudioStreamUDP().close();
			sipMachine.setCurrentSipState(new Waiting(sipMachine));
		}
	}
	
}