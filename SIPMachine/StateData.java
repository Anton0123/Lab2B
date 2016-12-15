package Lab2B.SIPMachine;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class StateData{

	private Socket clientConn;
	private PrintWriter out;
	private InetAddress address;
	private int port;

	public StateData(InetAddress address){
		this.address = address;
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
	
	public int getPort(){
		return port;
	}
	
	public void setPort(int port){
		this.port = port;
	}
	
	public void setSocket() throws IOException{
		clientConn = new Socket(address, GlobalSettings.TCP_PORT);
	}

	public Socket getSocket(){
		return clientConn;
	}
}
