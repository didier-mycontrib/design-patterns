package tp.bridge.implementor;

public class Natation implements Loisir{

	@Override
	public String decrire() {
		return "natation";
	}
	
	@Override
	public TypeLoisir getType() {
		return TypeLoisir.SPORTIF;
	}

}
