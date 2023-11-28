package tp.bridge.implementor;

public interface Alimentation {
	public enum TypeAlimentation{ VEGETARIEN, OMNIVORE};
	public String decrire();
	public TypeAlimentation getType(); 
}
