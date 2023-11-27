package tp.phone;

import tp.phone.state.PhoneAlertState;
import tp.phone.state.RingAlarmState;
import tp.phone.state.VibratorState;

public class SmartPhone {
	//PhoneAlertState as subObject of smartPhone:
	private PhoneAlertState phoneAlertCurrentState = new VibratorState();//default alertState
	
	//changing state = switch of state subobject 
    public void changeAlertMode(PhoneAlertState.PhoneAlertMode alertMode) {
		switch(alertMode) {
		    case RING_ALARM:
		    	phoneAlertCurrentState=new RingAlarmState();
		    	break;
		    case VIBRATOR:
		    default:
		    	phoneAlertCurrentState = new VibratorState();
		}
	}
	
    //global phone_context behavior = depending on current state
	public void alertUser() {
		System.out.println("phoneAlert current mode=" 
	                       + phoneAlertCurrentState.currentAlertMode().toString());
		phoneAlertCurrentState.alert();
	}
}
