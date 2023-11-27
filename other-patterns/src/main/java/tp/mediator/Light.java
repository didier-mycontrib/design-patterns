package tp.mediator;

public class Light implements Ajustable {
	
	private RetransmitterMediator mediator;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Light(String name) {
		this.name=name;
	}


	public Light() {
		this("light_0");
	}
	


	public RetransmitterMediator getMediator() {
		return mediator;
	}

	public void setMediator(RetransmitterMediator mediator) {
		this.mediator = mediator;
	}

	public void adjust(int percent){
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
		if(mediator!=null)
			mediator.info(statusMessage);
	}

}
