package tp.bridge.implementor.loisir;

public interface Loisir {
	public enum TypeLoisir{ SPORTIF , CULTUREL };
	public String decrire();
	public TypeLoisir getType(); //"SPORTIF" , "CULTUREL" ou ...
}
