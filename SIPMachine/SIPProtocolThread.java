package Lab2B.SIPMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import Lab2B.SIPMachine.SIPMachine;
import Lab2B.SIPMachine.Enums.Message;

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
			    	StateData sd = new StateData(s);
			    	String[] tmp = input.split(" ");
			    	
			    	if(GlobalSettings.DEBUG)
			    		System.out.println("Debug> "+"Received message: "+input.toString());

			    	if(tmp.length==4 && Message.valueOf(tmp[0]).equals(Message.INVITE)){
			    		// INVITE ip_to ip_from voice_port
			    		try{
			    			InetAddress ip_from = InetAddress.getByName(tmp[2]);
				    		int voice_port = Integer.parseInt(tmp[3]);
				    		if(GlobalSettings.DEBUG)
					    		System.out.println("Debug> "+"voice_port:to_ip "+voice_port+":"+ip_from.getHostAddress());
				    		// put shit in statedata sd
				    		sd.setAddress(ip_from);
				    		sd.setPort(voice_port);
				    		sipMachine.receivedInvite(sd);
			    		}catch(NumberFormatException nfe){
			    			// invalid PORT
			    		}catch(UnknownHostException uhe){
			    			// invalid IP
			    		}
			    		
			    	}
			    	sd.setAddress(s.getInetAddress());
			    	
			    	try{
			    		switch(Message.valueOf(tmp[0])){
			    		case TRO:    sipMachine.receivedTRO(sd); 	break;
			    		case BUSY: 	 sipMachine.receivedBusy(sd); 	break;
			    		case ERROR:  sipMachine.receivedError(sd); 	break;
			    		case ACK: 	 sipMachine.receivedAck(sd); 	break;
			    		default: break;
			    	}
			    	}catch(Exception e){
			    		// Malformated string
			    	}
			    	
			    }
			}	

		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}
	

}
