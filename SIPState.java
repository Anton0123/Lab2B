package Lab2B;

public interface SIPState{
	
	void ReceivedTRO(StateData stateData);
	void ReceivedInvite(StateData stateData);
	void ReceivedBusy(StateData stateData);
	void ReceivedError(StateData stateData);
	void ReceivedBye(StateData stateData);
	void ReceivedAck(StateData stateData);
	
	void SendTRO(StateData stateData);
	void SendInvite(StateData stateData);
	void SendBusy(StateData stateData);
	void SendError(StateData stateData);
	void sendBye(StateData stateData);
	void SendAck(StateData stateData);
	
}
