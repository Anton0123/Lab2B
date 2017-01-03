package Lab2B.SIPMachine;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Lab2B.SIPMachine.Enums.Message;

public class RingingOut extends SIPState {

	Timer timer;

	public RingingOut(SIPMachine newSIPMachine) {
		super(newSIPMachine);
		System.out.println("RingingOut");
		timer = new Timer();
		timer.schedule(new timerTask(), 10000);
	}

	class timerTask extends TimerTask {
		@Override
		public void run() {
			timer.cancel();
			cancelCall();
		}
	}

	public SIPState cancelCall() {
		System.out.println("No answer, timeout.");
		return new Waiting(sipMachine);
	}

	@Override
	public SIPState ReceivedTRO() throws IOException {
		timer.cancel();
		sipMachine.getAudioStreamUDP().startStreaming();
		sipMachine.sendMessage(Message.ACK);
		return new InSession(sipMachine);
	}

	@Override
	public SIPState ReceivedBusy() throws IOException {
		timer.cancel();
		System.out.println("Call declined.");
		return new Waiting(sipMachine);
	}

}