package Lab2B.SIPMachine;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import Lab2B.SIPMachine.Enums.Message;

public class SIPMachine {

	private AudioStreamUDP audioStream;
	private SIPState currentSipState;
	private StateData stateData;

	public SIPMachine() {
		currentSipState = new Waiting(this);
	}

	protected void setAudioStreamUDP(AudioStreamUDP newAudioStreamUDP) {
		audioStream = newAudioStreamUDP;
	}

	public void setStateData(StateData stateData) {
		this.stateData = stateData;
	}

	public StateData getStateData() {
		return stateData;
	}

	protected AudioStreamUDP getAudioStreamUDP() {
		return audioStream;
	}

	public SIPState getCurrentSipState() {
		return currentSipState;
	}
	
	public synchronized void setCurrentSipState(SIPState state) {
		if(state!=null)
			currentSipState = state;
	}

	public void receivedInvite() throws IOException {
		setCurrentSipState(currentSipState.ReceivedInvite());
	}

	public void sendInvite() throws IOException {
		setCurrentSipState(currentSipState.SendInvite());
	}

	public void receivedTRO() throws IOException {
		setCurrentSipState(currentSipState.ReceivedTRO());
	}

	public void receivedAck() throws IOException {
		setCurrentSipState(currentSipState.ReceivedAck());
	}

	public void receivedBusy() throws IOException {
		setCurrentSipState(currentSipState.ReceivedBusy());
	}

	public void receivedError() {
		setCurrentSipState(currentSipState.ReceivedError());
	}

	public void sendBye() throws IOException {
		setCurrentSipState(currentSipState.SendBye());
	}

	public void receivedBye() throws IOException {
		setCurrentSipState(currentSipState.ReceivedBye());
	}

	protected void sendMessage(Message message) throws IOException {
		System.out.println("Sending message: " + message);
		Socket s = stateData.getSocket();
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println(message);
		out.flush();
	}

	protected void sendMessage(String message) throws IOException {
		System.out.println("Sending message: " + message);
		Socket s = stateData.getSocket();
		System.out.println("Sending through: " + s.getInetAddress() + "/" + s.getPort());
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println(message);
		out.flush();
	}
	
	public void sendDebugMessage(String message) throws IOException {
		try{
			sendMessage(message);
		}catch(NullPointerException npe){
			System.out.println("No socket set.");
		}
		
	}

}
