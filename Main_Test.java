package Lab2B;



import java.io.IOException;
import java.net.InetAddress;

import Lab2B.SIPMachine.AudioStreamUDP;
import Lab2B.SIPMachine.GlobalSettings;

public class Main_Test {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.out.println(InetAddress.getLocalHost());
		
		AudioStreamUDP stream = new AudioStreamUDP();
		stream.setSoTimeout(10000);
		stream.connectTo(InetAddress.getByName("192.168.1.53"), GlobalSettings.TCP_PORT);
		stream.startStreaming();

	}

}
