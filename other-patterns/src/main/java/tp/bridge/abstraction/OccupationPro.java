package tp.bridge.abstraction;

import tp.bridge.implementor.pro.Profession;
import tp.bridge.implementor.pro.ProfessionFactory;

public class OccupationPro extends Occupation{
	private Profession profession;
	
	public OccupationPro(String typeProfession) {
		super();
		this.profession = ProfessionFactory.createProfession(typeProfession);
	}
	
	public OccupationPro() {
		this(null);
	}

	@Override
	public String toString() {
		return "OccupationPro [profession=" + this.description() + "]";
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	@Override
	public String description() {
		return (profession!=null)?profession.decrire():"null";
	}

	@Override
	public boolean isActive() {
		if(profession==null) return false;
		return profession.isEnActivite();
	}

	@Override
	public void setActive(boolean active) {
		if(profession!=null)
		  profession.setEnActivite(active);
	}
	
	
	
	

}
