package tp.mediator2;

public interface EventMediator {
	public void fireEvent(Object source,String eventType,Object eventValue);
    public void addEventListener(String eventType,MyEventListener eventListener);
}
