package Lab2B.SIPMachine;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class StateData{

	private Socket clientConn;
	private PrintWriter out;
	private InetAddress address;

	public StateData(InetAddress address){
		this.address = address;
	}
	
	public StateData(Socket clientConn) throws IOException{
		this.clientConn = clientConn;
		out = new PrintWriter(clientConn.getOutputStream(), true);
	}
	
	public InetAddress getAddress(){
		return address;
	}

	public void setAddress(InetAddress address){
		this.address = address;
	}
	
	public Socket getClientConn(){
		return clientConn;
	}
	
	public PrintWriter getOut(){
		return out;
	}

}
