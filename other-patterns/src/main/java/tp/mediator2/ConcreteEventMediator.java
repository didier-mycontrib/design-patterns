package tp.mediator2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcreteEventMediator implements EventMediator {
	
	//map <eventType , listOfEventListeners >
	private Map<String,List<MyEventListener>> mapEventListeners = new HashMap<>();
	

	@Override
	public void fireEvent(Object source, String eventType, Object eventValue) {
		List<MyEventListener> eventListeners = mapEventListeners.get(eventType);
		if(eventListeners!=null) {
			//Forward event to all listeners who have an interest for this eventType
			for(MyEventListener listener : eventListeners) {
				if(listener!=source)//do not forward to source in order to avoid infinite loop !
				    listener.onEvent(eventType, eventValue);
			}
		}
	}

	@Override
	public void addEventListener(String eventType, MyEventListener eventListener) {
		registerEventListenerByEventTypeInterestInMap(eventType,eventListener);
	}
	
	private  void registerEventListenerByEventTypeInterestInMap(String eventType, MyEventListener eventListener) {
		List<MyEventListener> eventListeners = mapEventListeners.get(eventType);
		if(eventListeners==null) {
			eventListeners=new ArrayList<MyEventListener>();
			mapEventListeners.put(eventType, eventListeners);
		}
		eventListeners.add(eventListener);
	}

}
