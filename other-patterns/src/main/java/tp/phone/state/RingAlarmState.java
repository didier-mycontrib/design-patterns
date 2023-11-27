package tp.phone.state;

public class RingAlarmState implements PhoneAlertState{

	@Override
	public void alert() {
		System.out.println("dring dring");
		
	}

	@Override
	public PhoneAlertMode currentAlertMode() {
		return PhoneAlertMode.RING_ALARM;
	}

}
