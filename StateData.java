package Lab2B;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class StateData{

	private Socket clientConn;
	private PrintWriter out;

	public StateData(Socket clientConn) throws IOException{
		this.clientConn = clientConn;
		out = new PrintWriter(clientConn.getOutputStream(), true);
	}

	public Socket getClientConn(){
		return clientConn;
	}
	
	public PrintWriter getOut(){
		return out;
	}

}
