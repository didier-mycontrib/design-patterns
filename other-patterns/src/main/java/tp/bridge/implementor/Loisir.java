package tp.bridge.implementor;

public interface Loisir {
	public enum TypeLoisir{ SPORTIF , CULTUREL };
	public String decrire();
	public TypeLoisir getType(); //"SPORTIF" , "CULTUREL" ou ...
}
