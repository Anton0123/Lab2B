package Lab2B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Lab2B.SIPProtocolThread;

public class Main {
	
	public static void main(String[] args) {

		SIPMachine sip = new SIPMachine();
			
		Runnable sipProtocolThread = new SIPProtocolThread(sip);	
		new Thread(sipProtocolThread).start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       
		
		try {
			
			String in;
			while((in=br.readLine().toLowerCase())!=null){
				if(in=="call"){
					System.out.println("Enter ip to call >");
					// do stuff
				}
				else if(in=="disconnect"){
					// do stuff
				}
				else if(in=="answer"){
					// do stuff
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
