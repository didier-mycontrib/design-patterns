package tp.bridge.abstraction;

import tp.bridge.implementor.loisir.Loisir;

public class SeFairePlaisir {
	private Loisir loisir;
	
	public SeFairePlaisir(Loisir loisir) {
		this.loisir = loisir;
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
