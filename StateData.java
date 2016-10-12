package Lab2B;

public class StateData{

	private Socket clientConn;

	public StateData(Socket clientConn){
		this.clientConn = clientConn;
	}

	public Socket getClientConn(){
		return clientConn;
	}

}
