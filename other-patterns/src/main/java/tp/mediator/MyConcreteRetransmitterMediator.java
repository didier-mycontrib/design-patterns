package tp.mediator;

import java.util.ArrayList;
import java.util.List;

public class MyConcreteRetransmitterMediator implements RetransmitterMediator {
	
	private List<Ajustable> ajustableColleagues = new ArrayList<>();
	private List<CanBeInformed> canBeInformedColleagues = new ArrayList<>();

	@Override
	public void sendAjustment(int percent) {
		for(Ajustable colleague : ajustableColleagues) {
			colleague.adjust(percent);
		}
	}
	
	@Override
	public void info(String message) {
		for(CanBeInformed colleague : canBeInformedColleagues) {
			colleague.info(message);
		}
	}
	
	public void addAjustable(Ajustable ajustableColleague) {
		this.ajustableColleagues.add(ajustableColleague);
	}
	
	public void addCanBeInformed(CanBeInformed canBeInformedColleague) {
		this.canBeInformedColleagues.add(canBeInformedColleague);
	}


}
