package tp.bridge.implementor.pro;

public abstract class Profession {
	
	private boolean enActivite=true;

	
	public abstract String decrire();


	public boolean isEnActivite() {
		return enActivite;
	}


	public void setEnActivite(boolean enActivite) {
		this.enActivite = enActivite;
	}
	
	


}
