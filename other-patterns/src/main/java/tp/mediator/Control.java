package tp.mediator;

public class Control implements CanBeInformed {
	
	private RetransmitterMediator mediator;
	
	public Control(RetransmitterMediator mediator) {
		this.mediator=mediator;
	}
	
	public void turnOn() {
		mediator.sendAjustment(100);
	}
	
    public void turnOff() {
		mediator.sendAjustment(0);
	}
    
    public void modulate(int percent) {
    	mediator.sendAjustment(percent);
   	}

	@Override
	public void info(String info) {
		System.out.println("## received info by control="+info);
		
	}
}
