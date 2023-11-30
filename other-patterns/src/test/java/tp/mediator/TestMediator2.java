package tp.mediator;

import org.junit.jupiter.api.Test;

import tp.mediator2.ConcreteEventMediator;
import tp.mediator2.ControlV2;
import tp.mediator2.LightV2;

public class TestMediator2 {
	
	@Test
	public void testMediator() {
		
		ConcreteEventMediator eventMediator = new ConcreteEventMediator(); 
		
		LightV2[] lights = { new LightV2("light1"), 
				            new LightV2("light2"),
				            new LightV2("light3")
				           };
		for(int i=0;i<3;i++) {
			lights[i].setEventMediator(eventMediator);
			//with automatic eventMediator.addEventListener(LightControlEventType.ADJUST.toString(), lights[i]);
		}
		
		ControlV2 control = new ControlV2(eventMediator);
		//with automatic eventMediator.addEventListener(LightControlEventType.INFO.toString(), control);
		
		
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
