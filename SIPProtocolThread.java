package Lab2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Lab2B.Message;
import Lab2B.SIPMachine;

public class SIPProtocolThread implements Runnable{
	
	SIPMachine sipMachine;
	
	public SIPProtocolThread(SIPMachine newSipMachine){
		sipMachine = newSipMachine;
	}
	
	public void run(){
		ServerSocket ss;
		try {
			ss = new ServerSocket(5060);
			
			Socket s;
			while((s = ss.accept())!=null){ 
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			    
			    Message input;
			    while((input=Message.valueOf(in.readLine()))!=null){
			    	System.out.println("\033[3mDebug> \033[0mR"+"Received message: "+input.toString());
			    	switch(input){
			    		case INVITE: sipMachine.receivedInvite(); 	break;
			    		case TRO:    sipMachine.receivedTRO(); 		break;
			    		case BUSY: 	 sipMachine.receivedBusy(); 	break;
			    		case ERROR:  sipMachine.receivedError(); 	break;
			    		case ACK: 	 sipMachine.receivedAck(); 		break;
			    	}
			    }
			}	

		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}
	

}
