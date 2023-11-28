package tp.bridge.implementor;

public class Viande implements Alimentation{

	@Override
	public String decrire() {
		return "viande";
	}

	@Override
	public TypeAlimentation getType() {
		return TypeAlimentation.OMNIVORE;
	}

}
