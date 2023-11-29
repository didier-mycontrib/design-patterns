package tp.bridge.implementor.priv;

public class FaireMenage extends TachePrivee {
	
	

	public FaireMenage() {
		super();
	}

	public FaireMenage(boolean active, Integer duree) {
		super(active, duree);
	}

	@Override
	public String decrire() {
     	return "FaireMenage_" + super.decrire();
	}

}
