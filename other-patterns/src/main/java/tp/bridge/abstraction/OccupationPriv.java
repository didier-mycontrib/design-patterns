package tp.bridge.abstraction;

import tp.bridge.implementor.priv.TachePrivee;
import tp.bridge.implementor.priv.TachePriveeFactory;

public class OccupationPriv extends Occupation{
	private TachePrivee tachePrivee;
	
	public OccupationPriv(String typeOccupationPrivee) {
		super();
		this.tachePrivee = TachePriveeFactory.createTachePrivee(typeOccupationPrivee);
	}
	
	public OccupationPriv() {
		this(null);
	}

	
	@Override
	public String toString() {
		return "OccupationPriv [tachePrivee=" + this.decrire() + "]";
	}

	public TachePrivee getTachePrivee() {
		return tachePrivee;
	}

	public void setTachePrivee(TachePrivee tachePrivee) {
		this.tachePrivee = tachePrivee;
	}

	@Override
	public String decrire() {
		return (tachePrivee!=null)?tachePrivee.decrire():"";
	}

	@Override
	public boolean isActive() {
		if(tachePrivee==null)
			return false;
		return tachePrivee.isActive();
	}

	@Override
	public void setActive(boolean active) {
		if(tachePrivee!=null)
		   tachePrivee.setActive(active);
	}
	
	
	

}
