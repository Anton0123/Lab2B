package Lab2B.SIPMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UserInputThread implements Runnable{

	
	private SIPMachine sip;
	private BufferedReader br;
	private int answer = 0; // 0=idle, 1=incoming, 2=answer, 3=decline
	
	public UserInputThread(){
		sip = new SIPMachine(this);
		Runnable sipProtocolThread = new SIPClientThread(sip);
		new Thread(sipProtocolThread).start();
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@Override
	public void run() {
		try {
			InetAddress ip = null;
			String in;
			while (true) {
				if ((in=readIn()) != null) {
					if(answer==1){
						answer = (in.equals("y")) ? 2:3;
						continue;
					}
					if (in.equals("call")) {
						System.out.println("Enter ip to call >");
						try {
							ip = InetAddress.getByName(br.readLine().trim());
							sip.setStateData(new StateData(ip));
							try{
								sip.sendInvite();
							}catch(ConnectException ce){
								System.out.println("Could not send invite to that address.");
							}
							
						} catch (UnknownHostException e) {
							System.out.println("Invalid address.");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (in.equals("disconnect")) {
						try {
							sip.sendBye();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else if(in.equals("debug")){
						System.out.println("Enter message to send>");
						sip.sendDebugMessage(br.readLine().trim());
					}else {
						System.out.println("Main - Invalid input.");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized String readIn(){
		try{
			String tmp;
			if((tmp=br.readLine().toLowerCase().trim())!=null)
				return tmp;
		}catch(Exception e){
			if(GlobalSettings.DEBUG) e.printStackTrace();
			return null;
		}return null;
	}
	
	public boolean incomingCall(String from){
		System.out.println("Incoming call from: "+ from+ "\nAnswer y/n?");

		answer = 1;
		while(answer==1){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		boolean pickUp = answer==2;
		answer = 0;
		return !pickUp;
	}


}
