package Lab2B.SIPMachine;

import java.io.IOException;
import java.util.Hashtable;

import Lab2B.SIPMachine.Enums.State;

public class SIPMachine {
	
	private AudioStreamUDP audioStream;
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
	
	protected void setAudioStreamUDP(AudioStreamUDP newAudioStreamUDP){
		audioStream = newAudioStreamUDP;
	}
	
	protected AudioStreamUDP getAudioStreamUDP(){
		return audioStream;
	}

	public void setSIPState(State newSIPState){
		currentSipState = sipStates.get(newSIPState);
	}

	public SIPState getSipState(State sipState){
		return sipStates.get(sipState);
	}

	public SIPState getCurrentSipState(){
		return currentSipState;
	}
	
	public void receivedInvite(StateData stateData){
		currentSipState.ReceivedInvite(stateData);
	}
	
	public void sendInvite(StateData stateData) throws IOException{
		currentSipState.SendInvite(stateData);
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
	
	public void sendBye(StateData stateData){
		currentSipState.sendBye(stateData);
	}
	

	
}
