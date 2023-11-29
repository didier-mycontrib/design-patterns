package tp.bridge.abstraction;

import tp.bridge.implementor.alimentation.Alimentation;

public class SeNourrir {
	private Alimentation alimentation;

	public SeNourrir(Alimentation alimentation) {
		this.alimentation = alimentation;
	}
	
	public SeNourrir() {
		this(null);
	}
	
	@Override
	public String toString() {
		return "SeNourrir [alimentation=" + (alimentation!=null?alimentation.decrire():"null") + "]";
	}

	public Alimentation getAlimentation() {
		return alimentation;
	}

	public void setAlimentation(Alimentation alimentation) {
		this.alimentation = alimentation;
	}

}
