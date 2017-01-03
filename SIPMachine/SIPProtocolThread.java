package Lab2B.SIPMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import Lab2B.SIPMachine.Enums.Message;

public class SIPProtocolThread implements Runnable {

	SIPMachine sipMachine;

	public SIPProtocolThread(SIPMachine newSipMachine) {
		sipMachine = newSipMachine;
	}

	public void run() {
		ServerSocket ss;
		try {
			ss = new ServerSocket(GlobalSettings.TCP_PORT);

			Socket s;
			try {
				while ((s = ss.accept()) != null) {
					System.out.println("Client connected.");
					BufferedReader in = new BufferedReader(
							new InputStreamReader(s.getInputStream()));
					String input;
					while ((input = in.readLine()) != null) {
						System.out.println("Received: " + input);
						String[] tmp = input.split(" ");

						if (tmp.length == 4	&& Message.valueOf(tmp[0]).equals(Message.INVITE)) {
							if (userAcceptCall()) {
								try { // INVITE ip_to ip_from voice_port
									InetAddress ip_from = InetAddress
											.getByName(tmp[2]);
									int voice_port = Integer.parseInt(tmp[3]);
									sipMachine.setStateData(new StateData(ip_from));
									sipMachine.getStateData().setPort(voice_port);
									sipMachine.getStateData().setSocket();
									sipMachine.receivedInvite();
								} catch (NumberFormatException nfe) {
									// invalid PORT, drop client
									break;
								} catch (UnknownHostException uhe) {
									// invalid IP, drop client
									break;
								}
							}else{ // user declined call
								sipMachine.sendMessage(Message.BUSY);
								System.out.println("Call declined.");
							}
						}
						
						sipMachine.getStateData().setAddress(s.getInetAddress());
						System.out.println(sipMachine.getStateData().getAddress());

						try {
							switch (Message.valueOf(tmp[0])) {
							case TRO:
								sipMachine.receivedTRO();
								break;
							case BUSY:
								sipMachine.receivedBusy();
								break;
							case ERROR:
								sipMachine.receivedError();
								break;
							case ACK:
								sipMachine.receivedAck();
								break;
							case BYE:
								sipMachine.receivedBye();
								break;
							default:
								break;
							}
						} catch (Exception e) {
							System.out.println("Debug> Invalid message (SIPProtocolThread)");
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Client disconnected.");
				if(GlobalSettings.DEBUG) e.printStackTrace();
				try{
					sipMachine.getAudioStreamUDP().close();
				}catch(Exception ee){
					
				}finally{
					sipMachine.setCurrentSipState(new Waiting(sipMachine));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private boolean userAcceptCall() throws IOException{
		System.out.println("Incoming call, answer y/n?");
		BufferedReader br = GlobalSettings.INPUT;
		String tmpInput;
		synchronized (br) {
			if ((tmpInput = br.readLine()) != null) {
				return (tmpInput.toLowerCase().trim().equals("y"));
			}
		}
		return false;
	}

}
