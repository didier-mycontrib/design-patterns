package tp.bridge.implementor.loisir;

public class Lecture implements Loisir{

	@Override
	public String decrire() {
		return "lire_livre_ou_BD";
	}

	@Override
	public TypeLoisir getType() {
		return TypeLoisir.CULTUREL;
	}
}
