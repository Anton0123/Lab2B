package Lab2B.SIPMachine;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SIPClientThread implements Runnable {

	SIPMachine sipMachine;

	public SIPClientThread(SIPMachine newSipMachine) {
		sipMachine = newSipMachine;
	}

	public void run() {
		ServerSocket ss;
		try {
			ss = new ServerSocket(GlobalSettings.TCP_PORT);
			Socket s;
			while ((s = ss.accept()) != null) {
				Runnable sipMessageThread = new SIPMessageThread(sipMachine, s);
				new Thread(sipMessageThread).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

