package tp.bridge.abstraction;

import tp.bridge.implementor.loisir.Loisir;
import tp.bridge.implementor.loisir.LoisirFactory;

public class SeFairePlaisir {
	private Loisir loisir;
	
	public SeFairePlaisir(String  typeLoisir) {
		this.loisir = LoisirFactory.createLoisir(typeLoisir);
	}
	
	public SeFairePlaisir() {
		this(null);
	}

	@Override
	public String toString() {
		return "SeFairePlaisir [loisir=" + (loisir!=null?loisir.decrire():"") + "]";
	}

	public Loisir getLoisir() {
		return loisir;
	}

	public void setLoisir(Loisir loisir) {
		this.loisir = loisir;
	}
	
	

}
