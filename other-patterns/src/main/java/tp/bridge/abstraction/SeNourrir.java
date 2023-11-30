package tp.bridge.abstraction;

import tp.bridge.implementor.alimentation.Alimentation;
import tp.bridge.implementor.alimentation.AlimentationFactory;

public class SeNourrir {
	private Alimentation alimentation;

	public SeNourrir(String TypeAlimentation) {
		this.alimentation = AlimentationFactory.createAlimentation(TypeAlimentation);
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
