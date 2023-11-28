package tp.bridge.abstraction;

import tp.bridge.implementor.Profession;

public class Travailler {
	private Profession profession;
	
	public Travailler(Profession profession) {
		this.profession = profession;
	}
	
	public Travailler() {
		this(null);
	}

	@Override
	public String toString() {
		return "Travailler [profession=" + (profession!=null?profession.decrire():"null") + "]";
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	
	

}
