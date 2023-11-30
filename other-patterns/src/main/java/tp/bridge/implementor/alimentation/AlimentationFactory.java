package tp.bridge.implementor.alimentation;

public class AlimentationFactory {
	public static Alimentation createAlimentation(String typeAlimentation) {
		if(typeAlimentation.contains("legume"))
			return new Legume();
		/* else if , else if */
		else
			return new Viande();
	}
}
