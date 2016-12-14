package Lab2B.SIPMachine;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import Lab2B.SIPMachine.Enums.Message;

public class SIPMachine {

	private AudioStreamUDP audioStream;
	private SIPState currentSipState;

	public SIPMachine() {
		currentSipState = new Waiting(this);
	}

	protected void setAudioStreamUDP(AudioStreamUDP newAudioStreamUDP) {
		audioStream = newAudioStreamUDP;
	}

	protected AudioStreamUDP getAudioStreamUDP() {
		return audioStream;
	}

	public SIPState getCurrentSipState() {
		return currentSipState;
	}

	public void receivedInvite(StateData stateData) throws IOException {
		SIPState nextState = currentSipState.ReceivedInvite(stateData);
		if (nextState != null)
			currentSipState = nextState;
	}

	public void sendInvite(StateData stateData) throws IOException {
		SIPState nextState = currentSipState.SendInvite(stateData);
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedTRO(StateData stateData) throws IOException {
		SIPState nextState = currentSipState.ReceivedTRO(stateData);
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedAck(StateData stateData) throws IOException {
		SIPState nextState = currentSipState.ReceivedAck(stateData);
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedBusy(StateData stateData) throws IOException {
		SIPState nextState = currentSipState.ReceivedBusy(stateData);
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedError(StateData stateData) {
		SIPState nextState = currentSipState.ReceivedError(stateData);
		if (nextState != null)
			currentSipState = nextState;
	}

	public void sendBye(StateData stateData) throws IOException {
		SIPState nextState = currentSipState.SendBye(stateData);
		if (nextState != null)
			currentSipState = nextState;
	}

	public void receivedBye(StateData stateData) throws IOException {
		SIPState nextState = currentSipState.ReceivedBye(stateData);
		if (nextState != null)
			currentSipState = nextState;
	}

	protected void sendMessage(InetAddress to, Message message)
			throws IOException {
		Socket s = new Socket(to, GlobalSettings.TCP_PORT);
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.print(message);
		out.flush();
		s.close();
	}

}
