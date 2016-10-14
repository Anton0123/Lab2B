package Lab2B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Lab2B.SIPMachine;
import Lab2B.Enums.Message;

public class SIPProtocolThread implements Runnable{
	
	SIPMachine sipMachine;
	
	public SIPProtocolThread(SIPMachine newSipMachine){
		sipMachine = newSipMachine;
	}
	
	public void run(){
		ServerSocket ss;
		try {
			ss = new ServerSocket(GlobalSettings.TCP_PORT);
			
			Socket s;
			while((s = ss.accept())!=null){ 
				System.out.println("Client connected.");
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			    
			    String input;
			    while((input=in.readLine()) != null){
			    	if(GlobalSettings.DEBUG)
			    		System.out.println("Debug> "+"Received message: "+input.toString());

			    	StateData sd = new StateData(s);
			    	switch(Message.valueOf(input)){
		    			case INVITE: sipMachine.receivedInvite(sd); break;
			    		case TRO:    sipMachine.receivedTRO(sd); 	break;
			    		case BUSY: 	 sipMachine.receivedBusy(sd); 	break;
			    		case ERROR:  sipMachine.receivedError(sd); 	break;
			    		case ACK: 	 sipMachine.receivedAck(sd); 	break;
					default: 
						break;
			    	}
			    }
			}	

		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}
	

}
