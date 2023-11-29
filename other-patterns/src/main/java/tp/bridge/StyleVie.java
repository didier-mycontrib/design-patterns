package tp.bridge;

import tp.bridge.abstraction.SeFairePlaisir;
import tp.bridge.abstraction.SeNourrir;
import tp.bridge.abstraction.Occupation;

//Bonne version de StyleVie avec abstractions complémentaires par facettes
public class StyleVie {
	private SeNourrir seNourrir;
	private Occupation occupation;
	private SeFairePlaisir seFairePlaisir;
	
	
	
	public StyleVie(SeNourrir seNourrir, Occupation occupation, SeFairePlaisir seFairePlaisir) {
		this.seNourrir = seNourrir;
		this.occupation = occupation;
		this.seFairePlaisir = seFairePlaisir;
	}
	
	public StyleVie(){
		this(null,null,null);
	}
	
	@Override
	public String toString() {
		return "StyleVie [" + seNourrir.toString() + " "  
	                        + occupation.toString() + " " 
				            + seFairePlaisir.toString() + "]";
	}
	public SeNourrir getSeNourrir() {
		return seNourrir;
	}
	public void setSeNourrir(SeNourrir seNourrir) {
		this.seNourrir = seNourrir;
	}
	public Occupation getOccupation() {
		return occupation;
	}
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	public SeFairePlaisir getSeFairePlaisir() {
		return seFairePlaisir;
	}
	public void setSeFairePlaisir(SeFairePlaisir seFairePlaisir) {
		this.seFairePlaisir = seFairePlaisir;
	}
	
	
	
}
