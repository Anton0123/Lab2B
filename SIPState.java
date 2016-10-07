package Lab2B;

public interface SIPState{
	
	void ReceivedTRO();
	void ReceivedInvite();
	void ReceivedBusy();
	void ReceivedError();
	void ReceivedBye();
	void ReceivedAck();
	
	void SendInvite();
	
}
