package tp.builder.bridge;

import org.junit.jupiter.api.Test;

import tp.bridge.StyleVie;
import tp.bridge.abstraction.SeFairePlaisir;
import tp.bridge.abstraction.SeFairePlaisir2;
import tp.bridge.abstraction.SeNourrir;
import tp.bridge.abstraction.Travailler;
import tp.bridge.implementor.Agriculteur;
import tp.bridge.implementor.Informaticien;
import tp.bridge.implementor.Lecture;
import tp.bridge.implementor.Legume;
import tp.bridge.implementor.Natation;
import tp.bridge.implementor.Viande;
import tp.bridge.implementor.VisionnerFilm;

public class TestBridge {
	
	@Test
	public void testBridgeStyleVie(){
		
		StyleVie styleVie1 = new StyleVie(
				new SeNourrir(new Viande()),
				new Travailler(new Agriculteur()),
				new SeFairePlaisir(new Lecture())
				);
		
		System.out.println("styleVie1=" + styleVie1.toString());
		
		StyleVie styleVie2 = new StyleVie(
				new SeNourrir(new Legume()),
				new Travailler(new Informaticien()),
				new SeFairePlaisir2(new VisionnerFilm(),new Natation())
				);
		
		System.out.println("styleVie2=" + styleVie2.toString());
	}

}
