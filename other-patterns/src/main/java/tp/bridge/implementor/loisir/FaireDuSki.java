package tp.bridge.implementor.loisir;

import tp.bridge.implementor.loisir.Loisir.TypeLoisir;

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
