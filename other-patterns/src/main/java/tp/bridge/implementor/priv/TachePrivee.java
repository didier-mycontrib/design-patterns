package tp.bridge.implementor.priv;

public abstract class TachePrivee {
	
    private boolean active;
    
    private Integer duree; //en minutes

    
	public TachePrivee(boolean active, Integer duree) {
		this.active = active;
		this.duree = duree;
	}
	
	public TachePrivee() {
		this(false,0);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String decrire() {
		return "TachePrivee[active="+active+ ",duree="+duree+"]";
	}
	
	public String toString() {
		return this.decrire();
	}


}
