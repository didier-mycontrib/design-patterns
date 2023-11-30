package tp.mediator2;

public abstract class AbstractEventColleague implements MyEventListener{
	
	protected EventMediator eventMediator;
	protected String mainReceivedEventType;
	
	public AbstractEventColleague(String mainReceivedEventType) {
		this.mainReceivedEventType = mainReceivedEventType;
	}
	

	public AbstractEventColleague( String mainReceivedEventType, EventMediator eventMediator) {
		this.mainReceivedEventType = mainReceivedEventType;
		this.setEventMediator(eventMediator);
	}
	

	public String getMainReceivedEventType() {
		return mainReceivedEventType;
	}

	public void setMainReceivedEventType(String mainReceivedEventType) {
		this.mainReceivedEventType = mainReceivedEventType;
	}

	public EventMediator getEventMediator() {
		return eventMediator;
	}
	
	public void setEventMediator(EventMediator eventMediator) {
		this.eventMediator = eventMediator;
		if(eventMediator!=null)
			   this.eventMediator.addEventListener(mainReceivedEventType, this);
	}

}
