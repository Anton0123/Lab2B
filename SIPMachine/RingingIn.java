package Lab2B.SIPMachine;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Lab2B.SIPMachine.Enums.Message;

public class RingingIn extends SIPState {

	Timer timer;

	public RingingIn(SIPMachine newSIPMachine) {
		super(newSIPMachine);
		System.out.println("RingingIn");
		timer = new Timer();
		timer.schedule(new timerTask(), GlobalSettings.ANSWER_TIMER);
	}

	class timerTask extends TimerTask {
		@Override
		public void run() {
			timer.cancel();
			sipMachine.setCurrentSipState(cancelCall());
		}
	}

	public SIPState cancelCall() {
		System.out.println("No answer, timeout.");
		return new Waiting(sipMachine);
	}

	@Override
	public SIPState ReceivedInvite() throws IOException {
		timer.cancel();
		System.out.println("RingingIn - ReceivedInvite");
		sipMachine.sendMessage(Message.BUSY);
		return null;
	}

	@Override
	public SIPState ReceivedAck() throws IOException {
		timer.cancel();
		System.out.println("RingingIn - ReceivedAck");
		sipMachine.getAudioStreamUDP().startStreaming();
		return new InSession(sipMachine);
	}

	@Override
	public SIPState ReceivedBye() throws IOException {
		timer.cancel();
		System.out.println("Caller disconnected.");
		return new Waiting(sipMachine);
	}

}