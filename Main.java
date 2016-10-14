package Lab2B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
	
	public static void main(String[] args) {

		SIPMachine sip = new SIPMachine();
			
		Runnable sipProtocolThread = new SIPProtocolThread(sip);	
		new Thread(sipProtocolThread).start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       
		
		try {
			
			String in;
			while((in=br.readLine().toLowerCase())!=null){
				if(in.equals("call")){
					System.out.println("Enter ip to call >");
					InetAddress ip; 
					try{
						ip = InetAddress.getByName(br.readLine());
						sip.sendInvite(new StateData(ip));
					}catch(UnknownHostException e){
						System.out.println("Invalid address.");
					}catch(IOException e){
						e.printStackTrace();
					}
					
					// Check if ip is valid, convert to attempt to call
				}
				else if(in=="disconnect"){
					// do stuff
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
