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
	
	public static void main(String[] args) throws UnknownHostException, InterruptedException {

		System.out.println(InetAddress.getLocalHost());
		
		SIPMachine sip = new SIPMachine();
			
		Runnable sipProtocolThread = new SIPProtocolThread(sip);	
		Thread spt = new Thread(sipProtocolThread);
		spt.start();
		
		BufferedReader br = GlobalSettings.INPUT;
		InetAddress ip=null;
		try {
			
			String in;
			while(true){
				Thread.sleep(150);
				synchronized(br){
					if((in=br.readLine().toLowerCase().trim())!=null){
						if(in.equals("call")){
							System.out.println("Enter ip to call >");
							try{
								ip = InetAddress.getByName(br.readLine().trim());
								sip.sendInvite(new StateData(ip));
							}catch(UnknownHostException e){
								System.out.println("Invalid address.");
							}catch(IOException e){
								e.printStackTrace();
							}
						}
						else if(in.equals("disconnect")){
							try{
								sip.sendBye(new StateData(ip));
							}catch(Exception e){
							}
						}else{
							System.out.println("Invalid input.");
						}
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
