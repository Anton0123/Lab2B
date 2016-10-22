package Lab2B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import SIPMachine.SIPMachine;
import SIPMachine.SIPProtocolThread;
import SIPMachine.StateData;

public class Main {
	
	public static void main(String[] args) throws UnknownHostException {

		SIPMachine sip = new SIPMachine();
			
		Runnable sipProtocolThread = new SIPProtocolThread(sip);	
		new Thread(sipProtocolThread).start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       
		
		try {
			
			String in;
			while((in=br.readLine().toLowerCase())!=null){
				InetAddress ip=null; 
				if(in.equals("call")){
					System.out.println("Enter ip to call >");
					
					try{
						ip = InetAddress.getByName(br.readLine());
						sip.sendInvite(new StateData(ip));
					}catch(UnknownHostException e){
						System.out.println("Invalid address.");
					}catch(IOException e){
						e.printStackTrace();
					}
				}
				else if(in=="disconnect"){
					sip.sendBye(new StateData(ip));
				}
				else if(in=="answer"){
					// do stuff
				}else{
					System.out.println("Invalid input.");
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
