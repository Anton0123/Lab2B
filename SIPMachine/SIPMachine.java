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

	public void receivedInvite() throws IOException {
		SIPState nextState = currentSipState.ReceivedInvite();
		if (nextState != null)
			currentSipState = nextState;
	}

	public void sendInvite() throws IOException {
		SIPState nextState = currentSipState.SendInvite();
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedTRO() throws IOException {
		SIPState nextState = currentSipState.ReceivedTRO();
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedAck() throws IOException {
		SIPState nextState = currentSipState.ReceivedAck();
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedBusy() throws IOException {
		SIPState nextState = currentSipState.ReceivedBusy();
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedError() {
		SIPState nextState = currentSipState.ReceivedError();
		if (nextState != null)
			currentSipState = nextState;
	}

	public void sendBye() throws IOException {
		SIPState nextState = currentSipState.SendBye();
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedBye() throws IOException {
		SIPState nextState = currentSipState.ReceivedBye();
		if (nextState != null)
			currentSipState = nextState;
	}

	protected void sendMessage(Message message) throws IOException {
		System.out.println("Sending message:" + message);
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
	
	public void sendDebugMessage(String message) throws IOException{
		sendMessage(message);
	}

}
