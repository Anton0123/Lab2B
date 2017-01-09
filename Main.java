package Lab2B;

import java.net.InetAddress;
import java.net.UnknownHostException;

import Lab2B.SIPMachine.UserInputThread;
public class Main {

	protected boolean incomingCall = false;
	
	public static void main(String[] args) throws UnknownHostException,
			InterruptedException {

		System.out.println(InetAddress.getLocalHost());
		
		Runnable userInputThread = new UserInputThread();
		new Thread(userInputThread).start();
		
		for(;;){}
	}
	
	
}
