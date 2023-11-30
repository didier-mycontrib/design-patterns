package tp.mediator2;

public class ControlV2 extends AbstractEventColleague{
	
	public ControlV2(EventMediator eventMediator) {
		super(LightControlEventType.INFO.toString(), eventMediator);
	}

	@Override
	public void onEvent(String eventType, Object eventValue) {
		if(LightControlEventType.INFO.toString().equals(eventType))
		    System.out.println("## received info by control="+eventValue);
	}
	
	public void turnOn() {
		eventMediator.fireEvent(this, LightControlEventType.ADJUST.toString(), 100);  //100%
	}
	
    public void turnOff() {
    	eventMediator.fireEvent(this, LightControlEventType.ADJUST.toString(), 0);  //0%
	}
    
    public void modulate(int percent) {
    	eventMediator.fireEvent(this, LightControlEventType.ADJUST.toString(), percent);  //percent %
   	}

}
