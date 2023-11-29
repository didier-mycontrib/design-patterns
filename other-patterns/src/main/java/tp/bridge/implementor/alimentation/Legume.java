package tp.bridge.implementor.alimentation;

public class Legume implements Alimentation{

	@Override
	public String decrire() {
		return "legume";
	}

	@Override
	public TypeAlimentation getType() {
		return TypeAlimentation.VEGETARIEN;
	}

}
