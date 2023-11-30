package tp.mediator2;

public class LightV2 extends AbstractEventColleague {
	
    private String name;
	
	public LightV2(String name,EventMediator eventMediator) {
		super(LightControlEventType.ADJUST.toString(),eventMediator);
		//with automatic eventMediator.addEventListener(mainReceivedEventType, this)
		this.name=name;
	}
	
	public LightV2(String name) {
		this(name,null);
	}
	
	public LightV2() {
		this("light_0");
	}
	
	public void adjustLight(Integer percent) {
		String statusMessage="?";
		if(percent==0) {
			statusMessage="light " + name + " off , dark";
		}
		else if(percent==100) {
			statusMessage="full light " + name + " on";
		}
		else {
			statusMessage="ajusted light " + name + " ajusted to " + percent + " %";
		}
		System.out.println("$$ " + statusMessage);
		if(eventMediator!=null)
			eventMediator.fireEvent(this, LightControlEventType.INFO.toString(), statusMessage);
	}

	@Override
	public void onEvent(String eventType, Object eventValue) {
		if(LightControlEventType.ADJUST.toString().equals(eventType)) {
			adjustLight((Integer) eventValue);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
