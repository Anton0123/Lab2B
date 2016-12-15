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
			while ((s = ss.accept()) != null) {
				System.out.println("Client connected.");
				System.out.println(1);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				System.out.println(2);
				String input;
				System.out.println(3);
				while ((input = in.readLine()) != null) {
					System.out.println(4);
					String[] tmp = input.split(" ");

					if (tmp.length == 4
							&& Message.valueOf(tmp[0]).equals(Message.INVITE)) {
						// INVITE ip_to ip_from voice_port
						try {
							InetAddress ip_from = InetAddress.getByName(tmp[2]);
							int voice_port = Integer.parseInt(tmp[3]);
							sipMachine.setStateData(new StateData(ip_from));
							sipMachine.getStateData().setAddress(ip_from);
							sipMachine.getStateData().setPort(voice_port);
							sipMachine.getStateData().setSocket();
							sipMachine.receivedInvite();
						} catch (NumberFormatException nfe) {
							// invalid PORT
						} catch (UnknownHostException uhe) {
							// invalid IP
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
						default:
							break;
						}
					} catch (Exception e) {
						// Malformated string
					}

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
