package tp.phone;

import tp.phone.state.PhoneAlertState;
import tp.phone.state.RingAlarmState;
import tp.phone.state.VibratorState;

public class SmartPhone {
	//PhoneAlertState as subObject of smartPhone:
	private PhoneAlertState currentPhoneAlertState = new VibratorState();//default alertState
	
	//changing state = switch of state subobject 
    public void changeAlertMode(PhoneAlertState.PhoneAlertMode alertMode) {
		switch(alertMode) {
		    case RING_ALARM:
		    	currentPhoneAlertState=new RingAlarmState();
		    	break;
		    case VIBRATOR:
		    default:
		    	currentPhoneAlertState = new VibratorState();
		}
	}
	
    //global phone_context behavior = depending on current state
	public void alertUser() {
		System.out.println("phoneAlert current mode=" 
	                       + currentPhoneAlertState.currentAlertMode().toString());
		currentPhoneAlertState.alert();
	}
}
