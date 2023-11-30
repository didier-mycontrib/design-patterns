package tp.bridge.implementor.priv;

public class GererEnfants extends TachePrivee  {
	
	public GererEnfants() {
		this(true,90);//90mn par defaut
	}

	public GererEnfants(boolean active, Integer duree) {
		super(active, duree);
	}

	@Override
	public String decrire() {
		return "GererEnfants_" + super.decrire();
	}

}
