package tp.phone.state;

public interface PhoneAlertState {
	
	public enum PhoneAlertMode { RING_ALARM , VIBRATOR };
	public PhoneAlertMode currentAlertMode();
	public void alert();
	
}
