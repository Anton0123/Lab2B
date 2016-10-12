package Lab2B;

import java.util.Hashtable;

public class SIPMachine {
	
	private Hashtable<State, SIPState> sipStates;
	
	private SIPState currentSipState;

	public SIPMachine(){
		sipStates = new Hashtable<State, SIPState>();
		sipStates.put(State.WAITING, new Waiting(this));
		sipStates.put(State.RINGINGIN, new RingingIn(this));
		sipStates.put(State.RINGINGOUT, new RingingOut(this));
		sipStates.put(State.INSESSION, new InSession(this));
		sipStates.put(State.DISCONNECTING, new Disconnecting(this));

		currentSipState = sipStates.get(State.WAITING);
	}

	public void setSIPState(State newSIPState){
		currentSipState = sipStates.get(newSIPState);
	}
	
	
	public void receivedInvite(StateData stateData){
		currentSipState.ReceivedInvite(stateData);
	}
	
	public void receivedTRO(StateData stateData){
		currentSipState.ReceivedTRO(stateData);
	}
	
	public void receivedAck(StateData stateData){
		currentSipState.ReceivedAck(stateData);
	}

	public void receivedBusy(StateData stateData){
		currentSipState.ReceivedBusy(stateData);
	}
	
	public void receivedError(StateData stateData){
		currentSipState.ReceivedError(stateData);
	}
	

	
}
