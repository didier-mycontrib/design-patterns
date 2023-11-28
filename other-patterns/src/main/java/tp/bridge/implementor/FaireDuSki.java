package tp.bridge.implementor;

public class FaireDuSki implements Loisir{

	@Override
	public String decrire() {
		return "skier";
	}

	@Override
	public TypeLoisir getType() {
		return TypeLoisir.SPORTIF;
	}

}
