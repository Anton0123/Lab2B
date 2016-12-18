package Lab2B;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import Lab2B.SIPMachine.GlobalSettings;
import Lab2B.SIPMachine.SIPMachine;
import Lab2B.SIPMachine.SIPProtocolThread;
import Lab2B.SIPMachine.StateData;

public class Main {

	public static void main(String[] args) throws UnknownHostException,
			InterruptedException {

		System.out.println(InetAddress.getLocalHost());

		SIPMachine sip = new SIPMachine();

		Runnable sipProtocolThread = new SIPProtocolThread(sip);
		Thread spt = new Thread(sipProtocolThread);
		spt.start();

		BufferedReader br = GlobalSettings.INPUT;
		InetAddress ip = null;
		try {

			String in;
			while (true) {
				Thread.sleep(150);
				synchronized (br) {
					if ((in = br.readLine().toLowerCase().trim()) != null) {
						if (in.equals("call")) {
							System.out.println("Enter ip to call >");
							try {
								ip = InetAddress.getByName(br.readLine().trim());
								sip.setStateData(new StateData(ip));
								sip.sendInvite();
							} catch (UnknownHostException e) {
								System.out.println("Invalid address.");
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else if (in.equals("disconnect")) {
							try {
								System.out.println("Main - Disconnect");
								sip.sendBye();
							} catch (Exception e) {
							}
						}else if(in.equals("y")){
							
						}else if(in.equals("debug")){
							System.out.println("Enter message to send>");
							sip.sendDebugMessage(br.readLine().trim());
						}else {
							System.out.println("Main - Invalid input.");
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
