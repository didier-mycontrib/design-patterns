package tp.phone;

import org.junit.jupiter.api.Test;

import tp.phone.state.PhoneAlertState.PhoneAlertMode;

public class TestPhoneState {

	@Test
	public void testPhoneState() {
		SmartPhone smartPhone = new SmartPhone();
		smartPhone.changeAlertMode(PhoneAlertMode.RING_ALARM);
		smartPhone.alertUser();//phone_behavior = dring , dring
		smartPhone.changeAlertMode(PhoneAlertMode.VIBRATOR);
		smartPhone.alertUser();//phone_behavior = vvrr , vvrr
	}
}
