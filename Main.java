package Lab2B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	public static void main(String[] args) {
		try {
			SIPMachine sip = new SIPMachine();
			
			ServerSocket ss = new ServerSocket(5060);
			
			Socket s;
			while((s = ss.accept())!=null){ // listen for INVITE, do on other thread //
				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			    
			    String input;
			    while((input=in.readLine())!=null){
			    	
			    }
			}		
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
