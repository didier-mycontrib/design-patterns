package tp.phone.state;

public class VibratorState implements PhoneAlertState{

	@Override
	public void alert() {
		System.out.println("vvrr vvrr");
		
	}

	@Override
	public PhoneAlertMode currentAlertMode() {
		return PhoneAlertMode.VIBRATOR;
	}

}
