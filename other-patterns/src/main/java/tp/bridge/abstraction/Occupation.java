package tp.bridge.abstraction;

//Occupation abstraite (professionnelle ou privée)
public abstract class Occupation {
	
	private boolean active;
	
	public abstract String decrire();


	public Occupation() {
		this.setActive(true);
	}

	@Override
	public String toString() {
		return decrire();
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
