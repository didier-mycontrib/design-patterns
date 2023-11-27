package tp.mediator;

import org.junit.jupiter.api.Test;

public class TestMediator {
	
	@Test
	public void testMediator() {
		MyConcreteRetransmitterMediator concreteRestransmitterMediator = new MyConcreteRetransmitterMediator(); 
		RetransmitterMediator abstractRestransmitterMediator = concreteRestransmitterMediator; 
		Light[] lights = { new Light("light1"), 
				            new Light("light2"),
				            new Light("light3")
				           };
		for(int i=0;i<3;i++) {
			lights[i].setMediator(abstractRestransmitterMediator);
			concreteRestransmitterMediator.addAjustable(lights[i]);
		}
		
		Control control = new Control(abstractRestransmitterMediator);
		concreteRestransmitterMediator.addCanBeInformed(control);
		//action indirectly sent via mediator:
		control.turnOn();
		control.modulate(50);
		control.turnOff();
		/*
		$$ full light light1 on
		## received info by control=full light light1 on
		$$ full light light2 on
		## received info by control=full light light2 on
		$$ full light light3 on
		## received info by control=full light light3 on
		$$ ajusted light light1 ajusted to 50 %
		## received info by control=ajusted light light1 ajusted to 50 %
		$$ ajusted light light2 ajusted to 50 %
		## received info by control=ajusted light light2 ajusted to 50 %
		$$ ajusted light light3 ajusted to 50 %
		## received info by control=ajusted light light3 ajusted to 50 %
		$$ light light1 off , dark
		## received info by control=light light1 off , dark
		$$ light light2 off , dark
		## received info by control=light light2 off , dark
		$$ light light3 off , dark
		## received info by control=light light3 off , dark
		 */
	}

}
