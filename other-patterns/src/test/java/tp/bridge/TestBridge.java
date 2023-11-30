package tp.bridge;

import org.junit.jupiter.api.Test;

import tp.bridge.abstraction.Occupation;
import tp.bridge.abstraction.OccupationPriv;
import tp.bridge.abstraction.OccupationPro;
import tp.bridge.abstraction.SeFairePlaisir;
import tp.bridge.abstraction.SeFairePlaisir2;
import tp.bridge.abstraction.SeNourrir;

public class TestBridge {
	
	@Test
	public void testBridgeStyleVie(){
		
		/*
		 REMARQUE IMPORTANTE:
		 Le code de ce test n'utilise que des abstractions.
		 les "implementor" en arrière plan sont tous masqués
		 -----------------
		 Design pattern "bridge" / "pont"
		 */
		
		Occupation occupation1 = new OccupationPro("agriculteur");
		occupation1.setActive(true);
		System.out.println("occupation1="+occupation1.description() + " active=" + occupation1.isActive());
		
		Occupation occupation2 = new OccupationPriv("gerer enfants");
		occupation2.setActive(true);
		System.out.println("occupation2="+occupation2.description() + " active=" + occupation2.isActive());
		
		StyleVie styleVie1 = new StyleVie(
				new SeNourrir("viande"),
				occupation1,
				new SeFairePlaisir("Lecture")
				);
		
		System.out.println("styleVie1=" + styleVie1.toString());
		
	
		StyleVie styleVie2 = new StyleVie(
				new SeNourrir("legume"),
				occupation2,
				new SeFairePlaisir2("film","natation")
				);
		
		System.out.println("styleVie2=" + styleVie2.toString());
	}

}
