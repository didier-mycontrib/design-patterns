package tp.bridge;

import org.junit.jupiter.api.Test;

import tp.bridge.abstraction.Occupation;
import tp.bridge.abstraction.OccupationPriv;
import tp.bridge.abstraction.OccupationPro;
import tp.bridge.abstraction.SeFairePlaisir;
import tp.bridge.abstraction.SeFairePlaisir2;
import tp.bridge.abstraction.SeNourrir;
import tp.bridge.implementor.alimentation.Legume;
import tp.bridge.implementor.alimentation.Viande;
import tp.bridge.implementor.loisir.Lecture;
import tp.bridge.implementor.loisir.Natation;
import tp.bridge.implementor.loisir.VisionnerFilm;

public class TestBridge {
	
	@Test
	public void testBridgeStyleVie(){
		
		Occupation occupation1 = new OccupationPro("agriculteur");
		occupation1.setActive(true);
		StyleVie styleVie1 = new StyleVie(
				new SeNourrir(new Viande()),
				occupation1,
				new SeFairePlaisir(new Lecture())
				);
		
		System.out.println("styleVie1=" + styleVie1.toString());
		
		Occupation occupation2 = new OccupationPriv("gerer enfants");
		occupation2.setActive(true);
		StyleVie styleVie2 = new StyleVie(
				new SeNourrir(new Legume()),
				occupation2,
				new SeFairePlaisir2(new VisionnerFilm(),new Natation())
				);
		
		System.out.println("styleVie2=" + styleVie2.toString());
	}

}
