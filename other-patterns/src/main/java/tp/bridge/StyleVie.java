package tp.bridge;

import tp.bridge.abstraction.SeFairePlaisir;
import tp.bridge.abstraction.SeNourrir;
import tp.bridge.abstraction.Travailler;

//Bonne version de StyleVie avec abstractions complémentaires par facettes
public class StyleVie {
	private SeNourrir seNourrir;
	private Travailler travailler;
	private SeFairePlaisir seFairePlaisir;
	
	
	
	public StyleVie(SeNourrir seNourrir, Travailler travailler, SeFairePlaisir seFairePlaisir) {
		this.seNourrir = seNourrir;
		this.travailler = travailler;
		this.seFairePlaisir = seFairePlaisir;
	}
	
	public StyleVie(){
		this(null,null,null);
	}
	
	@Override
	public String toString() {
		return "StyleVie [" + seNourrir.toString() + " "  
	                        + travailler.toString() + " " 
				            + seFairePlaisir.toString() + "]";
	}
	public SeNourrir getSeNourrir() {
		return seNourrir;
	}
	public void setSeNourrir(SeNourrir seNourrir) {
		this.seNourrir = seNourrir;
	}
	public Travailler getTravailler() {
		return travailler;
	}
	public void setTravailler(Travailler travailler) {
		this.travailler = travailler;
	}
	public SeFairePlaisir getSeFairePlaisir() {
		return seFairePlaisir;
	}
	public void setSeFairePlaisir(SeFairePlaisir seFairePlaisir) {
		this.seFairePlaisir = seFairePlaisir;
	}
	
	
	
}
